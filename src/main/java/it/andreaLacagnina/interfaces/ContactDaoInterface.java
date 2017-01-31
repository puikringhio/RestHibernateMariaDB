package it.andreaLacagnina.interfaces;



public interface ContactDaoInterface {

    public void addContact(String id, String name, String email);
    public void Delete(String id);
    public void List();
    public void Update(String id, String name, String email);
}
