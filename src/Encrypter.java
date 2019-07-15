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
            inKeyword = false;
            for(int k = 0; k<keyword.length();k++){
                if(alphabet[p] == ("" + keyword.charAt(k))){
                    inKeyword = true;
                }
            }
            if(inKeyword != true) {
                shiftedAlpha[count] = alphabet[p];
                count++;
            }
        }

        for(int u = 0; u<26;u++){
            System.out.println(shiftedAlpha[u]);
        }
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
