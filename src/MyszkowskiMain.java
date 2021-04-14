import components.Myszkowski;

public class MyszkowskiMain {
    public static void main(String[] args) {
        String keyMyszkowski = "pasang";
        String keyVigenere = "keylock";
        Myszkowski m = new Myszkowski(keyMyszkowski, keyVigenere);
        m.convertKeyToNumbers();
        m.getIndexKey();
        m.createMatrix();
        String resultMyszkowski = m.rekursif();
        System.out.println("kunci asli : " + keyVigenere);
        System.out.println("Hasil kunci gabungan : " + resultMyszkowski);
    }
}
