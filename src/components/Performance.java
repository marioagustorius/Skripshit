package components;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Performance {
    ArrayList<String> xor;
    public double changeBit;
    public double totalBit;

    public Performance() {
        xor = new ArrayList<String>();
    }

    public double getChangeBit() {
        return changeBit;
    }

    public void setChangeBit(double changeBit) {
        this.changeBit = changeBit;
    }

    public double getTotalBit() {
        return totalBit;
    }

    public void setTotalBit(double totalBit) {
        this.totalBit = totalBit * 8;
    }

    public String convertStringToBinary(String input) {
        String result = "";
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result += String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0");
        }
        return result;
    }

    public String printBinary(String binary, int blockSize, String separator) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < binary.length()) {
            result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
            index += blockSize;
        }
        return result.stream().collect(Collectors.joining(separator));
    }

    public String xOR(String plainBinary, String myszkowskiBinary) {
        String result = "";
        int count = 0;
        for (int i = 0; i < plainBinary.length(); i++) {
            char p = plainBinary.charAt(i);
            char m = myszkowskiBinary.charAt(i);
            if (p == '1' && m == '1') {
                result += '0';
            }
            if (p == '1' && m == '0') {
                result += '1';
                count++;
            }
            if (p == '0' && m == '1') {
                result += '1';
                count++;
            }
            if (p == '0' && m == '0') {
                result += '0';
            }
        }
        setChangeBit(count);
        return result;
    }

    public double avalancheEffect() {
        double aE = (getChangeBit() * 100) / getTotalBit();
        return aE;
    }

    // optional method to push xor operation result to array list
    // public void addXOR(String binary) {
    // String temp = "";
    // for (int i = 0; i < binary.length(); i++) {
    // char c = binary.charAt(i);
    // if (i < 8) {
    // // System.out.print(c);
    // temp += c;
    // } else {
    // if (i % 8 == 0) {
    // xor.add(temp);
    // // System.out.print(" ");
    // temp = "";
    // }
    // temp += c;
    // // System.out.print(c);
    // }
    // }
    // xor.add(temp);
    // }

    // optional method to convert binary to decimal
    // public int binaryToDecimal() {
    // int result = 0;
    // for (int i = 0; i < xor.size(); i++) {
    // result += binaryToEightBit(xor.get(i));
    // }
    // return result;
    // }

    // optional method to get decimal value from binary
    // public int binaryToEightBit(String x) {
    // int total = 0;
    // String reverse = reverseBinary(x);
    // for (int i = 0; i < reverse.length(); i++) {
    // char c = reverse.charAt(i);
    // if (c == '1') {
    // total += getBit(i);
    // }
    // }
    // return total;
    // }

    // optional method to calculate decimal value from binary
    // public String reverseBinary(String x) {
    // String result = "";
    // for (int i = x.length() - 1; i > -1; i--) {
    // result += x.charAt(i);
    // }
    // return result;
    // }

    // optional method to initial decimal value 1 - 128
    // public int getBit(int index) {
    // switch (index) {
    // case 0:
    // return 1;
    // case 1:
    // return 2;
    // case 2:
    // return 4;
    // case 3:
    // return 8;
    // case 4:
    // return 16;
    // case 5:
    // return 32;
    // case 6:
    // return 64;
    // case 7:
    // return 128;
    // default:
    // return 0;
    // }
    // }
}
