package jpa;

import jpa.business.*;
import jpa.dao.CollaborateurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@SpringBootApplication
public class JpaTest implements CommandLineRunner {

    /**
     * @param args
     */
    static EntityManager manager = EntityManagerHelper.getEntityManager();

    @Autowired
     CollaborateurDao collaborateurDao;


    public static void main(String[] args) {

        SpringApplication.run(JpaTest.class, args);

    }

    @Override
    public void run(String... args) {

        EntityTransaction tx = manager.getTransaction();
        tx.begin();


        try {
            Collaborateur c = createCollaborateur("2502A97", "yannassoumou@gmail.com", "Assoumou Anghai Yann");
            Fiche f = createFiche("Fiche 1");
            Fiche fs = createFiche("Fiche 2");
            TableauKanban tbk = createKanban("Tableau Kanban 1");
            Section section = createSection("Attente", true);
            addSectionKanban(section, tbk);
            addFicheSection(f, section);
            addFicheSection(fs, section);
            addFicheCollaborateur(c, f);
            addFicheCollaborateur(c, fs);

            Manager c1 = new Manager("54646DSD", "ehuie@gmail.com", "Constant");

            //addSectionKanban(fs,tbk,"termine");

            manager.persist(c);
            manager.persist(c1);
            manager.persist(f);
            manager.persist(fs);
            manager.persist(tbk);

        } catch (Exception e) {
            e.printStackTrace();
        }

        tx.commit();

        manager.close();
        EntityManagerHelper.closeEntityManagerFactory();
        //		factory.close();
        System.out.println(collaborateurDao.findAll().size());
    }

    private static void addFicheCollaborateur(Collaborateur c, Fiche fs) {
        fs.setResponsable(c);
        c.elementFiche(fs);
    }

    private static void addFicheSection(Fiche f,Section s) {
        s.elementFiche(f);
    }

    private static void addSectionKanban(Section s, TableauKanban tbk) {
        tbk.setElementSection(s);
    }

    private static Section createSection(String name, boolean b) {
        return new Section(name, b);
    }

    private static Collaborateur createCollaborateur(String matricule, String mail, String name) {
        //manager.persist(c);
        return new Collaborateur(matricule, mail, name);
    }

    private static Fiche createFiche(String name) {
        // int numOfEmployees = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList().size();
        //   if (numOfEmployees == 0) {
        //manager.persist(fiche);
        return new Fiche(name);

    }

    private static TableauKanban createKanban(String name) {
        // int numOfEmployees = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList().size();
        //   if (numOfEmployees == 0) {
        //manager.persist(tbk);

        return new TableauKanban(name);

    }

    private static void addFicheKanban(Fiche fiche, TableauKanban tbk, String name) {
        // int numOfEmployees = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList().size();
        //   if (numOfEmployees == 0) {
//Default fiche ajoute directement a en attente
        //tbk.setFiche(name,fiche);
        // tbk.setFiche("attente",f);
        //manager.persist(tbk);
    }

    private static void listEmployees() {
          /*  List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
            System.out.println("num of employess:" + resultList.size());
            for (Employee next : resultList) {
                System.out.println("next employee: " + next);
            }*/
    }

}

