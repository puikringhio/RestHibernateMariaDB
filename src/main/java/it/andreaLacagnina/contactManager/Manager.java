package it.andreaLacagnina.contactManager;


import it.andreaLacagnina.interfaces.ContactFacadeInterface;
import it.andreaLacagnina.interfaces.ManagerInterface;
import it.andreaLacagnina.services.ContactService;


import javax.inject.Inject;


public class Manager implements ManagerInterface{

    @Inject
    ContactService contactService;

    @Inject
    ContactFacadeInterface contactFacade;


    public String addContact(String id,String name,String email)
    {
        System.out.println("received: id: " + id + "name: " + name + " email" + email);
        contactFacade.addContact(id,name,email);

        return "{\"result\":\"" + contactService.addMessage(name) + "\"}";
    }

    public String deleteContact(String id)
    {
        System.out.println("delete element with  ID: " + id);
        contactFacade.deleteContact(id);

        return "{\"result\":\"" + contactService.deleteMessage(id) + "\"}";
    }

    public String listContacts() {

        System.out.println("List contacts :");
        contactFacade.listContacts();

        return "{\"result\":\"" + contactService.listMessage() + "\"}";
    }

    public String updateContact(String id,String name,String email)
    {

        System.out.println("update of: id: " + id + "name: " + name + " email" + email);
        contactFacade.updateContact(id, name, email);

        return "{\"result\":\"" + contactService.updateMessage() + "\"}";
    }


}


