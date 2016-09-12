package main;

import java.util.Scanner;

/**
 * @author Joe
 * @version 09-04-2012
 */
public class Main {

    private static Scanner read = new Scanner(System.in);
    private static String answer = "";

    /**
     * @param args no Arguments
     */
    public static void main(String[] args) {
        String ans1 = "pw";
        String ans2 = "md5";
        //System.out.println("Username:");
        //String username = read.next();
        while (!answer.equals(ans1) && !answer.equals(ans2)) { //solange answer nicht pw ist und auch nicht md5 führe die schleife aus
            Main.ask();
            //System.out.println(answer); //ausgabe der usereingabe zum debuggen
        }
        if (answer.equals(ans1)) {
            genpw();
        } else if (answer.equals(ans2)) {
            genhash();
        }
        read.next();
        System.exit(0);
    }

    /**
     * generate the random password
     */
    public static void genpw() {
        Password normalPassword = new Password();
        System.out.println("The password is:" + normalPassword.getClearGen());
        System.out.println("The hash is:" + normalPassword.getPassword());
    }

    /**
     * generate the MD5 Hash
     */
    public static void genhash() {
        System.out.print("Passwort:");
        String pw = read.next();
        Password normalPassword = new Password(pw);
        System.out.println("The hash is:" + normalPassword.getPassword());
    }

    /**
     * @return returns the answer
     */
    public static String ask() {
        System.out.println("Do you want to generate a password and than a md5 hash? type: pw");
        System.out.println("Do you want to generate a hash of a known password? type: md5");
        answer = read.nextLine();
        return answer;
    }
}