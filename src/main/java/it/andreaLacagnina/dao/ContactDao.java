package it.andreaLacagnina.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.andreaLacagnina.models.ContactBean;
import it.andreaLacagnina.interfaces.ContactDaoInterface;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ContactDao implements ContactDaoInterface
{
    private static SessionFactory factory;

    public ContactDao() {

        try{
            factory = new Configuration().configure()
                    .addAnnotatedClass(ContactBean.class)
                    .buildSessionFactory();

        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

    private String addContact(String id, String name, String email, SessionFactory factory){
        Session session = factory.openSession();
        Transaction tx = null;
        String contactID = null;
        try{
            tx = session.beginTransaction();
            ContactBean contact = new ContactBean(id,name,email);
            contactID = (String) session.save(contact);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return contactID;
    }

    private void deleteContact(String id){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            ContactBean contact =
                    (ContactBean) session.get(ContactBean.class, id);
            session.delete(contact);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    private void listContacts( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ContactBean> query = builder.createQuery(ContactBean.class);
            query.from(ContactBean.class);
            List<ContactBean> resultList = session.createQuery(query).getResultList();
            for (ContactBean contactBean : resultList) {
                System.out.println("contact id(" + contactBean.getId() + ") " +contactBean.getName() + " " + contactBean.getEmail());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    private void updateNameContact(String id, String name, String email){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            ContactBean contact =
                    (ContactBean) session.get(ContactBean.class, id);
            contact.setId(id);
            contact.setName( name );
            contact.setEmail(email);
            session.update(contact);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    public void addContact(String id, String name, String email)
    {
        this.addContact(id,name, email, factory);
    }

    public void Delete(String id)
    {
        this.deleteContact(id);
    }

    public void List()
    {
        this.listContacts();
    }

    public void Update(String id, String name, String email)
    {
        this.updateNameContact(id,name,email);
    }


}
