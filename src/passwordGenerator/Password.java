package passwordGenerator;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * <p>
 * A object instance of this class "Password" can hold:<br>
 * - a Password (as String)<br>
 * - a MD2 Hash (as String)<br>
 * - a MD5 Hash (as String)<br>
 * - a SHA1 Hash (as String)<br>
 * - a SHA1PRNG Hash (as String)<br>
 * - a SHA224 Hash (as String)<br>
 * - a SHA256 Hash (as String)<br>
 * - a SHA384 Hash (as String)<br>
 * - a SHA512 Hash (as String)<br>
 * - the choice of the containing (as char array) characters for a generated plain text password.<br>
 * </p>
 * 
 * @version 2014-06-13
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
	private static int passwordCount;
	private String password;
	private Random random;
	private boolean useSecureRandom;

	/**
	 * @author Kevin Weis
	 * @version 2014-06-13
	 * 
	 * Contain all the Hashes, of this Password.<br>
	 */
	public enum Hash {

		@SuppressWarnings("javadoc")
		SHA1("SHA1"),
		@SuppressWarnings("javadoc")
		SHA224("SHA-224"), 
		@SuppressWarnings("javadoc")
		SHA256("SHA-256"), 
		@SuppressWarnings("javadoc")
		SHA384("SHA-384"), 
		@SuppressWarnings("javadoc")
		SHA512("SHA-512"), 
		@SuppressWarnings("javadoc")
		MD2("MD2"), 
		@SuppressWarnings("javadoc")
		MD5("MD5");

		private final String algorithmIdentifier;
		private MessageDigest messageDigest;
		private boolean isSupported;

		private Hash(String algorithmIdentifier) {
			this.algorithmIdentifier = algorithmIdentifier;
			
			try {
				this.messageDigest = MessageDigest.getInstance(this.algorithmIdentifier);
				this.isSupported = true;
				
			} catch (NoSuchAlgorithmException ex) {
				this.isSupported = false;
				
				// TODO differentiate between GUI and CLI mode
				String message = "The MessageDigest / Hashing algorithm does been provided by the Security-Provider: " + this.algorithmIdentifier;
				
				System.err.println(message + "\r\n");
				//ex.printStackTrace();
				//JOptionPane.showMessageDialog(JFramePasswordGenerator.GetPasswordGui(), ex.getMessage() + "\r\n", ex.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
			}
		}

		/**
		 * @author Kevin Weis
		 * @version 2014-06-13
		 * <p>
		 * For example:<br>
		 * Password.Hash.SHA256.Get("SecretPass".getBytes());<br>
		 * </p>
		 * 
		 * @param data A byte array to hash.
		 * @return The Hash, base 16 (HEX).
		 */
		public String Get(byte[] data) {
			String out = null;
			int countOfCharacters = this.messageDigest.getDigestLength() * 2;
			
			out = new BigInteger(1, this.GetBytes(data)).toString(16);
			
			// insert eventual timed leading zeros
			while (out != null && out.length() < countOfCharacters) {
				out = "0" + out;
			}
			
			return out;
		}
		
		/**
		 * @author Kevin Weis
		 * @version 2014-06-13
		 * <p>
		 * For example:<br>
		 * Password.Hash.SHA256.Get("SecretPass".getBytes());<br>
		 * </p>
		 * 
		 * @param data A byte array to hash.
		 * @return The Hash, byte[].
		 */
		public byte[] GetBytes(byte[] data) {
				this.messageDigest.update(data);
				return this.messageDigest.digest();
		}
		
		/**
		 * @author Kevin Weis
		 * @version 2014-06-13
		 * 
		 * @return If the Hashing algorithm is been available by the Security Provider.
		 */
		public boolean isSupported() {
			return this.isSupported;
		}

		/**
		 * @return name the Algorithm name.
		 */
		@Override
		public String toString() {
			return this.algorithmIdentifier;
		}
	}

	@SuppressWarnings("javadoc")
	public Password() {
		passwordCount++;
		// set SecureRandom as a good default.\
		SetUseSecureRandom(true);
	}
	
	/**
	 * @author Kevin Weis
	 * @version 2014-06-13
	 * 
	 * @param useSecureRandom which implementation of Random will be used to get random strings, default is true.
	 * @see SecureRandom
	 */
	public Password(boolean useSecureRandom) {
		passwordCount++;
		SetUseSecureRandom(useSecureRandom);
	}

	/**
	 * @author Kevin Weis
	 * @version 2014-06-13
	 * 
	 * @param password The password to set.
	 * @see Password#GetCount()
	 */
	public Password(String password) {
		this();
		this.password = password;
	}
	
	/**
	 * @author Compilenix
	 * @version 2014-06-13
	 * 
	 * @param password The password to set.
	 * @param useSecureRandom which implementation of Random will be used to get random strings, default is true.
	 * @see SecureRandom
	 */
	public Password(String password, boolean useSecureRandom) {
		this(useSecureRandom);
		this.password = password;
	}

	/**
	 * @author Compilenix
	 * @version 2014-06-13
	 * 
	 * @param choice the choice of the containing characters.
	 * @param length the length of the generated password.
	 * @see Password#GetCount()
	 */
	public Password(char[] choice, int length) {
		this();
		this.array = choice;
		this.password = GetRandomString(length);
	}

	/**
	 * @author Compilenix
	 * @version 2014-06-13
	 * 
	 * @param choice the choice of the containing characters.
	 * @param length the length of the generated password.
	 * @param useSecureRandom which implementation of Random will be used to get random strings, default is true.
	 * @see Password#GetCount()
	 * @see SecureRandom
	 */
	public Password(char[] choice, int length, boolean useSecureRandom) {
		this(useSecureRandom);
		this.array = choice;
		this.password = GetRandomString(length);
	}
	
	private final void InitRandom(boolean useSecureRandom) {
		//TODO Check for security issues by using System.nanoTime() as random seed.
		// using System.nanoTime() as random seed
		if (useSecureRandom) {
			random = new SecureRandom(ByteBuffer.allocate(8).putLong(System.nanoTime()).array());
		} else {
			random = new Random(System.nanoTime());
		}
	}
	
	private final void InitRandom(boolean useSecureRandom, byte[] seed) {
		if (useSecureRandom) {
			random = new SecureRandom(seed);
		} else {
			random = new Random(ByteBuffer.allocate(8).put(seed).getLong());
		}
	}
	
	/**
	 * @author Kevin Weis
	 * @version 2014-06-13
	 * 
	 * @return which implementation of Random will be used to get random strings, default is true.
	 * @see SecureRandom
	 */
	public final boolean GetUseSecureRandom() {
		return this.useSecureRandom;
	}
	
	/**
	 * @author Kevin Weis
	 * @version 2014-06-13
	 * 
	 * @param useSecureRandom which implementation of Random will be used to get random strings, default is true.
	 * @see SecureRandom
	 */
	public final void SetUseSecureRandom(boolean useSecureRandom) {
		this.useSecureRandom = useSecureRandom;
		InitRandom(useSecureRandom);
	}
	
	/**
	 * @author Kevin Weis
	 * @version 2014-06-13
	 * 
	 * @param useSecureRandom which implementation of Random will be used to get random strings, default is true.
	 * @param seed (>= 8 byte) If you use the SecureRandom (true) the seed will directly used by SecureRandom. If you NOT SecureRandom (false) the first 8 byte will be used to convert these into a long which will be used as the seed. 
	 * @throws Exception This will be thrown if the length of the seed is not at least 8 byte and you do not want to use the SecureRandom.
	 * @see SecureRandom
	 */
	public final void SetUseSecureRandom(boolean useSecureRandom, byte[] seed) throws Exception {
		this.useSecureRandom = useSecureRandom;
		
		if (seed.length > 7) {
			InitRandom(useSecureRandom, seed);
			
		} else if (!useSecureRandom) {
			throw new Exception("The seed has to be at least 8 byte, to be converted into an long.");
		}
	}

	/**
	 * @return returns the count of total created password objects.
	 */
	public final static int GetCount() {
		return passwordCount;
	}

	/**
	 * @param count set the total count of created password objects.
	 */
	public final static void SetCount(int count) {
		passwordCount = count;
	}

	/**
	 * Set a known password and a MD5 of it will be generated.
	 * 
	 * @param password (as String) The password to set.
	 */
	final public void Set(String password) {
		this.password = password;
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
	public final static void ResetCount() {
		passwordCount = 0;
	}

	/**
	 * @return Returns a random generated string.
	 * @param length (as int) the length of the generated password.
	 * @see SecureRandom
	 */
	private String GetRandomString(int length) {
		String out = "";
		
		for (int i = 0; i < length; i++) {
			out += array[random.nextInt(array.length - 1)];
		}
		
		return out;
	}
}
