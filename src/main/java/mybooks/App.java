package mybooks;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.System.exit;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import static mybooks.Log.INFO;
import static mybooks.Util.createPanel;
import static mybooks.Util.createTreeModel;
import static mybooks.Util.log;
import static mybooks.Util.popup;
import mybooks.ui.PopupListener;
import mybooks.ui.Top;

class App
{

    private final Log LOG = log(App.class);
    private final EntityManagerFactory FACTORY;
    private final Top top = new Top();
    private final PopupListener rootPopup;
    private final PopupListener authorPopup;
    private final PopupListener bookPopup;
    private final PopupListener genrePopup;

    App(EntityManagerFactory emf)
    {
        LOG.write(INFO, "App(EntityManagerFactory)");
        this.FACTORY = Objects.requireNonNull(emf);
        rootPopup = popup(top.addAuthor);
        authorPopup = popup(top.removeAuthor, top.addBook);
        bookPopup = popup(top.removeBook, top.addGenre);
        genrePopup = popup(top.removeGenre);
        top.frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        top.frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                LOG.write(INFO, "windowClosing(WindowEvent)");
                shutdown();
            }
        });
        top.tree.addTreeSelectionListener(tsl -> doTreeSelectionChanged());
        top.addAuthor.addActionListener(l1 -> doAddAuthorAction());
        top.addBook.addActionListener(l2 -> doAddBookAction());
        top.addGenre.addActionListener(l3 -> doAddGenreAction());
        top.removeAuthor.addActionListener(l4 -> doRemoveAuthorAction());
        top.removeBook.addActionListener(l5 -> doRemoveBookAction());
        top.removeGenre.addActionListener(l6 -> doRemoveGenreAction());
    }
    
    void start()
    {
        LOG.write(INFO, "start()");
        refreshTreeModel();
        initTopFrame();
    }
    
    private void refreshTreeModel()
    {
        LOG.write(INFO, "refreshTreeModel()");
        EntityManager em = FACTORY.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT a FROM Author a", Author.class);
        List<Author> data = q.getResultList();
        em.getTransaction().commit();
        em.close();
        
        top.tree.setModel(createTreeModel(data));
    }
    
    private void initTopFrame()
    {
        LOG.write(INFO, "initTopFrame()");
        Dimension size = top.frame.getToolkit().getScreenSize();
        top.frame.setSize(size.width * 9 / 10, size.height * 9 / 10);
        top.frame.setLocationRelativeTo(null);
        top.frame.setVisible(true);
    }
    
    private void shutdown()
    {
        LOG.write(INFO, "shutdown()");
        top.frame.setVisible(false);
        top.frame.dispose();
        FACTORY.close();
        exit(0);
    }
    
    private void doTreeSelectionChanged()
    {
        LOG.write(INFO, "doTreeSelectionChanged()");
        TreePath path = top.tree.getSelectionPath();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
        Object obj = node.getUserObject();
        
        if(obj instanceof Author)
        {
            doAuthorSelected((Author)obj);
        }
        else if(obj instanceof Book)
        {
            doBookSelected((Book)obj);
        }
        else if (obj instanceof Genre)
        {
            doGenreSelected((Genre)obj);
        }
        else if(obj instanceof String)
        {
            String str = (String) obj;
            if(str.equals("authors"))
            {
                doRootSelected();
            }
            else
            {
                doLabelSelected();
            }
        }
        else
        {
            top.setView(null);
        }
    }
    
    private void doRootSelected()
    {
        LOG.write(INFO, "doRootSelected()");
        top.setView(null);
    }
    
    private void doLabelSelected()
    {
        LOG.write(INFO, "doLabelSelected()");
        top.setView(null);
    }
    
    private void doAuthorSelected(Author a)
    {
        LOG.write(INFO, "doAuthorSelected()");
        top.setView(createPanel(a));
    }
    
    private void doBookSelected(Book b)
    {
        LOG.write(INFO, "doBookSelected()");
    }
    
    private void doGenreSelected(Genre g)
    {
        LOG.write(INFO, "doGenreSelected()");
    }

    private void doAddAuthorAction()
    {
        LOG.write(INFO, "doAddAuthorAction()");
    }

    private void doAddBookAction()
    {
        LOG.write(INFO, "doAddBookAction()");
    }

    private void doAddGenreAction()
    {
        LOG.write(INFO, "doAddGenreAction()");
    }

    private void doRemoveAuthorAction()
    {
        LOG.write(INFO, "doRemoveAuthorAction()");
    }

    private void doRemoveBookAction()
    {
        LOG.write(INFO, "doRemoveBookAction()");
    }

    private void doRemoveGenreAction()
    {
        LOG.write(INFO, "doRemoveGenreAction()");
    }
}
