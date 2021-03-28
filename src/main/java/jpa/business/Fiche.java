package jpa.business;


import javax.persistence.*;
import java.sql.Date;

@Entity
public class Fiche {


    int id_fiche;
    String libelle;
    Date dateFin;


    Collaborateur responsable;

    String timeTodo;

    String tag;

    String lieu;
    String url;
    String note;


    Section section;

    public Fiche(String libelle, Section section) {
        this.libelle = libelle;
        this.section = section;
    }

    public Fiche(String libelle) {
        this.libelle = libelle;

    }

    public Fiche() {

    }

    @ManyToOne
    public Collaborateur getResponsable() {
        return responsable;
    }

    public void setResponsable(Collaborateur responsable) {
        this.responsable = responsable;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_fiche() {
        return id_fiche;
    }

    public void setId_fiche(int id_fiche) {
        this.id_fiche = id_fiche;
    }

    @ManyToOne
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

}
