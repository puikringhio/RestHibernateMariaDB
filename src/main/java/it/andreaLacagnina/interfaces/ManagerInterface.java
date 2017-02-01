package it.andreaLacagnina.interfaces;


public interface ManagerInterface {

    public String addContact(String id, String name, String email);
    public String deleteContact(String id);
    public String listContacts();
    public String updateContact(String id, String name, String email);
}
