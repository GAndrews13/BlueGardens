package com.netbuilder.model.Utility;

import java.security.SecureRandom;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Tools that enable the secure login and management of the user
 * 
 * @author gandrews
 */
public class LoginUtils {

	/**
	 * A method used to generate a 16 bit salt that can be applied to encrypt
	 * the password
	 * 
	 * @return Returns a random salt that can be used to hash the user password
	 */
	public static byte[] getNextSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return salt;
	}

	/**
	 * Used to combine the users password and the given salt to encrypt the
	 * users information
	 * 
	 * @param inPassword
	 *            The user defined password
	 * @param inSalt
	 *            The salt that has been randomly generated
	 * @return Returns the users password in its hashed form
	 * @throws Exception
	 */
	public static byte[] hash(String inPassword, byte[] inSalt)
			throws Exception {
		// Link all the elements together to form a key
		PBEKeySpec spec = new PBEKeySpec(inPassword.toCharArray(), inSalt,
				1000, 16);
		try {
			// Generate the secret key
			SecretKeyFactory skf = SecretKeyFactory
					.getInstance("PBKDF2WithHmacSHA1");
			return skf.generateSecret(spec).getEncoded();
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new Exception("broken hash system");
		} finally {
			spec.clearPassword();
		}
	}

	/**
	 * Checks to see if the provided password is the same as the hashed version
	 * on the server
	 * 
	 * @param inPassword
	 * @param inSalt
	 * @param inExpectedPassword
	 * @return
	 */
	public static boolean isExpectedPassword(String inPassword, byte[] inSalt,
			byte[] inExpectedPassword) {
		byte[] hashedUserPassword;
		try {
			hashedUserPassword = hash(inPassword, inSalt);
			if (hashedUserPassword.length != inExpectedPassword.length) {
				return false;
			}
			for (int i = 0; i < hashedUserPassword.length; i++) {
				if (hashedUserPassword[i] != inExpectedPassword[i]) {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Random password generator, used to assign temporary or new passwords
	 */
	public static String generateRandomPassword() {
		StringBuilder sb = new StringBuilder(16);
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < 16; i++) {
			int c = random.nextInt(62);

			if (c <= 9) {
				sb.append(String.valueOf(c));
			} else if (c < 36) {
				sb.append((char) ('a' + c - 10));
			} else {
				sb.append((char) ('A' + c - 36));
			}
		}
		return sb.toString();
	}
}
