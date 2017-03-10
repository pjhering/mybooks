package mybooks.ui;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.LEFT;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import static javax.swing.JSplitPane.HORIZONTAL_SPLIT;
import javax.swing.JTree;

public class Top
{
    
    public final JFrame frame;
    public final JSplitPane split;
    public final JTree tree;
    public final JMenuItem addAuthor;
    public final JMenuItem removeAuthor;
    public final JMenuItem addBook;
    public final JMenuItem removeBook;
    public final JMenuItem addGenre;
    public final JMenuItem removeGenre;
    public final JButton updateButton;
    private final JScrollPane scroll;
    private final JPanel empty, north;
    private JPanel view;
    
    public Top()
    {
        tree = new JTree();
        scroll = new JScrollPane(tree);
        empty = new JPanel();
        
        addAuthor = new JMenuItem("add author");
        removeAuthor = new JMenuItem("remove author");
        addBook = new JMenuItem("add book");
        removeBook = new JMenuItem("remove book");
        addGenre = new JMenuItem("add genre");
        removeGenre = new JMenuItem("remove genre");
        
        updateButton = new JButton("update");
        north = new JPanel(new FlowLayout(LEFT));
        north.add(updateButton);
        
        split = new JSplitPane(HORIZONTAL_SPLIT);
        split.setOneTouchExpandable(true);
        split.setLeftComponent(scroll);
        split.setRightComponent(empty);
        split.setBorder(createEmptyBorder(10, 10, 10, 10));
        
        frame = new JFrame("MyBooksDB");
        frame.setContentPane(split);
    }
    
    public JPanel getView()
    {
        return view;
    }

    public void setView(JPanel panel)
    {
        this.view = panel;
        
        if(panel == null)
        {
            split.setRightComponent(empty);
        }
        else
        {
            JPanel right = new JPanel(new BorderLayout(5, 5));
            right.add(north, NORTH);
            right.add(panel, CENTER);
            split.setRightComponent(right);
        }
    }
}
