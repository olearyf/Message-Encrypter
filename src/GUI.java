import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {

    JTextField keyword, input, output;
    JLabel in, out, key;
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
        in = new JLabel("Input Text: ");
        out = new JLabel("Output Text: ");
        key = new JLabel("Keyword: ");

        Box left = Box.createVerticalBox();
        left.add(in);
        left.add(input);
        //left.add(encrypt);

        Box right = Box.createVerticalBox();
        right.add(out);
        right.add(output);
        //right.add(decrypt);

        Box top = Box.createVerticalBox();
        top.add(Box.createVerticalStrut(40));
        top.add(key);
        top.add(keyword);
        top.add(Box.createVerticalStrut(40));

        Box top_container = Box.createHorizontalBox();
        top_container.add(Box.createHorizontalStrut(40));
        top_container.add(top);
        top_container.add(Box.createHorizontalStrut(40));

        Box buttons = Box.createHorizontalBox();
        buttons.add(encrypt);
        buttons.add(Box.createHorizontalStrut(30));
        buttons.add(decrypt);

        Box bottom = Box.createHorizontalBox();
        bottom.add(Box.createHorizontalStrut(40));
        bottom.add(left);
        bottom.add(Box.createHorizontalStrut(20));
        bottom.add(right);
        bottom.add(Box.createHorizontalStrut(40));

        Box mainbox = Box.createVerticalBox();
        mainbox.add(top_container);
        mainbox.add(bottom);
        mainbox.add(Box.createVerticalStrut(40));
        mainbox.add(buttons);
        mainbox.add(Box.createVerticalStrut(40));

        main.add(mainbox);
        add(main);
        
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
