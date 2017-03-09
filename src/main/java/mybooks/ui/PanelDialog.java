package mybooks.ui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Frame;
import static java.util.Objects.requireNonNull;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class PanelDialog<P extends ValidPanel>
{
    private final String title;
    private final P panel;
    private final JButton saveButton, cancelButton;
    private final JPanel buttonPanel, flowPanel, content;
    private final JDialog dialog;
    private boolean saved;
    
    public PanelDialog(String title, P panel)
    {
        this.title = title;
        this.panel = requireNonNull(panel);
        
        saveButton = new JButton("save");
        saveButton.addActionListener(a1 -> doSaveAction());
        
        cancelButton = new JButton("cancel");
        cancelButton.addActionListener(a2 -> doCancelAction());
        
        buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        
        flowPanel = new JPanel(new FlowLayout());
        flowPanel.add(buttonPanel);
        
        content = new JPanel(new BorderLayout(5, 5));
        content.setBorder(createEmptyBorder(10, 10, 10, 10));
        content.add(panel, CENTER);
        content.add(flowPanel, SOUTH);
    }
    
    public P open(Frame parent)
    {
        dialog = new JDialog(parent, title, true);
        return init();
    }
    
    public P open(Dialog parent)
    {
        dialog = new JDialog(parent, title, true);
        return init();
    }
    
    private P init()
    {
        dialog.setContenPane(content);
        dialog.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        dialog.pack();
        dialog.setLocationRelativeTo(dialog.getOwner());
        dialog.setVisible(true);
        
        return saved? panel: null;
    }
    
    private void doSaveAction()
    {
        if(panel.validate())
        {
            saved = true;
            dialog.setVisible(false);
            dialog.dispose();
        }
    }
    
    private void doCancelAction()
    {
        saved = false;
        dialog.setVisible(false);
        dialog.dispose();
    }
}
