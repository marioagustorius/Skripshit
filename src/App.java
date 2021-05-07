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
        String plainNoSpace = m.removeHelper(psn.textReader());
        String binaryPlain = p.convertStringToBinary(plainNoSpace);
        String binaryMyszkowski = p.convertStringToBinary(resultMyszkowski);

        System.out.println("Binary Plain Text   : " + p.printBinary(binaryPlain, 8, " "));
        System.out.println("Binary Myszkowski   : " + p.printBinary(binaryMyszkowski, 8, " "));
        String xor = p.xOR(binaryPlain, binaryMyszkowski);
        System.out.println("Operasi XOR         : " + p.printBinary(xor, 8, " "));
        System.out.println("Jumlah bit berubah  : " + p.getChangeBit());
        p.setTotalBit(m.removeHelper(psn.textReader()).length());
        System.out.println("Total bit           : " + p.getTotalBit());
        System.out.println("Avalanche Effect : " + p.avalancheEffect() + " %");
    }
}
