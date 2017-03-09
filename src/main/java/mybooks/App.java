package mybooks;

import java.util.Objects;
import javax.persistence.EntityManagerFactory;

public class App
{

    private final EntityManagerFactory FACTORY;

    App(EntityManagerFactory emf)
    {
        this.FACTORY = Objects.requireNonNull(emf);
    }
}
