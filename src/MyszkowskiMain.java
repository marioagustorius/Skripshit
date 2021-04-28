import java.io.IOException;
import components.*;

public class MyszkowskiMain {
    public static void main(String[] args) throws IOException{
        TextReader psn = new TextReader("message");
        String keyMyszkowski = "pasabg";
        System.out.println("pesan : " + psn.textReader());
        System.out.println("kunci : " + keyMyszkowski);
        System.out.println("===========================");
        Myszkowski m = new Myszkowski(keyMyszkowski, psn.textReader());

        m.convertKeyToNumbers();
        m.getIndexKey();
        m.createMatrix();
        String resultMyszkowski = m.rekursif();
        System.out.println("Hasil kunci gabungan : " + resultMyszkowski);
    }
}
