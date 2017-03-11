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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHOR")
@NamedQueries(
        {
            @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a")
            , @NamedQuery(name = "Author.findById", query = "SELECT a FROM Author a WHERE a.id = :id")
            , @NamedQuery(name = "Author.findByLastName", query = "SELECT a FROM Author a WHERE a.lastName = :lastName")
            , @NamedQuery(name = "Author.findByFirstName", query = "SELECT a FROM Author a WHERE a.firstName = :firstName")
        })
public class Author implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @ManyToMany(mappedBy = "authorSet", fetch = EAGER)
    private Set<Book> bookSet = new HashSet<>();

    public Author()
    {
    }

    public Author(Long id)
    {
        this.id = id;
    }

    public Author(Long id, String lastName)
    {
        this.id = id;
        this.lastName = lastName;
    }

    public Author(Long id, String lastName, String firstName)
    {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public Set<Book> getBookSet()
    {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet)
    {
        this.bookSet = bookSet;
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
        if(!(object instanceof Author))
        {
            return false;
        }
        Author other = (Author) object;
        if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }
}
