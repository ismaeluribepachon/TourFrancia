package Comunes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cifrar {

    public static String cifrar(String pass) {

        String passCifrada = null;

        MessageDigest md = null;

        if (pass != null) {
            try {
                md = MessageDigest.getInstance("SHA-512");
                md.update(pass.getBytes());
                StringBuilder sb;
                sb = new StringBuilder();
                for (byte b : md.digest()) {
                    sb.append(Integer.toHexString(0xff & b));
                }
                passCifrada = sb.toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return passCifrada;
    }
}
