package by.st.repository;

import by.st.model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Test;

public class CatRepositoryTest {
    private final SessionFactory SESSION_FACTORY = new Configuration()
            .configure().buildSessionFactory();

    @Test
    public void test() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Cat luch = new Cat("Luch");
        session.save(luch);

        transaction.commit();
        session.close();
    }


    @After
    public void finish() {
        SESSION_FACTORY.close();
    }
}
