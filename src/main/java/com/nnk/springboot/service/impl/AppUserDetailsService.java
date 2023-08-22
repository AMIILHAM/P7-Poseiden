package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.AppUser;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.utils.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = this.userRepository.findByUsername(username);

        if (user != null) {
            return new User(user.getUsername(),user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
        } else {
            throw new UsernameNotFoundException(ErrorMessageConstants.UsernameNotFoundExceptionMessage);
        }

    }
}
