package mybooks;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import mybooks.ui.PopupListener;

public class Util
{
    
    public static PopupListener popup(JMenuItem ... items)
    {
        JPopupMenu menu = new JPopupMenu();
        
        for(JMenuItem item : items)
        {
            if(item == null)
            {
                menu.addSeparator();
            }
            else
            {
                menu.add(item);
            }
        }
        
        return new PopupListener(menu);
    }

    public static TreeModel createTreeModel(List<Author> list)
    {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("authors");
        Map<Character, DefaultMutableTreeNode> map = new TreeMap<>();

        list.forEach(author ->
        {
            Character key = author.getLastName().charAt(0);
            
            if(!map.containsKey(key))
            {
                map.put(key, new DefaultMutableTreeNode(key.toString()));
            }
            
            map.get(key).add(node(author));
        });
        
        map.forEach((k, v) ->
        {
            root.add(map.get(k));
        });
        
        return new DefaultTreeModel(root);
    }
    
    private static MutableTreeNode node(Author author)
    {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(author);
        author.getBookSet().forEach(book -> root.add(node(book)));
        return root;
    }
    
    private static MutableTreeNode node(Book book)
    {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(book);
        book.getGenreSet().forEach(genre -> root.add(node(genre)));
        return root;
    }
    
    private static MutableTreeNode node(Genre genre)
    {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(genre);
        return root;
    }

    private Util()
    {
    }
}
