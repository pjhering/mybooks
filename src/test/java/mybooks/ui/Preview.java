package mybooks.ui;

import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

class Preview
{
    static void showInJFrame(JPanel panel)
    {
        JFrame frame = new JFrame(panel.getClass().getName());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setBorder(createEmptyBorder(10,10,10,10));
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
