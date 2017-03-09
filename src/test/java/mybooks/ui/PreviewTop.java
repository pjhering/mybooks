package mybooks.ui;

import java.awt.Dimension;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

public class PreviewTop
{
    
    private static final Top top = new Top();

    public static void main(String[] args)
    {
        top.query.addActionListener(a->doQueryAction());
        
        top.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension size = top.frame.getToolkit().getScreenSize();
        top.frame.setSize(size.width * 9 / 10, size.height * 9 / 10);
        top.frame.setLocationRelativeTo(null);
        top.frame.setVisible(true);
    }

    private static void doQueryAction()
    {
        String text = "Search " +
                top.domain.getSelectedItem() +
                " for \"" +
                top.query.getText() +
                "\"";
        top.split.setRightComponent(new JLabel(text));
        top.query.setText(null);
    }
}
