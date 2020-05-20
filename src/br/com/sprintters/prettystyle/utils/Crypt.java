package br.com.sprintters.prettystyle.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypt {
	public static String criptoSHAHex(String password) {
		String hashPassword = "";
		
		try {
			MessageDigest algoritmoCripto = MessageDigest.getInstance("SHA-256");
			byte[] criptoSHAHex = algoritmoCripto.digest(password.getBytes());
			
			StringBuilder hex = new StringBuilder();
			
			for (byte b : criptoSHAHex) hex.append(String.format("%02X", 0xFF & b));
			
			String shex = hex.toString();
			
			hashPassword = shex;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hashPassword;
	}
}
