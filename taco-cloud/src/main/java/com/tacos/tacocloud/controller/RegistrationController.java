package com.tacos.tacocloud.controller;

import com.tacos.tacocloud.model.RegistrationForm;
import com.tacos.tacocloud.repository.jpa.UserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sophia Klocheva
 * on 7/21/2020
 */
@Controller
@Slf4j
@RequestMapping("/register")
public class RegistrationController
{
    private UserJpaRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserJpaRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registrationForm()
    {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form)
    {
        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
