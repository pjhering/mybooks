package mybooks;

import javax.persistence.Persistence;

public class Main
{
    public static void main(String[] args)
    {
        App app = new App(Persistence.createEntityManagerFactory("mybooks"));
    }
}
