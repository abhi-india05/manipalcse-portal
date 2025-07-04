package manipalcse.pdc.security;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Autowired
    private JwtUtil jwtUtil;

@Override
protected void doFilterInternal(@NonNull HttpServletRequest request, 
    @NonNull HttpServletResponse response, 
    @NonNull FilterChain filterChain)
        throws ServletException, IOException {
    String jwt = parseJwt(request);
    if (jwt != null && !jwt.trim().isEmpty()) {
        // Validate the JWT token
        boolean isValid = jwtUtil.validateJwtToken(jwt);
        if (isValid) {
            // Extract the staff ID and roles from the JWT token
            String staffId = jwtUtil.getStaffIdFromJwtToken(jwt);
            List<String> roles = jwtUtil.getRolesFromJwtToken(jwt);

           List<GrantedAuthority> authorities = roles.stream()
    .map(SimpleGrantedAuthority::new)
    .collect(Collectors.toList());

UsernamePasswordAuthenticationToken authentication = 
    new UsernamePasswordAuthenticationToken(staffId, null, authorities);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
    filterChain.doFilter(request, response);
}
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        logger.info("Raw Authorization header: '{}'", headerAuth);

        if (StringUtils.hasText(headerAuth)) {
            logger.info("Authorization header has text, length: {}", headerAuth.length());
            
            if (headerAuth.startsWith("Bearer ")) {
                String token = headerAuth.substring(7).trim();
                logger.info("Extracted token length after Bearer: {}", token.length());
                logger.info("Token starts with: {}", token.length() > 10 ? token.substring(0, 10) + "..." : token);
                return token;
            } else {
                logger.warn("Authorization header does not start with 'Bearer '");
            }
        } else {
            logger.info("Authorization header is empty or null");
        }

        return null;
    }
}