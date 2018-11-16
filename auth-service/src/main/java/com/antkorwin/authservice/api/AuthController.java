package com.antkorwin.authservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created on 16.11.2018.
 *
 * @author Korovin Anatoliy
 */
@RestController
@RequestMapping("auth")
public class AuthController {

    @GetMapping("user")
    public Principal getPrincipal(Principal principal){
        return principal;
    }

}
