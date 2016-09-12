package passwordgenerator;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * A object instance of this class "Password" has:<br/>
 * - a Password (as String)<br/>
 * - a MD5 Hash (as String)<br/>
 * - a SHA1 Hash (as String)<br/>
 * - a SHA256 Hash (as String)<br/>
 * - the choice of the containing (as char array) characters for a generated plain text password.<br/>
 * <p/>
 * @version 2.3b4
 * @author Kevin Weis
 */
public class Password {
    private char[] array;
    private static int pwcount;
    private String password;
    private String sha1;
    private String sha256;
    private String md5;
    
    /**
     * Constructor 1: creates only a Object of this Class Password WITHOUT doing anything else count +1.
     */
    public Password() {
        pwcount++;
    }

    /**
     * Constructor 2: A password will be generated from a known length, a choice (Checkboxes) of the containing characters and count +1.
     * <p/>
     * @param choice (as char array) a choice (Checkboxes) of the containing characters.
     * @param length (as int) the length of the generated password.
     */
    public Password(char[] choice, int length) {
        this.array = choice;
        this.password = makeRandomString(length);
        pwcount++;
    }

    /**
     * Constructor 3: Create a Password Object, set the cleartext Password and count +1.
     * <p/>
     * @param password (as String) The password to set.
     */
    public Password(String password) {
        this.password = password;
        pwcount++;
    }

    /**
     * @return returns the count of total created password objects.
     */
    static int getCount() {
        return pwcount;
    }
    
    /**
     * @return returns the count of total created password objects.
     */
    static void setCount(int count) {
        pwcount = count;
    }

    /**
     * @return Returns the MD5 Hashed password.
     */
    public String getMD5() {
        return this.md5;
    }

    /**
     * @return Returns the clear text password.
     */
    public String getPassword() {
        return this.toString();
    }

    /**
     * @return Returns the SHA-1 Hashed password.
     */
    public String getSHA1() {
        return this.sha1;
    }

    /**
     * @return Returns the SHA-256 Hashed password.
     */
    public String getSHA256() {
        return this.sha256;
    }
    
    /**
     * generate a MD5 Hashed password.
     */
    public void setMD5() {
        this.md5 = makeMD5(this.toString().getBytes());
    }

    /**
     * Set a known password and a MD5 of it will be generated.<br/>
     * <p/>
     * @param password (as String) The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * generate a SHA-1 Hashed password.
     */
    public void setSHA1() {
        this.sha1 = makeSHA1(this.toString().getBytes());
    }
    
    /**
     * generate a SHA-256 Hashed password.
     */
    public void setSHA256() {
        this.sha256 = makeSHA256(this.toString().getBytes());
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
    static void resetCount() {
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
     * @param data (as byte array) bytes of the clear text password to be hashed.
     * @return Returns the hashed password (MD5).
     */
    private String makeMD5(byte[] data) {
        String clear = null;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(data, 0, data.length);
            clear = new BigInteger(1, m.digest()).toString(16).toUpperCase();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
        }
        while (clear.length() < 32) {
            clear = "0" + clear;
        }
        return clear;
    }

    /**
     * @param data (as byte array) bytes of the clear text password to be hashed.
     * @return Returns the hashed password (SHA-1).
     */
    private String makeSHA1(byte[] data) {
        String clear = null;
        try {
            MessageDigest m = MessageDigest.getInstance("SHA-1");
            m.update(data, 0, data.length);
            clear = new BigInteger(1, m.digest()).toString(16).toUpperCase();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
        }
        while (clear.length() < 40) {
            clear = "0" + clear;
        }
        return clear;
    }

    /**
     * @param data (as byte array) bytes of the clear text password to be hashed.
     * @return Returns the hashed password (SHA-256).
     */
    private String makeSHA256(byte[] data) {
        String clear = null;
        try {
            MessageDigest m = MessageDigest.getInstance("SHA-256");
            m.update(data, 0, data.length);
            clear = new BigInteger(1, m.digest()).toString(16).toUpperCase();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
        }
        while (clear.length() < 64) {
            clear = "0" + clear;
        }
        return clear;
    }
}
