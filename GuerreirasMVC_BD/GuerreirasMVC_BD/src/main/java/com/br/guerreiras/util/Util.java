package com.br.guerreiras.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
	
	public static String md5(String senha) throws NoSuchAlgorithmException {
		
		MessageDigest messagedig = MessageDigest.getInstance("MD5");
		BigInteger hast = new BigInteger(1, messagedig.digest(senha.getBytes()));
		return hast.toString(16);
		
	}
}
