package com.robeil.demoproject.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class RateLimiter {

    private final Map<String, TokenBucket> clientBuckets = new ConcurrentHashMap<>();

    public RateLimiter(){

    }

    public void configureClient(String clientId, int maxRequests, long timeWindowInSeconds){
        clientBuckets.put(clientId, new TokenBucket(maxRequests, timeWindowInSeconds));
    }

    // Check if a request is allowed for a given client
    public boolean allowRequest(String clientId) {
        TokenBucket bucket = clientBuckets.get(clientId);
        return bucket != null && bucket.consumeToken();
    }
    private static class TokenBucket{
        private final int maxTokens;
        private final long refillIntervalMillis;
        private long lastRefillTime;
        private int tokens;


        public TokenBucket(int maxTokens, long timeWindowInSeconds) {
            this.maxTokens = maxTokens;
            this.refillIntervalMillis = TimeUnit.SECONDS.toMillis(timeWindowInSeconds);
            this.lastRefillTime = System.currentTimeMillis();
            this.tokens = maxTokens;
        }

        public synchronized boolean consumeToken(){
            refilltoken();
            if(tokens > 0){
                tokens--;
                return true;
            }
            return false;
        }

        private void refilltoken(){
            long currentTime = System.currentTimeMillis();
            long elapsedMillis = currentTime - lastRefillTime;
            int newTokens = (int) (elapsedMillis / refillIntervalMillis);
            if (newTokens > 0) {
                tokens = Math.min(tokens + newTokens, maxTokens);
                lastRefillTime = currentTime;
            }
        }
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter();
        rateLimiter.configureClient("clientA", 100, 60); // 100 requests per minute for clientA

        // Simulate requests
        for (int i = 0; i < 120; i++) {
            boolean allowed = rateLimiter.allowRequest("clientA");
            System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Denied"));
        }
    }
}
