/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.service;

import com.gft.grad.forum.model.ForumUser;
import com.gft.grad.forum.model.repo.ForumUserRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author izielinski
 */
@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    ForumUserRepository forumUserRepository;

    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
        ForumUser user = forumUserRepository.findByUsername(username);
        List<GrantedAuthority> authorities
                = buildUserAuthority(user);
        return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication(ForumUser user,
            List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),
                true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(ForumUser user) {
        Set<GrantedAuthority> setAuths = new HashSet<>();
        setAuths.add(new SimpleGrantedAuthority(user.getRole()));
        List<GrantedAuthority> Result = new ArrayList<>(setAuths);
        return Result;
    }

    @Autowired
    PasswordEncoder passwordEncoder;
            
    @PostConstruct
    public void initAdminUser() {
//        ForumUser user = new ForumUser();
//        user.setUsername("a");
//        user.setPassword(passwordEncoder.encode("a"));
//        user.setRole("ROLE_ADMIN");
//        forumUserRepository.save(user);
    }
}
