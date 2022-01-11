package se.iths.flightplanning.security.Jwt;


import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import se.iths.flightplanning.security.FlightPlannerUserPrincipal;

import java.security.SignatureException;
import java.util.Date;

@Component
public class JwtUtil  {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);


    @Value("${Flightplanning.app.jwtSecret}")
    private String jwtSecret;

    @Value("${Flightplanning.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generetateJwtToken(Authentication authentication){
        FlightPlannerUserPrincipal flightPlannerUserPrincipal = (FlightPlannerUserPrincipal) authentication.getPrincipal();

            return Jwts.builder()
                    .setSubject((flightPlannerUserPrincipal.getUsername()))
                    .setIssuedAt ( new Date())
                    .setExpiration(new Date((new Date ()).getTime() + jwtExpirationMs))
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
     }

     public String getUserNameFromJwtToken(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
     }

     public boolean validateJwtToken(String authToken){

            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;

     }


}
