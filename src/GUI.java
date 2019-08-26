import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * This is the GUI class that integrates the encrypter class with
 * the main program/user.
 */
public class GUI extends JFrame implements ActionListener {

    JTextField keyword, input;
    JLabel in, out, key, output;
    //check keyword for double chars, etc, limit length
    JButton encrypt, decrypt;
    Encrypter encr;

    /**
     *
     * No-args constructor that creates the GUI, with
     * text fields, labels, and buttons.
     *
     */
    GUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setTitle("Encrypter");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int h = (int)screenSize.getHeight();
        int w = (int)screenSize.getWidth();
        setLocation(w/2-300, h/2-150);
        setResizable(false);
        ImageIcon icon = new ImageIcon("filepath");
        setIconImage(icon.getImage());

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));

        keyword = new JTextField(15);
        input = new JTextField(30);
        output = new JLabel();
        encrypt = new JButton("Encrypt");
        decrypt = new JButton("Decrypt");
        encrypt.addActionListener(this);
        decrypt.addActionListener(this);
        in = new JLabel("Input Text: ");
        out = new JLabel("Output Text: ");
        key = new JLabel("Keyword: ");

        Box left = Box.createVerticalBox();
        left.add(in);
        left.add(Box.createVerticalStrut(10));
        left.add(input);
        //left.add(encrypt);

        Box right = Box.createVerticalBox();
        right.add(out);
        right.add(Box.createVerticalStrut(10));
        right.add(output);
        right.add(Box.createVerticalStrut(10));
        //right.add(decrypt);

        Box top = Box.createVerticalBox();
        top.add(Box.createVerticalStrut(40));
        top.add(key);
        top.add(keyword);
        top.add(Box.createVerticalStrut(40));

        Box top_container = Box.createHorizontalBox();
        top_container.add(Box.createHorizontalStrut(220));
        top_container.add(top);
        top_container.add(Box.createHorizontalStrut(220));

        Box buttons = Box.createHorizontalBox();
        buttons.add(encrypt);
        buttons.add(Box.createHorizontalStrut(40));
        buttons.add(decrypt);

        Box bottom = Box.createHorizontalBox();
        bottom.add(Box.createHorizontalStrut(40));
        bottom.add(left);
        bottom.add(Box.createHorizontalStrut(40));
        bottom.add(right);
        bottom.add(Box.createHorizontalStrut(200));

        Box mainbox = Box.createVerticalBox();
        mainbox.add(top_container);
        mainbox.add(bottom);
        mainbox.add(Box.createVerticalStrut(40));
        mainbox.add(buttons);
        mainbox.add(Box.createVerticalStrut(40));

        main.add(mainbox);
        add(main);
        
    }

    /**
     *
     * Determines whether or not a keyword has a repeated letter
     *
     * @param k is the keyword
     * @return a boolean value, stating whether or not the keyword passed or not
     *
     */

    public static boolean checkKeyword(String k){
        for(int i = 0; i<k.length();i++){
            for(int p = 0; p<k.length();p++){
                if(i != p) {
                    if (k.charAt(i) ==k.charAt(p)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    /**
     *
     * Action listener that handles the events of the buttons.
     * Creates an Encrypter object and takes user input /
     * returns the results to the user too.
     *
     * @param e allows for button presses to be recognized
     */
    public void actionPerformed(ActionEvent e){
        String k_word = keyword.getText();
        if(checkKeyword(k_word) == false){
            JOptionPane.showMessageDialog(this,"Please enter a keyword with no repeated characters.", "Inane error", JOptionPane.ERROR_MESSAGE);
        }
        encr = new Encrypter(k_word);
        String incoming = input.getText();
        //System.out.println(encr.encrypt(incoming));
        if(e.getSource() == encrypt) {
            //incoming = input.getText();
            output.setText(encr.encrypt(incoming));

        }
        else{
            //incoming = output.getText();
            output.setText(encr.decrypt(incoming));
        }
    }
}
