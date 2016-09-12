package passwordgenerator;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A object instance of this class "Password" has:<br/>
 * - a Password (as String)<br/>
 * - a MD5 Hash (as String)<br/>
 * - a SH1 Hash (as String)<br/>
 * - the choice of the containing (as char array)<br/>
 * characters for a generated plain text password<br/>
 * <p/>
 * @version 2012-04-19
 * @author Kevin Weis
 */
public class Password {
    private char[] array;
    private static int pwcount;
    private String password;
    private String sha1;
    private String md5;

    /**
     * Constructor 1: Set a known password and a MD5 of it will be generated.
     * <p/>
     * @param password (as String) The password to set.
     */
    public Password(String password) {
        this.password = password;
        pwcount++;
    }

    /**
     * Constructor 2: A password will be generated from a known length and a choice (Checkboxes) of the containing characters than a MD5 of it.
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
     * Constructor 3: creates only a Object of this Class Password and count + 1.
     */
    public Password() {
        pwcount++;
    }


    /**
     * @return Returns the MD5 Hashed password
     */
    public String getMD5() {
        return this.md5;
    }

    /**
     * @return Returns the SH-1 Hashed password
     */
    public String getSHA1() {
        return this.sha1;
    }

    /**
     * @return Returns the clear text password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @return returns the count of total created password objects.
     */
    static int getCount() {
        return pwcount;
    }

    /**
     * Set a known password and a MD5 of it will be generated.
     * <p/>
     * @param password (as String) The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * generate a MD5 Hashed password
     */
    public void setMD5() {
        this.md5 = makeMD5(this.password.getBytes());
    }
    
    /**
     * generate a SHA-1 Hashed password
     */
    public void setSHA1() {
        this.sha1 = makeSHA1(this.password.getBytes());
    }
    
    /**
     * reset the count of total created password objects.
     */
    static void resetCount() {
        pwcount = 0;
    }

    /**
     * @return Returns a random generated string
     * <p/>
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
            clear = new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(new JFrame("NoSuchAlgorithmException!"), ex.getMessage());
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
            clear = new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(new JFrame("NoSuchAlgorithmException!"), ex.getMessage());
        }
        while (clear.length() < 32) {
            clear = "0" + clear;
        }
        return clear;
    }
}
