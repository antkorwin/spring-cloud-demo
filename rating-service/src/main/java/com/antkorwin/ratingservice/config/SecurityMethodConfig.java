package com.antkorwin.ratingservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

/**
 * Created on 25.07.2018.
 *
 * @author Korovin Anatoliy
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityMethodConfig extends GlobalMethodSecurityConfiguration {

    @Bean
    public OAuth2MethodSecurityExpressionHandler oauthExpressionHandler() {
        return new OAuth2MethodSecurityExpressionHandler();
    }
}
