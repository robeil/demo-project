package com.robeil.demoproject.service.empl;

import com.robeil.demoproject.domain.AppUser;
import com.robeil.demoproject.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByUserName(username);
      User.UserBuilder builder = null;
       if(user.isPresent()){
           AppUser currentUser = user.get();
           builder = org.springframework.security.core.userdetails.User.withUsername(username);
           builder.password(currentUser.getPassword());
           builder.roles(currentUser.getRole());
       }else {
           throw new UsernameNotFoundException("User not found.");
       }
        return builder.build();
    }
}
