package it.andreaLacagnina.contactManager;

import it.andreaLacagnina.dao.ContactDao;
import it.andreaLacagnina.services.ContactService;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/")
public class Manager {

    @Inject
    ContactService contactService;

    @Inject
    ContactDao contactDao;


    @PUT
    @Path("/add/{id}/{name}/{email}")
    //@Produces("application/json")
    public String setContact(
            @PathParam("id") String id,
            @PathParam("name") String name,
            @PathParam("email") String email
    )
    {
        System.out.println("received: id: " + id + "name: " + name + " email" + email);
        contactDao.addContact(id,name,email);

        return "{\"result\":\"" + contactService.addMessage(name) + "\"}";
    }


    @DELETE
    @Path("/deleteByID/{id}")
    //@Produces("application/json2")
    public String deleteContact(
            @PathParam("id") String id
    )
    {
        System.out.println("delete element with  ID: " + id);

        contactDao.Delete(id);

        return "{\"result\":\"" + contactService.deleteMessage(id) + "\"}";
    }

    @GET
    @Path("/listContacts")
    //@Produces("application/json3")
    public String getHelloWorldJSONList() {

        System.out.println("List contacts :");
        contactDao.List();

        return "{\"result\":\"" + contactService.listMessage() + "\"}";
    }

    @POST
    @Path("/update/{id}/{name}/{email}")
    //@Produces("application/json4")
    public String getHelloWorldJSONUpdate(
            @PathParam("id") String id,
            @PathParam("name") String name,
            @PathParam("email") String email
    )
    {

        System.out.println("update of: id: " + id + "name: " + name + " email" + email);
        contactDao.Update(id, name, email);

        return "{\"result\":\"" + contactService.updateMessage() + "\"}";
    }


}


