package com.robeil.demoproject.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppUser {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(nullable = false, updatable = false)
        private long id;

        @Column(nullable = false, unique = false)
        private String userName;

        @Column(nullable = false)
        private String password;

        @Column(nullable = false)
        private String role;

        public AppUser(String userName, String password, String role){
                this.userName = userName;
                this.password = password;
                this.role = role;
        }
}
