package it.andreaLacagnina.restService;

import it.andreaLacagnina.interfaces.ManagerInterface;


import javax.inject.Inject;
import javax.ws.rs.*;


@Path("/")
public class RestManager {

    @Inject
    ManagerInterface manager;


    @PUT
    @Path("/add/{id}/{name}/{email}")
    //@Produces("application/json")
    public String addContact(
            @PathParam("id") String id,
            @PathParam("name") String name,
            @PathParam("email") String email
    )
    {
        return manager.addContact(id,name,email);
    }


    @DELETE
    @Path("/deleteByID/{id}")
    //@Produces("application/json2")
    public String deleteContact(
            @PathParam("id") String id
    )
    {
        return manager.deleteContact(id);
    }

    @GET
    @Path("/listContacts")
    //@Produces("application/json3")
    public String getHelloWorldJSONList()
    {
        return manager.listContacts();
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
        return manager.updateContact(id, name, email);
    }


}


