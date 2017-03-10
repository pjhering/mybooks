package mybooks.ui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import mybooks.Author;
import mybooks.Book;
import mybooks.Genre;
import static mybooks.Util.createTreeModel;

public class PreviewTop
{
    
    private static final Top TOP = new Top();

    public static void main(String[] args)
    {
        TOP.tree.setModel(createTreeModel(testData()));
        TOP.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension size = TOP.frame.getToolkit().getScreenSize();
        TOP.frame.setSize(size.width * 9 / 10, size.height * 9 / 10);
        TOP.frame.setLocationRelativeTo(null);
        TOP.frame.setVisible(true);
    }
    
    private static List<Author> testData()
    {
        List<Author> data = new ArrayList<>();
        long id = 1L;
        
        Genre g1 = new Genre(id++, "Comics");
        Book b1 = new Book(id++, "Madman");
        b1.getGenreSet().add(g1);
        Book b2 = new Book(id++, "X-Statics");
        b2.getGenreSet().add(g1);
        Author a1 = new Author(id++, "Allred", "Mike");
        a1.getBookSet().add(b1);
        a1.getBookSet().add(b2);
        data.add(a1);
        
        Genre g2 = new Genre(id++, "Fiction");
        Book b3 = new Book(id++, "Slaughterhouse 5");
        b3.getGenreSet().add(g2);
        Book b4 = new Book(id++, "Deadeye Dick");
        b4.getGenreSet().add(g2);
        Author a2 = new Author(id++, "Vonnegut", "Kurt");
        a2.getBookSet().add(b3);
        a2.getBookSet().add(b4);
        data.add(a2);
        
        return data;
    }
}
