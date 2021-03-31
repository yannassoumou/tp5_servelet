package jpa.business;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;
    @OneToMany
    List<Fiche> tagFiche = new ArrayList<>();


}
