import javax.swing.SwingUtilities; 

import javax.swing.JFrame; 

 
 

public class ReturnBookGUI{ 

    public static void main(String[] args){ 

        SwingUtilities.invokeLater(new Runnable(){ 

            public void run(){ 

                JFrame frame = new JFrame("Return Book"); 

                frame.setSize(600,500); 

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

                frame.setVisible(true); 

            } 

        }); 

    } 

} 
