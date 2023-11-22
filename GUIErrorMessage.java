import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUIErrorMessage extends JFrame {
    // Change size according to message or make message flow down in some way
    JLabel message;

    GUIErrorMessage(String errorMessage) {

        message = new JLabel(errorMessage);

        this.setSize(300, 350);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,40));
        panel.setLayout(new FlowLayout(FlowLayout.TRAILING));

        panel.add(message);
        this.add(panel);

        this.setVisible(true);
    }
}