package main;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author Joe
 * @version 08-04-2012
 */
public class Password {

    private String password;
    private String clear;
    private String username;
    private SecureRandom random = new SecureRandom();
    private String randomclear;

    /**
     * @param password The password to set (MD5 will be generated)
     */
    public Password(String password) {
        this.password = makeMD5(password);
        this.clear = password;
        this.username = null;
    }

    /**
     * A Password will be generated and than a MD5 of it
     */
    public Password() {
        this.clear = randompw();
        this.password = makeMD5(clear);
        this.username = null;
    }

    /**
     * @param password The password to set (MD5 will be generated)
     */
    public void setPassword(String password) {
        this.password = makeMD5(password);
        this.clear = password;
    }

    /**
     * @param password The password to set (MD5 will be generated)
     * @param username The username to the password
     */
    public void setPassword(String password, String username) {
        this.password = makeMD5(password);
        this.clear = password;
        this.username = username;
    }

    /**
     * @return Returns the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @return Returns the user name
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @return Returns the clear text password
     */
    public String getClear() {
        return this.clear;
    }

    /**
     * @return Returns a random generated (8 Chars) password
     */
    public String getClearGen() {
        return this.randomclear;
    }

    /**
     * @return Returns a random generated (8 Chars) password
     */
    private String randompw() {
        randomclear = new BigInteger(40, random).toString(32);
        return randomclear;
    }

    /**
     * @param clear the password to be hashed
     * @return	returns the hashed password
     */
    private String makeMD5(String clear) {
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exeption!!!" + e);
            e.printStackTrace();
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
