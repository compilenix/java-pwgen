package passwordGenerator;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

import javax.swing.JOptionPane;

import passwordGenerator.windows.JFramePasswordGenerator;

/**
 * A object instance of this class "Password" can hold:<br/>
 * - a Password (as String)<br/>
 * - a MD2 Hash (as String)<br/>
 * - a MD5 Hash (as String)<br/>
 * - a SHA1 Hash (as String)<br/>
 * - a SHA256 Hash (as String)<br/>
 * - a SHA384 Hash (as String)<br/>
 * - a SHA512 Hash (as String)<br/>
 * - the choice of the containing (as char array) characters for a generated plain text password.<br/>
 * <p/>
 * 
 * @version 2013-10-08
 * @author Kevin Weis
 */
public class Password {
	/** abcdefghijklmnopqrstuvwxyz */
	public static final String AlphabetLOW = "abcdefghijklmnopqrstuvwxyz";
	/** ABCDEFGHIJKLMNOPQRSTUVWXYZ */
	public static final String AlphabetUP = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	/** \"#$%&'()*+,-./:;<=>?@! */
	public static final String Special = "!\"#$%&'()*+,-./:;<=>?@";
	/** 0123456789 */
	public static final String Numbers = "0123456789";

	private char[] array;
	private static int pwcount;
	private String password;
	private String sha1;
	private String sha256;
	private String sha384;
	private String sha512;
	private String md2;
	private String md5;

	/**
	 * Constructor 1: creates only a Object of this Class Password WITHOUT doing anything else count +1.
	 */
	public Password() {
		pwcount++;
	}

	/**
	 * Constructor 2: Create a Password Object, set the cleartext Password and count +1.
	 * <p/>
	 * 
	 * @param password (as String) The password to set.
	 */
	public Password(String password) {
		this.password = password;
		pwcount++;
	}

	/**
	 * Constructor 3: A password will be generated from a known length, a choice (Checkboxes) of the containing characters and count +1.
	 * <p/>
	 * 
	 * @param choice (as char array) the choice of the containing characters.
	 * @param length (as int) the length of the generated password.
	 */
	public Password(char[] choice, int length) {
		this.array = choice;
		this.password = makeRandomString(length);
		pwcount++;
	}

	/**
	 * @return returns the count of total created password objects.
	 */
	public final static int getCount() {
		return pwcount;
	}

	/**
	 * @param count set the total count of created password objects.
	 */
	public final static void setCount(int count) {
		pwcount = count;
	}

	/**
	 * @return Returns the MD5 Hashed password.
	 */
	final public String getMD2() {
		return this.md2;
	}

	/**
	 * @return Returns the MD5 Hashed password.
	 */
	final public String getMD5() {
		return this.md5;
	}

	/**
	 * @return Returns the clear text password.
	 */
	final public String getPassword() {
		return this.toString();
	}

	/**
	 * @return Returns the SHA-1 Hashed password.
	 */
	final public String getSHA1() {
		return this.sha1;
	}

	/**
	 * @return Returns the SHA-256 Hashed password.
	 */
	final public String getSHA256() {
		return this.sha256;
	}

	/**
	 * @return Returns the SHA-384 Hashed password.
	 */
	final public String getSHA384() {
		return this.sha384;
	}

	/**
	 * @return Returns the SHA-512 Hashed password.
	 */
	final public String getSHA512() {
		return this.sha512;
	}
	
	/**
	 * Set a known password and a MD5 of it will be generated.<br/>
	 * <p/>
	 * 
	 * @param password (as String) The password to set.
	 */
	final public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * generate a MD2 Hashed password.
	 * @return Returns the MD2 Hashed password.
	 */
	public String setMD2() {
		this.md2 = makeMD2(this.toString().getBytes());
		return this.md2;
	}

	/**
	 * generate a MD5 Hashed password.
	 * @return Returns the MD5 Hashed password.
	 */
	public String setMD5() {
		this.md5 = makeMD5(this.toString().getBytes());
		return this.md5;
	}

	/**
	 * generate a SHA-1 Hashed password.
	 * @return Returns the SHA-1 Hashed password.
	 */
	public String setSHA1() {
		this.sha1 = makeSHA1(this.toString().getBytes());
		return this.sha1;
	}

	/**
	 * generate a SHA-256 Hashed password.
	 * @return Returns the SHA-256 Hashed password.
	 */
	public String setSHA256() {
		this.sha256 = makeSHA256(this.toString().getBytes());
		return this.sha256;
	}

