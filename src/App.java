import java.io.IOException;

import components.Myszkowski;
import components.Performance;
import components.TextReader;
import components.Vigenere;

public class App {
    public static void main(String[] args) throws IOException {
        TextReader psn = new TextReader("message");
        String keyMyszkowski = "swindon";
        String keyVigenere = "true";
        Vigenere v = new Vigenere();

        System.out.println("message        : " + psn.textReader());
        System.out.println("vigenere key   : " + keyVigenere);
        System.out.println("myszkowski key : " + keyMyszkowski);
        System.out.print("===================================");
        System.out.println();
        String ciphertext = v.encrypt(psn.textReader(), keyVigenere);
        System.out.println("Encrypt vigenere   : " + v.getEncriptLowerCase());

        Myszkowski m = new Myszkowski(keyMyszkowski, ciphertext);
        m.convertKeyToNumbers();
        m.getIndexKey();
        m.createMatrix();
        String resultMyszkowski = m.rekursif();
        System.out.println("Encrypt Myszkowski : " + resultMyszkowski);

        System.out.print("===================================");
        System.out.println();
        Performance p = new Performance();
        System.out.println("Jumlah bit Vigenere     : "+p.convertStringToBit(ciphertext));
        System.out.println("Jumlah bit Myszkowski   : "+p.convertStringToBit(resultMyszkowski));
    }
}
