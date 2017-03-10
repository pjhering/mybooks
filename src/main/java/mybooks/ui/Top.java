package mybooks.ui;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static javax.swing.BorderFactory.createEmptyBorder;
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
    private final JScrollPane scroll;
    private final JPanel empty;
    public final JMenuItem addAuthor;
    public final JMenuItem removeAuthor;
    public final JMenuItem addBook;
    public final JMenuItem removeBook;
    public final JMenuItem addGenre;
    public final JMenuItem removeGenre;
    
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
        
        split = new JSplitPane(HORIZONTAL_SPLIT);
        split.setOneTouchExpandable(true);
        split.setLeftComponent(scroll);
        split.setRightComponent(empty);
        split.setBorder(createEmptyBorder(10, 10, 10, 10));
        
        frame = new JFrame("MyBooksDB");
        frame.setContentPane(split);
    }
}
