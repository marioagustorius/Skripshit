package components;

import java.util.Collections;
import java.util.LinkedList;

public class List {
    LinkedList<Integer> indexSpace;
    LinkedList<Character> indexChar;

    public List() {
        indexSpace = new LinkedList<Integer>();
        indexChar = new LinkedList<Character>();
    }

    public LinkedList<Character> getIndexChar() {
        return indexChar;
    }

    public void setIndexChar(LinkedList<Character> indexChar) {
        this.indexChar = indexChar;
    }

    public void add(int x) {
        indexSpace.add(x);
    }

    public void addChar(char x) {
        indexChar.add(x);
    }

    public boolean checkCharacter(int x) {
        for (int i = 0; i < indexSpace.size(); i++) {
            if (indexSpace.get(i) == x) {
                return true;
            }
        }
        return false;
    }

    public boolean checkKey(char x) {
        for (int i = 0; i < indexChar.size(); i++) {
            if (indexChar.get(i) == x) {
                return true;
            }
        }
        return false;
    }

    public int checkIndex(char x) {
        int temp = 0;
        for (int i = 0; i < indexChar.size(); i++) {
            if (indexChar.get(i) == x) {
                temp = i + 1;
            }
        }
        return temp;
    }

    public void sortKey() {
        Collections.sort(indexChar);
    }

    public void print() {
        for (int i = 0; i < indexSpace.size(); i++) {
            System.out.print(indexSpace.get(i) + " ");
        }
    }

}