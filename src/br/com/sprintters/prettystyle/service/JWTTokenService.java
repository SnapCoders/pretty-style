package br.com.sprintters.prettystyle.service;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import br.com.sprintters.prettystyle.model.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTTokenService {
	private static String SECRET_KEY = "f187da484711740d3c86fd374ff10465";
	
	public String signJWT(int idUser, String name, String email, String nameAndSurnameBase64) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		
		UUID uuid = UUID.randomUUID();
		
		User userFake = new User("Admin", "Master", "admin.master@prettystyle.com.br");
		
		JwtBuilder builder = Jwts.builder().setId(uuid.toString())
				.setIssuedAt(now)
				.setSubject(userFake.getEmail())
				.setIssuer(userFake.getName())
				.signWith(signatureAlgorithm, signingKey);
		
		LocalDateTime expiresDateTime = LocalDateTime.now().plusDays(30);
		Date expiresDate = Date.from(expiresDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
		long ttlMillis = expiresDate.getTime();
		
		if (ttlMillis > 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		
		String token = builder.compact();
		
		return token;
	}
}
