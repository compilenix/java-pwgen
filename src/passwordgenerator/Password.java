package passwordgenerator;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * A object instance of this class "Password" has:
 *  - a Password (as String)
 *  - a MD5 Hash (as String)
 *  - (as char array) the choice of the containing characters for a generated plain text password
 * @version 2012-04-19
 * @author Kevin Weis
 */
public class Password {

    private String md5;
    private String password;
    private char[] array;

    /**
     * Constructor 1: Set a known password and a MD5 of it will be generated.
     * @param password (as String) The password to set.
     */
    public Password(String password) {
        this.password = password;
        this.md5 = makeMD5(password);
    }

    /**
     * Constructor 2: A password will be generated from a known length and a choice (Checkboxes) of the containing characters than a MD5 of it.
     * @param choice (as char array) a choice (Checkboxes) of the containing characters.
     * @param length (as int) the length of the generated password.
     */
    public Password(char[] choice, int length) {
        this.array = choice;
        this.password = makeRandomString(length);
        this.md5 = makeMD5(password);
    }

    /**
     * Set a known password and a MD5 of it will be generated.
     * @param password (as String) The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
        this.md5 = makeMD5(password);
    }

    /**
     * @return Returns the MD5 Hashed password
     */
    public String getMD5() {
        return this.md5;
    }

    /**
     * @return Returns the clear text password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @return Returns a random generated string
     * @param length (as int) the length of the generated password.
     */
    private String makeRandomString(int length) {
        String out = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(array.length);
            out = out + array[idx];
        }
        return out;
    }

    /**
     * @param clear (as String) the clear text password to be hashed.
     * @return Returns the hashed password (MD5).
     */
    private String makeMD5(String clear) {
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exeption!!!" + e);
            System.exit(1);
        }
        byte[] data = clear.getBytes();
        m.update(data, 0, data.length);
        clear = new BigInteger(1, m.digest()).toString(16);
        while (clear.length() < 32) {
            clear = "0" + clear;
        }
        return clear;
    }
}
