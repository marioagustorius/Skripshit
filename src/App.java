import java.io.IOException;

import components.Myszkowski;
import components.TextReader;
import components.Vigenere;

public class App {
    public static void main(String[] args) throws IOException {
        TextReader psn = new TextReader("message");
        String keyMyszkowski = "pasang";
        String keyVigenere = "keylock";
        Vigenere v = new Vigenere();
        Myszkowski m = new Myszkowski(keyMyszkowski, keyVigenere);
        m.convertKeyToNumbers();
        m.getIndexKey();
        m.createMatrix();
        String resultMyszkowski = m.rekursif();

        System.out.println("pesan : " + psn.textReader());
        System.out.println("kunci asli : " + keyVigenere);
        System.out.println("Hasil kunci gabungan : " + resultMyszkowski);
        System.out.print("===========================");
        System.out.println();
        String ciphertext = v.encrypt(psn.textReader(), resultMyszkowski);
        System.out.println("Encrypt : " + v.getEncriptLowerCase());
        System.out.println("Decrypt : " + v.decrypt(ciphertext, resultMyszkowski));
    }
}
