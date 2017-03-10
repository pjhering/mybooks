package mybooks.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import javax.swing.JPopupMenu;

public class PopupListener extends MouseAdapter
{

    private final JPopupMenu popup;
    private boolean enabled;
    
    public PopupListener(JPopupMenu popup)
    {
        this.popup = Objects.requireNonNull(popup);
        this.enabled = false;
    }
    
    public JPopupMenu getPopupMenu()
    {
        return this.popup;
    }
    
    public boolean isEnabled()
    {
        return enabled;
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
        maybe(e);
    }
    
    @Override
    public void mouseReleased(MouseEvent e)
    {
        maybe(e);
    }
    
    private void maybe(MouseEvent e)
    {
        if(e.isPopupTrigger())
        {
            popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }
    
    public void enable()
    {
        this.enabled = true;
    }
    
    public void disable()
    {
        this.enabled = false;
    }
}
