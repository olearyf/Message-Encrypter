public class Encrypter {

    private String keyword;
    private String[] shiftedAlpha, tempAlpha;
    private final String[] alphabet = {"a", "b", "c", "d", "e",
    "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
    "s", "t", "u", "v","w", "x", "y", "z"};

    public Encrypter(String s){
        keyword = s;
        shiftedAlpha = new String[26];
        for(int i = 0; i<keyword.length(); i++) {
            shiftedAlpha[i] = "" + keyword.charAt(i);
        }
        tempAlpha = new String[26-keyword.length()];
        boolean inKeyword = false;
        int count = keyword.length();
        for(int p = 0; p<26; p++){
            inKeyword = isInKeyword(alphabet[p]);
            if(inKeyword == false) {
                shiftedAlpha[count] = alphabet[p];
                count++;
            }
            if(count == 26){
                break;
            }
        }

        for(int u = 0; u<26;u++){
            System.out.println(shiftedAlpha[u]);
        }
    }
    public boolean isInKeyword(String s) {
        boolean b = false;
        for(int k = 0; k<keyword.length();k++){
            if(s.charAt(0) == keyword.charAt(k)){
                b = true;
                break;
            }
            else{
                b = false;
            }
        }
        return b;
    }
    public String encrypt(String regular) {
        regular = regular.toLowerCase();
        String new_phrase = "";
        for(int i = 0; i<regular.length(); i++){
            char c = regular.charAt(i);
            if(Character.isLetter(c)){
                int n = 0;
                for(int p = 0; p<alphabet.length; p++){
                    System.out.println(c + "   " + alphabet[p]);
                    if(Character.toString(c).equals(alphabet[p])){
                        n = p;
                        break;
                    }
                }
                new_phrase = new_phrase + shiftedAlpha[n] + "";
            }
            else if(Character.isDigit(c)){
                new_phrase = new_phrase + c + "";
            }
            else{
                new_phrase = new_phrase + " ";
            }
        }
        return new_phrase;
    }
/*
    public String decrypt(String nonregular){
        nonregular.toLowerCase();
    }

    public void changeKeyword(String k){
        keyword = k;
        //shift alphabet
    }*/
}
