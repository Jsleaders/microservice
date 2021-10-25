package com.service.recla;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Recla implements Serializable {
    public Recla(int ID, String username, String subject, String message) {
        this.ID = ID;
        this.username = username;
        this.subject = subject;
        this.message = message;
    }
    public  Recla() {
        super();
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private  int ID ;
    private  String username ;
    private String subject ;
    private  String message ;

}