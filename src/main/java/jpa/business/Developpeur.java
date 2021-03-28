package jpa.business;

import javax.persistence.Entity;

@Entity
public class Developpeur extends Collaborateur{
    public Developpeur(String mail, String name) {
        super(mail, name);
    }
}
