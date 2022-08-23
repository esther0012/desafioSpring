package com.esther.DesafioSpring.util;

import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Service
public class Criptografia {

    public String encriptar(String senha) {
        try {
            String key = "Bar12345Bar12345";

            Key desKey = new SecretKeySpec(key.getBytes(), "AES");

            Cipher cifraAES = Cipher.getInstance("AES");

            cifraAES.init(Cipher.ENCRYPT_MODE, desKey);

            byte[] textoPuro = cifraAES.doFinal(senha.getBytes());

            System.out.println("Texto [Formato de Byte] : " + Arrays.toString(textoPuro));
            System.out.println("Texto Puro : " + new String(textoPuro));

            return Base64Utils.encodeToString(textoPuro);


        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException |
                 BadPaddingException e) {
            e.printStackTrace();
        }

        return "";
    }

}



