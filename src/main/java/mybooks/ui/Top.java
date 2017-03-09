package mybooks.ui;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import static javax.swing.JSplitPane.HORIZONTAL_SPLIT;
import javax.swing.JTextField;
import javax.swing.JTree;

public class Top
{
    
    public final JFrame frame;
    public final JSplitPane split;
    public final JTree tree;
    public final JTextField query;
    public final JComboBox<String> domain;
    private final JScrollPane scroll;
    private final JPanel left, north, empty;
    
    public Top()
    {
        query = new JTextField(30);
        domain = new JComboBox<>(new String[]{"author", "title", "isbn", "genre"});
        
        north = new JPanel(new BorderLayout(0, 0));
        north.add(query, CENTER);
        north.add(domain, EAST);
        
        tree = new JTree();
        scroll = new JScrollPane(tree);
        
        left = new JPanel(new BorderLayout(5, 5));
        left.add(north, NORTH);
        left.add(scroll, CENTER);
        
        empty = new JPanel();
        
        split = new JSplitPane(HORIZONTAL_SPLIT);
        split.setOneTouchExpandable(true);
        split.setLeftComponent(left);
        split.setRightComponent(empty);
        split.setBorder(createEmptyBorder(10, 10, 10, 10));
        
        frame = new JFrame("MyBooksDB");
        frame.setContentPane(split);
    }
}
