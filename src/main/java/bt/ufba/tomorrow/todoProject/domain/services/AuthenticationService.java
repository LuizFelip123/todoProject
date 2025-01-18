package bt.ufba.tomorrow.todoProject.domain.services;

import java.util.Collections;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthenticationService {
    static final long EXPIRATIONTIME  = 1000*60*20;
    static final String SIGNINKEY  = "CURSO_JAVA_COM_SPRING_BOOT_TOMORROW_UFBA";
    static final String PREFIX = "Bearer";
    private static final SecretKey SECRETKEY = Keys.hmacShaKeyFor(SIGNINKEY.getBytes());
    static public void addToken(HttpServletResponse response, String email){

        Date now = new Date();
        Date expire = new Date(now.getTime() + EXPIRATIONTIME);
        String jwtToken = Jwts.builder()
        .claim("sub", email)
        .claim("iat",now.getTime())
        .claim("exp", expire.getTime())
        .signWith(SECRETKEY)
        .compact();

        response.addHeader("Authorization", PREFIX + " "+ jwtToken);
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
    }


    static public Authentication getAuthentication(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token != null){
            if(token.startsWith(PREFIX)) token = token.substring(PREFIX.length()).trim();
            else throw new MalformedJwtException("Invalid Authorization header format");
            Claims claims = Jwts.parser()
            .verifyWith(SECRETKEY)
            .build()
            .parseSignedClaims(token)
            .getPayload();
            String email = claims.get("sub",String.class);
            if(email != null)
                return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());

        }


        return null;
    }
}
