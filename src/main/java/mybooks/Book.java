package mybooks;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
@NamedQueries(
        {
            @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
            , @NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id")
            , @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title")
            , @NamedQuery(name = "Book.findByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn")
        })
public class Book implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "ISBN")
    private String isbn;
    @JoinTable(name = "BOOK_AUTHOR", joinColumns =
    {
        @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID")
    })
    @ManyToMany(fetch = EAGER)
    private Set<Author> authorSet = new HashSet<>();
    @JoinTable(name = "BOOK_GENRE", joinColumns =
    {
        @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "GENRE_ID", referencedColumnName = "ID")
    })
    @ManyToMany(fetch = EAGER)
    private Set<Genre> genreSet = new HashSet<>();

    public Book()
    {
    }

    public Book(Long id)
    {
        this.id = id;
    }

    public Book(Long id, String title)
    {
        this.id = id;
        this.title = title;
    }

    public Book(Long id, String title, String isbn)
    {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public Set<Author> getAuthorSet()
    {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet)
    {
        this.authorSet = authorSet;
    }

    public Set<Genre> getGenreSet()
    {
        return genreSet;
    }

    public void setGenreSet(Set<Genre> genreSet)
    {
        this.genreSet = genreSet;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof Book))
        {
            return false;
        }
        Book other = (Book) object;
        if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return title;
    }
}
