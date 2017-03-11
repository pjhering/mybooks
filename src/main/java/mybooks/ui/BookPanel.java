package mybooks.ui;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import java.awt.GridLayout;
import static java.lang.Character.isDigit;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookPanel extends ValidPanel
{
    
    public final JTextField idField, titleField, isbnField;
    private final JLabel idLabel, titleLabel, isbnLabel;
    private final JPanel labelPanel, fieldPanel;
    
    public BookPanel()
    {
        idField = new JTextField(30);
        idField.setEditable(false);
        titleField = new JTextField(30);
        isbnField = new JTextField(30);
        
        fieldPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        fieldPanel.add(idField);
        fieldPanel.add(isbnField);
        fieldPanel.add(titleField);
        
        idLabel = new JLabel("id");
        titleLabel = new JLabel("title");
        isbnLabel = new JLabel("isbn");
        
        labelPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        labelPanel.add(idLabel);
        labelPanel.add(isbnLabel);
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
        if(title == null || title.trim().length() == 0)
        {
            showMessageDialog(this, "title is required");
            titleField.requestFocus();
            return false;
        }
        titleField.setText(title.trim());
        
        String isbn = isbnField.getText();
        if(isbn != null && isbn.trim().length() > 0)
        {
            isbn = isbn.trim();
            isbnField.setText(isbn);
            char[] chars = isbn.toCharArray();
            //is at least 10 characters in length
            if(chars.length < 10)
            {
                showMessageDialog(this, "isbn must be at least 10 characters");
                isbnField.requestFocus();
                return false;
            }
            //starts and ends with digit
            if(!isDigit(chars[0]) || !isDigit(chars[chars.length - 1]))
            {
                showMessageDialog(this, "isbn must begin and end with a digit");
                isbnField.requestFocus();
                return false;
            }
            //contains only digits and hyphens
            for(char c : chars)
            {
                if(c != '-' && !isDigit(c))
                {
                    showMessageDialog(this, "isbn my only contain digits and hyphens");
                    isbnField.requestFocus();
                    return false;
                }
            }
        }
        return true;
    }
}
