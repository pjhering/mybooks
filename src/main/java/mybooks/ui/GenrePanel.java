package mybooks.ui;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import java.awt.GridLayout;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GenrePanel extends ValidPanel
{
    
    public final JTextField idField, titleField;
    private final JLabel idLabel, titleLabel;
    private final JPanel labelPanel, fieldPanel;
    
    public GenrePanel()
    {
        idField = new JTextField(30);
        idField.setEditable(false);
        titleField = new JTextField(30);
        
        fieldPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        fieldPanel.add(idField);
        fieldPanel.add(titleField);
        
        idLabel = new JLabel("id");
        titleLabel = new JLabel("name");
        
        labelPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        labelPanel.add(idLabel);
        labelPanel.add(titleLabel);
        
        init();
    }
    
    private void init()
    {
        setLayout(new BorderLayout(5, 5));
        add(labelPanel, WEST);
        add(fieldPanel, CENTER);
    }
    
    @Override
    public boolean doValidation()
    {
        String title = titleField.getText();
        if(title != null)
        {
            title = title.trim();
            titleField.setText(title);
            
            if(title.length() > 0)
            {
                return true;
            }
        }
        showMessageDialog(this, "title is required");
        titleField.requestFocus();
        return false;
    }
}
