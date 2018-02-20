package id.ac.unja.si.ktmwriter;

import android.util.Log;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by norman on 2/19/18.
 */

public class EncryptLibrary {
    public static String encrypt(String input, String key){
        byte[] crypted;
        try{
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            crypted = cipher.doFinal(input.getBytes());
        }catch(Exception e){
            return e.toString();
        }
        return new String(Base64.encodeBase64(crypted));
    }

}
