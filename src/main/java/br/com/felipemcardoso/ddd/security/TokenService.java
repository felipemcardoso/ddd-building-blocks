package br.com.felipemcardoso.ddd.security;


import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

/**
 * Classe utilitária que criptografa dados utilizando o algoritmo simétrico AES
 * <p>
 * Created by felipe on 3/29/15.
 */
@Component
public class TokenService {

    private static final String ALGO = "AES";

    private static final Key key = generateKey();

    private static Key generateKey() {
        byte[] chave = new byte[]{
                'A', '1', '!', 'f', 'w', '&', 'g', 'S', 'z', 'c', ')', 'a', 't', 'K', '2', '8'
        };

        return new SecretKeySpec(chave, ALGO);
    }

    public static String encrypt(String Data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] cryptoArray = cipher.doFinal(Data.getBytes());

        return new String(Base64.getEncoder().encode(cryptoArray), StandardCharsets.UTF_8);
    }

    public static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = cipher.doFinal(decordedValue);

        return new String(decValue);
    }
}
