package components;

public class Performance {
    
    public Performance() {
        
    }

    public int convertStringToBit(String chiper){
        int result = 0;
        char[] chars = chiper.toCharArray();
        for (char aChar : chars) {       
           result+= binaryToEightBit(String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0"));                      
        }
        return result;
        
    }

    public int binaryToEightBit(String x)
    {
        int total = 0;
        String reverse = reverseBinary(x);
        for (int i = 0; i < reverse.length(); i++) {
            char c = reverse.charAt(i);
            if(c == '1'){
                total += getBit(i);
            }
        }
        return total;
    }

    public String reverseBinary(String x){
        String result = "";
        for (int i = x.length()-1; i > -1; i--) {
            result += x.charAt(i);
        }
        return result;
    }

    public int getBit(int index){
        switch (index) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4: 
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128; 
            default:
                return 0;
        }
    }

    public double avalancheEffect(int x, int changeBit){
        String lenghtBit = String.valueOf(x);
        int totalBit = convertStringToBit(lenghtBit);
        double aE = (changeBit*100)/totalBit;
        return aE;
    }
}
