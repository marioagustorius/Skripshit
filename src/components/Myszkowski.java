package components;

public class Myszkowski {
    public String key;
    public String keyVigenere;
    int[] matrix;
    char[][] two;
    List L = new List();

    public Myszkowski() {
    }

    public Myszkowski(String key, String keyVigenere) {
        this.key = this.removeSpace(key.toLowerCase());
        this.keyVigenere = this.removeSpace(keyVigenere.toLowerCase());
        matrix = new int[getKey().length()];
        two = new char[getKeyVigenere().length()][getKeyVigenere().length()];
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyVigenere() {
        return keyVigenere;
    }

    public void setKeyVigenere(String keyVigenere) {
        this.keyVigenere = keyVigenere;
    }

    public String removeSpace(String x) {
        String result = "";
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if (Character.isLetter(c)) {
                result += c;
            } else {
                continue;
            }
        }
        return result;
    }

    public void convertKeyToNumbers() {
        for (int i = 0; i < getKey().length(); i++) {
            char temp = getKey().charAt(i);
            if (!L.checkKey(temp)) {
                L.addChar(temp);
            }
        }
        L.sortKey();
    }

    public void getIndexKey() {
        for (int i = 0; i < getKey().length(); i++) {
            char c = getKey().charAt(i);
            matrix[i] = L.checkIndex(c);
        }
    }

    public void createMatrix() {
        int j = 0;
        for (int i = 0; i < getKeyVigenere().length(); i++) {
            char karakter = getKeyVigenere().charAt(i);
            if (j < matrix.length) {
                two[i][matrix[j]] = karakter;
            } else {
                j = 0;
                two[i][matrix[j]] = karakter;
            }
            j++;
        }
    }

    public String rekursif() {
        String result = "";
        for (int j = 1; j <= L.indexChar.size(); j++) {
            result += this.getMyszkowski(j);
        }
        return result;
    }

    public String getMyszkowski(int x) {
        String result = "";
        for (int i = 0; i < two.length; i++) {
            if (Character.isLetter(two[i][x])) {
                result += two[i][x];
            }
        }
        return result;
    }
}
