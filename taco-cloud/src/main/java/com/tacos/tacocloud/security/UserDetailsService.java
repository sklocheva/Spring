package com.tacos.tacocloud.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Sophia Klocheva
 * on 7/20/2020
 */
public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService
{
    UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException;
}
