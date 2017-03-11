package mybooks.ui;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PreviewPanelDialog
{

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Preview PanelDialog");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        PanelDialog<AuthorPanel> dialog = new PanelDialog("New Author", new AuthorPanel());
        AuthorPanel panel = dialog.open(frame);
        if(panel != null)
        {
            frame.setContentPane(panel);
        }
    }
}
