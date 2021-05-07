import components.Performance;

public class PerformanceMain {
    public static void main(String[] args) {
        Performance p = new Performance();
        String plain = "hello";
        String myszkowski = "llohe";

        String binaryResult = p.convertStringToBinary(plain);
        String myszkowskiRsult = p.convertStringToBinary(myszkowski);

        System.out.println(p.printBinary(binaryResult, 8, " "));
        System.out.println(p.printBinary(myszkowskiRsult, 8, " "));
        String xor = p.xOR(binaryResult, myszkowskiRsult);
        System.out.println(p.printBinary(xor, 8, " "));
        System.out.println();
        System.out.println("Jumlah bit berubah " + p.getChangeBit());
    }
}
