package jpa.business;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Section {


    private int id_section;
    private String name_section;
    private Boolean state;


    private TableauKanban tbk;
    private Collection<Fiche> parentFiche = new ArrayList<Fiche>();

    public Section(String name, Boolean state) {
        this.name_section = name;
        this.state = state;
    }

    public Section() {

    }
    @ManyToOne
    public TableauKanban getTbk() {
        return tbk;
    }

    public void setTbk(TableauKanban tbk) {
        this.tbk = tbk;
    }
    @OneToMany(mappedBy = "section")
    public Collection<Fiche> getParentFiche() {
        return parentFiche;
    }

    public void setParentFiche(Collection<Fiche> parentFiche) {
        this.parentFiche = parentFiche;
    }

    public void setNameSection(String name) {
        this.name_section = name;
    }

    public void setStateSection(boolean state) {
        this.state = state;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_section() {
        return id_section;
    }

    public void setId_section(int id_section) {
        this.id_section = id_section;
    }

    public void elementFiche(Fiche f) {
        if (f != null && !parentFiche.contains(f))
            parentFiche.add(f);
    }
}
