package com.tacos.tacocloud.model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Sophia Klocheva
 * on 7/21/2020
 */
@Data
public class RegistrationForm
{
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public Users toUser(PasswordEncoder passwordEncoder)
    {
        return new Users(
                username, passwordEncoder.encode(password),
                fullname, street, city, state, zip, phone, true);
    }
}
