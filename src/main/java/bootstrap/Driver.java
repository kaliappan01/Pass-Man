package bootstrap;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Driver {
    static ApplicationConfig applicationConfig;

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {

    }

    public static int returnInt(short s) {
        int Integer = 24;
        char String = 'I';
//        short x = 10;
        int[] x = {120, 200, 017};
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.print(Integer);
        System.out.print(String);
        return s;
    }
}