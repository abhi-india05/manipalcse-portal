package manipalcse.pdc.security;

import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    private static final String ROLES_CLAIM = "roles";
    private static final String USERNAME_CLAIM = "preferred_username";

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private int jwtExpirationMs;

    public String generateJwtToken(Long staffId, List<String> roles) {
        if (staffId == null) {
            throw new IllegalArgumentException("Staff ID cannot be null");
        }
        if (roles == null) {
            throw new IllegalArgumentException("Roles cannot be null");
        }

        logger.debug("Generating JWT token for staff: {} with roles: {}", staffId, roles);

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        String token = Jwts.builder()
                .setSubject(staffId.toString())
                .claim(ROLES_CLAIM, roles)
                .claim(USERNAME_CLAIM, staffId)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();

        logger.debug("JWT token generated successfully for staff: {}, token length: {}", 
            staffId, token.length());
        return token;
    }

    public boolean validateJwtToken(String authToken) {
        if (!StringUtils.hasText(authToken)) {
            logger.debug("Empty or null token provided");
            return false;
        }

        try {
            logger.debug("Validating JWT token");
            Claims claims = Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(authToken)
                    .getPayload();

            Date expiration = claims.getExpiration();
            Date now = new Date();
            boolean isValid = expiration.after(now);

            if (logger.isDebugEnabled()) {
                logger.debug("JWT validation - valid: {}, expires: {}, current: {}", 
                    isValid, expiration, now);
                logger.debug("Token last 4 chars: {}", 
                    authToken.length() > 4 ? "..." + authToken.substring(authToken.length()-4) : authToken);
            }

            if (!isValid) {
                logger.warn("JWT token has expired. Expiry: {}, Current: {}", expiration, now);
            }

            return isValid;
        } catch (Exception e) {
            logger.error("JWT token validation failed: {} - {}", e.getClass().getSimpleName(), e.getMessage());
            return false;
        }
    }

    public List<String> getRolesFromJwtToken(String token) {
        try {
            logger.debug("Extracting roles from token...");
            Claims claims = Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            @SuppressWarnings("unchecked")
            List<String> roles = (List<String>) claims.get(ROLES_CLAIM);
            
            if (logger.isDebugEnabled()) {
                logger.debug("Extracted roles from token: {}", roles);
            }
            
            return roles;
        } catch (Exception e) {
            logger.error("Error extracting roles from token: {} - {}", 
                e.getClass().getSimpleName(), e.getMessage());
            throw e;
        }
    }

    public String getStaffIdFromJwtToken(String token) {
        try {
            logger.debug("Extracting staff ID from token...");
            Claims claims = Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            String staffId = claims.getSubject();
            
            if (logger.isDebugEnabled()) {
                logger.debug("Extracted staff ID from token: {}", staffId);
            }
            
            return staffId;
        } catch (Exception e) {
            logger.error("Error extracting staff ID from token: {} - {}", 
                e.getClass().getSimpleName(), e.getMessage());
            throw e;
        }
    }

    public Long getStaffIdAsLong(String token) {
        try {
            String staffId = getStaffIdFromJwtToken(token);
            return Long.parseLong(staffId);
        } catch (NumberFormatException e) {
            logger.error("Invalid staff ID format in token: {}", e.getMessage());
            throw new IllegalArgumentException("Invalid staff ID in token", e);
        }
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public boolean hasAccess(Authentication authentication, Long pathId, String requiredRole) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }

        Object principal = authentication.getPrincipal();
        
        if (principal instanceof Jwt) {
            Claims claims = (Claims) ((Jwt<?, ?>) principal).getBody();
            List<String> roles = claims.get(ROLES_CLAIM, List.class);
            String subjectId = claims.getSubject();
            
            return roles != null && 
                   roles.contains(requiredRole) && 
                   subjectId != null && 
                   subjectId.equals(pathId.toString());
        }
        return false;
    }

    // Convenience methods for each role
public boolean isAdmin(Authentication authentication, Long pathId) {
    if (authentication == null || !authentication.isAuthenticated()) {
        return false;
    }
    String authId = authentication.getName();
    return authentication.getAuthorities().stream()
           .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")) 
           && authId.equals(pathId.toString());
}

    public boolean isFaculty(Authentication authentication, Long pathId) {
    if (authentication == null || !authentication.isAuthenticated()) {
        return false;
    }
    String authId = authentication.getName();
    return authentication.getAuthorities().stream()
           .anyMatch(a -> a.getAuthority().equals("ROLE_FACULTY")) 
           && authId.equals(pathId.toString());
}

public boolean isStudent(Authentication authentication, Long pathId) {
    if (authentication == null || !authentication.isAuthenticated()) {
        return false;
    }
    String authId = authentication.getName();
    return authentication.getAuthorities().stream()
           .anyMatch(a -> a.getAuthority().equals("ROLE_STUDENT")) 
           && authId.equals(pathId.toString());
}

public boolean isAlumni(Authentication authentication, Long pathId) {
    if (authentication == null || !authentication.isAuthenticated()) {
        return false;
    }
    String authId = authentication.getName();
    return authentication.getAuthorities().stream()
           .anyMatch(a -> a.getAuthority().equals("ROLE_ALUMNI")) 
           && authId.equals(pathId.toString());
}
}