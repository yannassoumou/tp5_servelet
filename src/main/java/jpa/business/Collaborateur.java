package jpa.business;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_collaborateur")
@DiscriminatorValue("Collaborateur")
public class Collaborateur {
    
    private String matricule;
    private String email;
    String name;

    Collection<Fiche> fiche = new ArrayList<Fiche>();

    public Collaborateur(String matricule, String mail, String name) {
        this.name = name;
        this.email = mail;
        this.matricule = matricule;
    }

    public Collaborateur() {

    }
    public void setEmail(String id) {
        this.email = email;
    }

    @Id
    public String getEmail() {
        return email;
    }

    @OneToMany(mappedBy = "responsable")
    public Collection<Fiche> getFiche() {
        return fiche;
    }

    public void setFiche(Collection<Fiche> fiche) {
        this.fiche = fiche;
    }

    public void setElementFiche(Fiche fiche) {
        this.fiche.add(fiche);
        fiche.setResponsable(this);
    }
    public void elementFiche(Fiche f) {
        if (f != null && !fiche.contains(f))
            fiche.add(f);
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
