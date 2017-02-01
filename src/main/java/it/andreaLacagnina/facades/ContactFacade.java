package it.andreaLacagnina.facades;


import it.andreaLacagnina.interfaces.ContactDaoInterface;
import it.andreaLacagnina.interfaces.ContactFacadeInterface;


import javax.inject.Inject;


public class ContactFacade implements ContactFacadeInterface
{
    @Inject
    ContactDaoInterface contactDao;


    public void addContact(String id, String name, String email)
    {
        contactDao.addContact(id,name,email);
    }
    public void deleteContact(String id)
    {
        contactDao.deleteContact(id);
    }
    public void listContacts()
    {
        contactDao.listContacts();
    }
    public void updateContact(String id, String name, String email)
    {
        contactDao.updateContact(id, name, email);
    }
}
