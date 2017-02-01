package it.andreaLacagnina.interfaces;

/**
 * Created by utente on 01/02/2017.
 */
public interface ContactFacadeInterface {

    public void addContact(String id, String name, String email);
    public void deleteContact(String id);
    public void listContacts();
    public void updateContact(String id, String name, String email);
}
