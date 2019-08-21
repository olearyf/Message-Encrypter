import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {

    JTextField keyword, input, output;
    //check keyword for double chars, etc, limit length
    JButton encrypt, decrypt;
    Encrypter encr;

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
        output = new JTextField(30);
        encrypt = new JButton("Encrypt");
        decrypt = new JButton("Decrypt");
    }

    public void actionPerformed(ActionEvent e){
        String k_word = keyword.getText();
        encr = new Encrypter(k_word);
        if(e.getSource() == encrypt) {
            String incoming = input.getText();
            output.setText(encr.encrypt(incoming));
        }
        else{
            String incoming = output.getText();
        }
    }
}
