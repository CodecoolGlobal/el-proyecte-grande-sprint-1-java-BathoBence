package com.example.undercooked.security.service;

import com.example.undercooked.model.user.Role;
import com.example.undercooked.model.user.UserEntity;
import com.example.undercooked.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.getUserEntityByName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        for (Role role : userEntity.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.name()));
        }

        return new User(userEntity.getName(), userEntity.getPassword(), roles);

    }
}
