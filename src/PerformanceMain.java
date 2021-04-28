import components.Performance;

public class PerformanceMain {
    public static void main(String[] args) {
        Performance p = new Performance();
        String chiperText = "29";

        int bitResult = p.convertStringToBit(chiperText);
        System.out.println(bitResult);
    }
}
