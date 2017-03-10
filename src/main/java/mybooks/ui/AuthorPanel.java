package mybooks.ui;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JTextField;

public class AuthorPanel extends ValidPanel
{
    
    public final JTextField idField, lastNameField, firstNameField;
    private final JLabel idLabel, lastNameLabel, firstNameLabel;
    private final JPanel labelPanel, fieldPanel;
    
    public AuthorPanel()
    {
        idField = new JTextField(30);
        idField.setEditable(false);
        lastNameField = new JTextField(30);
        firstNameField = new JTextField(30);
        
        fieldPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        fieldPanel.add(idField);
        fieldPanel.add(firstNameField);
        fieldPanel.add(lastNameField);
        
        idLabel = new JLabel("id");
        lastNameLabel = new JLabel("last name");
        firstNameLabel = new JLabel("first name");
        
        labelPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        labelPanel.add(idLabel);
        labelPanel.add(firstNameLabel);
        labelPanel.add(lastNameLabel);
        
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
        String lastName = lastNameField.getText();
        if(lastName != null)
        {
            lastName = lastName.trim();
            lastNameField.setText(lastName);
            
            if(lastName.length() > 0)
            {
                return true;
            }
        }
        showMessageDialog("last name is required", WARNING_MESSAGE);
        lastNameField.requestFocus();
        return false;
    }
}
