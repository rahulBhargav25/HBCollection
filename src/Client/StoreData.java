package Client;

import Client.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;

import java.util.ArrayList;

public class StoreData
{
    public static void main(String[] args)
    {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("java is a programming language");
        list1.add("java is a platform");

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Servlet is an interface");
        list2.add("servlet is an api");

        Question q1 = new Question();
        q1.setQname("what is java");
        q1.setAnswers(list1);

        Question q2 = new Question();
        q2.setQname("what is sevlet");
        q2.setAnswers(list2);

        session.persist(q1);
        session.persist(q2);
        t.commit();
        session.close();

        System.out.println("success");
    }
}