	/**
	 * generate a SHA-384 Hashed password.
	 * @return Returns the SHA-384 Hashed password.
	 */
	public String setSHA384() {
		this.sha384 = makeSHA384(this.toString().getBytes());
		return this.sha384;
	}

	/**
	 * generate a SHA-512 Hashed password.
	 * @return Returns the SHA-512 Hashed password.
	 */
	public String setSHA512() {
		this.sha512 = makeSHA512(this.toString().getBytes());
		return this.sha512;
	}

	/**
	 * @return Returns the clear text password.
	 */
	@Override
	public String toString() {
		return this.password;
	}

	/**
	 * reset the count of total created password objects.
	 */
	public final static void resetCount() {
		pwcount = 0;
	}

	/**
	 * @return Returns a random generated string.
	 * @param length (as int) the length of the generated password.
	 */
	private String makeRandomString(int length) {
		String out = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int idx = random.nextInt(array.length);
			out += array[idx];
		}
		return out;
	}
	
	/**
	 * @param data Data to be hased
	 * @param algo Available algorithms: SHA1, SHA256, SHA384, SHA512, MD2, MD5
	 * @return The Hash (base 16)
	 */
	public static String calculcateHash(byte[] data, String algo) {
		String clear = null;
		try {
			MessageDigest m = MessageDigest.getInstance(algo);
			m.update(data, 0, data.length);
			clear = new BigInteger(1, m.digest()).toString(16);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(JFramePasswordGenerator.getPasswordGui(), ex.getMessage(), ex.getClass().getSimpleName(), 0);
		}
		while (clear.length() < 32) {
			clear = "0" + clear;
		}
		return clear;
	}
	
	/**
	 * @param data Data to be hased
	 * @param algo Available algorithms: SHA1, SHA256, SHA384, SHA512, MD2, MD5
	 * @return The Hash (base 16)
	 * @throws Exception Undefined algorithm
	 */
	public static String calculcateHash(byte[] data, int algo) throws Exception {
		String clear = null;
		String StrAlgo = null;
		
		switch (algo) {
		case 0:
			StrAlgo = "SHA-1";
			break;
		case 1:
			StrAlgo = "SHA-256";
			break;
		case 2:
			StrAlgo = "SHA-384";
			break;
		case 3:
			StrAlgo = "SHA-512";
			break;
		case 4:
			StrAlgo = "MD2";
			break;
		case 5:
			StrAlgo = "MD5";
			break;
		}
		
		if (StrAlgo == null) {
			throw new Exception("Undefined algorithm index");
		}
		
		try {
			MessageDigest m = MessageDigest.getInstance(StrAlgo);
			m.update(data, 0, data.length);
			clear = new BigInteger(1, m.digest()).toString(16);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(JFramePasswordGenerator.getPasswordGui(), ex.getMessage(), ex.getClass().getSimpleName(), 0);
		}
		while (clear.length() < 32) {
			clear = "0" + clear;
		}
		return clear;
	}

	/**
	 * @param data (as byte array) bytes of the clear text password to be hashed.
	 * @return Returns the hashed password (MD2).
	 */
	private String makeMD2(byte[] data) {
		return calculcateHash(data, "MD2");
	}

	/**
	 * @param data (as byte array) bytes of the clear text password to be hashed.
	 * @return Returns the hashed password (MD5).
	 */
	private String makeMD5(byte[] data) {
		return calculcateHash(data, "MD5");
	}

	/**
	 * @param data (as byte array) bytes of the clear text password to be hashed.
	 * @return Returns the hashed password (SHA-1).
	 */
	private String makeSHA1(byte[] data) {
		return calculcateHash(data, "SHA-1");
	}

	/**
	 * @param data (as byte array) bytes of the clear text password to be hashed.
	 * @return Returns the hashed password (SHA-256).
	 */
	private String makeSHA256(byte[] data) {
		return calculcateHash(data, "SHA-256");
	}

	/**
	 * @param data (as byte array) bytes of the clear text password to be hashed.
	 * @return Returns the hashed password (SHA-384).
	 */
	private String makeSHA384(byte[] data) {
		return calculcateHash(data, "SHA-384");
	}

	/**
	 * @param data (as byte array) bytes of the clear text password to be hashed.
	 * @return Returns the hashed password (SHA-512).
	 */
	private String makeSHA512(byte[] data) {
		return calculcateHash(data, "SHA-512");
	}
}
