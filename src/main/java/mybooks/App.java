package mybooks;

import java.util.Objects;
import javax.persistence.EntityManagerFactory;
import static mybooks.Util.popup;
import mybooks.ui.PopupListener;
import mybooks.ui.Top;

public class App
{

    private final EntityManagerFactory FACTORY;
    private final Top top = new Top();
    private final PopupListener rootPopup;
    private final PopupListener authorPopup;
    private final PopupListener bookPopup;
    private final PopupListener genrePopup;

    App(EntityManagerFactory emf)
    {
        this.FACTORY = Objects.requireNonNull(emf);
        rootPopup = popup(top.addAuthor);
        authorPopup = popup(top.removeAuthor, top.addBook);
        bookPopup = popup(top.removeBook, top.addGenre);
        genrePopup = popup(top.removeGenre);
    }
}
