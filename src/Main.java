import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame f = new GUI();
        f.show();
    }
}
//takes a keyword
//shifts alphabet by keyword, making new reference alphabet
//scans through message, finds index of a character in normal alphabet, and the
//changes that char to the corresponding index in the new reference alphabet
//skips spaces, non letter chars
//gives an error message if a keyword is entered that contains any double characters