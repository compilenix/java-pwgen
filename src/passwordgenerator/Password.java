package passwordgenerator;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @version 2012-04-16
 * @author Kevin Weis
 */
public class Password {

    private String password;
    private String clear;
    private SecureRandom random = new SecureRandom();
    private String randomclear;

    /**
     * Constructor 1 A Password will be generated and than a MD5 of it
     */
    public Password() {
        this.clear = makePw();
        this.password = makeMD5(clear);
    }

    /**
     * Constructor 2 Set a known password and a MD5 of it will be generated.
     *
     * @param password (as String) The password to set
     */
    public Password(String password) {
        this.clear = password;
        this.password = makeMD5(clear);
    }

    /**
     * Set a known password and a MD5 of it will be generated.
     *
     * @param password (as String) The password to set
     */
    public void setPassword(String password) {
        this.clear = password;
        this.password = makeMD5(clear);
    }

    /**
     * @return Returns the MD5 Hashed password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @return Returns the clear text password
     */
    public String getClear() {
        return this.clear;
    }

    /**
     * @return Returns a random generated (~8 Chars) password
     */
    private String makePw() {
        randomclear = new BigInteger(41, random).toString(32);
        return randomclear;
    }

    /**
     * @param clear the clear text password to be hashed
     * @return Returns the hashed password (MD5)
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
