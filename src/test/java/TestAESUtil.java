import domain.AesUtil;
import junit.framework.TestCase;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;
public class TestAESUtil extends TestCase{
    @Test
    public void testEncDec() throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        AesUtil testAesUtil = new AesUtil();
        String txt = "encrypted text as it is";
        String cipher = testAesUtil.encrypt(txt);
        assertEquals(txt, testAesUtil.decrypt(cipher));
    }
}
