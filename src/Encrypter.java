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
        int count = keyword.length()-1;
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
            if(s == ("" + keyword.charAt(k))){
                b= true;
            }
        }
        return b;
    }
    /*public String encrypt(String regular) {
        regular.toLowerCase();
    }

    public String decrypt(String nonregular){
        nonregular.toLowerCase();
    }

    public void changeKeyword(String k){
        keyword = k;
        //shift alphabet
    }*/
}
