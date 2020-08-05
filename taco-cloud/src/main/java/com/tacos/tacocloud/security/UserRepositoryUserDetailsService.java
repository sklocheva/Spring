package com.tacos.tacocloud.security;

import com.tacos.tacocloud.model.Users;
import com.tacos.tacocloud.repository.jpa.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Sophia Klocheva
 * on 7/20/2020
 */
@Service
public class UserRepositoryUserDetailsService implements UserDetailsService
{
    final UserJpaRepository userRepository;

    @Autowired
    public UserRepositoryUserDetailsService(UserJpaRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Users user = userRepository.findByUsername(username);
        if (user==null)
        {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        return user;
    }
}
