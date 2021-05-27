import java.io.IOException;

import components.Performance;
import components.TextReader;
import components.Vigenere;

/**
 * VIgenereMain
 */
public class VigenereMain {
    public static void main(String[] args) throws IOException {
        TextReader psn = new TextReader("message");
        String keyVigenere = "marvnomercy";
        Vigenere v = new Vigenere();
        System.out.println("message        : " + psn.textReader());
        System.out.println("vigenere key   : " + keyVigenere);
        System.out.print("===================================");
        System.out.println();
        long startVige = System.currentTimeMillis();
        String ciphertext = v.encrypt(psn.textReader(), keyVigenere);
        long endVige = System.currentTimeMillis();
        long totalTimeVige = endVige - startVige;
        System.out.println("Encrypt vigenere   : " + v.getEncriptLowerCase());

        System.out.print("===================================");
        System.out.println();
        Performance p = new Performance();
        String plainNoSpace = v.removeHelper(psn.textReader());
        String binaryPlain = p.convertStringToBinary(plainNoSpace);
        String binaryVigenere = p.convertStringToBinary(ciphertext);

        System.out.println("Binary Plain Text   : " + p.printBinary(binaryPlain, 8, " "));
        System.out.println("Binary Myszkowski   : " + p.printBinary(binaryVigenere, 8, " "));
        String xor = p.xOR(binaryPlain, binaryVigenere);
        System.out.println("Operasi XOR         : " + p.printBinary(xor, 8, " "));
        System.out.println("Jumlah bit berubah  : " + p.getChangeBit());
        p.setTotalBit(plainNoSpace.length());
        System.out.println("Total bit           : " + p.getTotalBit());
        System.out.println("Avalanche Effect    : " + p.avalancheEffect() + " %");
    }
}