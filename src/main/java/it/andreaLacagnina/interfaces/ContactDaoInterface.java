package it.andreaLacagnina.interfaces;



public interface ContactDaoInterface {

    public void addContact(String id, String name, String email);
    public void deleteContact(String id);
    public void listContacts();
    public void updateContact(String id, String name, String email);
}
