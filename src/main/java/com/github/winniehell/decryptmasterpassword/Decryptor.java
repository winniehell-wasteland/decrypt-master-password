package com.github.winniehell.decryptmasterpassword;

import org.sonatype.plexus.components.cipher.DefaultPlexusCipher;
import org.sonatype.plexus.components.cipher.PlexusCipher;
import org.sonatype.plexus.components.cipher.PlexusCipherException;
import org.sonatype.plexus.components.sec.dispatcher.DefaultSecDispatcher;

import java.util.Scanner;

public class Decryptor {
    public static void main(String[] args) throws PlexusCipherException {
        String encryptedPassword;

        if (System.console() != null) {
            encryptedPassword = new String(System.console().readPassword("Encrypted password: "));
        } else {
            System.out.println("Encrypted password: ");
            Scanner input = new Scanner(System.in);
            encryptedPassword = input.nextLine();
        }

        PlexusCipher cipher = new DefaultPlexusCipher();
        String passPhrase = DefaultSecDispatcher.SYSTEM_PROPERTY_SEC_LOCATION;
        String decryptedPassword = cipher.decryptDecorated(encryptedPassword, passPhrase);
        System.out.println("Decrypted password: " + decryptedPassword);
    }
}
