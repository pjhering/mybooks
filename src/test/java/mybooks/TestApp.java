package mybooks;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class TestApp
{
    public static void main(String[] args)
    {
        App app = new App(createEntityManagerFactory("mybooks"));
    }
}
