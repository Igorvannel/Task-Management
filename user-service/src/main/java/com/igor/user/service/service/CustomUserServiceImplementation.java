package com.igor.user.service.service;

import com.igor.user.service.model.User;
import com.igor.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class CustomUserServiceImplementation implements UserDetailsService {
   private final UserRepository userRepository;

   public CustomUserServiceImplementation(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userRepository.findByEmail(username);

      if (user == null) {
         throw new UsernameNotFoundException("User not found with email:- " + username);
      }

      List<GrantedAuthority> authorities = new ArrayList<>();

      return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
   }
}