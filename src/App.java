import java.io.IOException;

import components.Myszkowski;
import components.TextReader;
import components.Vigenere;

public class App {
    public static void main(String[] args) throws IOException {
        TextReader psn = new TextReader("message");
        String keyMyszkowski = "pasabg";
        String keyVigenere = "keylock";
        Vigenere v = new Vigenere();

        System.out.println("pesan : " + psn.textReader());
        System.out.println("kunci asli : " + keyVigenere);
        System.out.print("===========================");
        System.out.println();
        String ciphertext = v.encrypt(psn.textReader(), keyVigenere);
        System.out.println("Encrypt : " + v.getEncriptLowerCase());

        Myszkowski m = new Myszkowski(keyMyszkowski, ciphertext);
        m.convertKeyToNumbers();
        m.getIndexKey();
        m.createMatrix();
        String resultMyszkowski = m.rekursif();
        System.out.println("Hasil pesan gabungan : " + resultMyszkowski);
        System.out.println("Decrypt : " + v.decrypt(ciphertext, keyVigenere));
    }
}
