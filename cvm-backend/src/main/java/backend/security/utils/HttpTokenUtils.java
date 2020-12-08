package backend.security.utils;

import backend.data.UserPrincipal;
import backend.security.dto.TokenValueDTO;
import backend.security.exception.TokenException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.StringWriter;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

public class HttpTokenUtils {

    private static final String SECRET = ".@saad!2020.10.02";

    public static TokenValueDTO generateTokenDTO(UserPrincipal u, Date dataExpiracao) {
        TokenValueDTO dto = new TokenValueDTO();
        dto.setSub(u);
        dto.setExp(dataExpiracao);
        dto.setGen(new Date());
        return dto;
    }

    public static TokenValueDTO getFromToken(String token) throws TokenException {
        try {
            byte[] encodedKey = Base64.getEncoder().encode(SECRET.getBytes());
            Key key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DES");

            //faz o parse do token e monta o body
            Claims claim = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();

            //monta o dto com data de geracao e expiracao
            TokenValueDTO dto = new TokenValueDTO();
            dto.setExp(claim.getExpiration());
            dto.setGen(new Date((Long) claim.get("gen")));

            //pega o usuario do subject
            String subject = claim.getSubject();
            ObjectMapper mapper = new ObjectMapper();
            dto.setSub(mapper.readValue(subject, UserPrincipal.class));

            return dto;

        } catch (MalformedJwtException ex) {
            throw new TokenException();
        } catch (SignatureException ex) {
            throw new TokenException();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new TokenException("Token inválido: " + ex.getMessage());
        }

    }

    public static String generateToken(UserPrincipal u, Date dataExpiracao) {
        String s = null;
        try {
            byte[] encodedKey = Base64.getEncoder().encode(SECRET.getBytes());
            Key key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DES");


            //to json string
            StringWriter writer = new StringWriter();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(writer, u);

            //monta o token passando o subject, data de expiracao e geracao
            s = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS512, key)
                    .claim("sub", writer.toString())
                    .claim("gen", new Date())
                    .setExpiration(dataExpiracao)
                    .compact();

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

}
