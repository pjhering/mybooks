package mybooks.ui;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookPanel extends JPanel
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
}
