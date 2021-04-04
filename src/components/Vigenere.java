package components;

public class Vigenere {

    List L = new List();
    public String encriptLowerCase;

    public Vigenere() {
    }

    public String getEncriptLowerCase() {
        return encriptLowerCase.toLowerCase();
    }

    public void setEncriptLowerCase(String encriptLowerCase) {
        this.encriptLowerCase = encriptLowerCase;
    }

    public String encrypt(final String message, final String key)
    {
        String result = "";
        int decrement = 1;

        for (int i = 0, j = 0; i < message.length(); i++) {
            
            char c = message.charAt(i);
            if (Character.isLetter(c)){
                if(Character.isUpperCase(c)) {
                    result += (char) ((c + key.toUpperCase().charAt(j) - 2 * 'A') % 26 + 'A');
                
                } else {
                    result += (char) ((c + key.toLowerCase().charAt(j) - 2 * 'a') % 26 + 'a');
                }
            } else {
                L.add(i-decrement);
                decrement++;
                continue;
            }
            j = ++j % key.length();
        }  
        setEncriptLowerCase(result);
        return result;
    }

     public String decrypt( final String message, final String key)
    {
        String result ="";
    
        for(int i = 0, j = 0; i < message.length(); i++){

            char c = message.charAt(i);
            if (Character.isLetter(c)){
                if(Character.isUpperCase(c)) {
                    result += ((char)('Z'-(25-(c-key.toUpperCase().charAt(j)))%26));

                } else {
                    result += ((char)('z'-(25-(c-key.toLowerCase().charAt(j)))%26));

                }
            } 
            if(L.checkCharacter(i)){
                result+=' ';
            }
            j = ++j % key.length();
        }
        return result;
     }

}
