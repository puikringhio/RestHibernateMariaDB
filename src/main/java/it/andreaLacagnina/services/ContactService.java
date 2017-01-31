package it.andreaLacagnina.services;

public class ContactService {

    public String addMessage(String value) {
        return "add -> " + value + "!";
    }
    public String deleteMessage(String value) {
        return "delete -> " + value + "!";
    }
    public String listMessage() {
        return "list done! ";
    }
    public String updateMessage() {
        return "update done! ";
    }
}
