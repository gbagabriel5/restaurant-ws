package com.example.Restaurant.config.security;

import com.example.Restaurant.Service.TokenService;
import com.example.Restaurant.domain.User;
import com.example.Restaurant.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationByTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    private UserRepository repository;

    public AuthenticationByTokenFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.repository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recoverToken(request);
        boolean valid = tokenService.isTokenValid(token);
        if(valid)
            authenticateClient(token);
        filterChain.doFilter(request, response);
    }

    private void authenticateClient(String token) {
        Integer idUser = tokenService.getIdUser(token);
        User user = repository.findById(idUser).get();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private String recoverToken(HttpServletRequest request) {
        String token = request.getHeader("authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer "))
            return null;
        return token.substring(7, token.length());
    }
}
