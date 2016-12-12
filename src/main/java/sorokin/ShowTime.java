package sorokin;


import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;


public class ShowTime {

     private static Logger log = Logger.getLogger(ReadFile.class);

     public static void show(String text){

        log.info("Show message on the screen");
        JFrame frame = new JFrame("Greets");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        Font font = new Font(null, Font.PLAIN, 20);

        JLabel htmlLabel = new JLabel();
        htmlLabel.setText(text);
        htmlLabel.setFont(font);

        mainPanel.add(htmlLabel, BorderLayout.CENTER);

        frame.getContentPane().add(mainPanel);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
     }
}
