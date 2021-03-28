package jpa.business;

import javax.persistence.Entity;

@Entity
public class Manager extends Collaborateur{
    public Manager(String mail, String name) {
        super(mail, name);
    }
}
