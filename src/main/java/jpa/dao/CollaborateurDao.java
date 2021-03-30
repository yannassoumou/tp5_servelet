package jpa.dao;

import jpa.business.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollaborateurDao extends JpaRepository<Collaborateur, String> {

    @Query("select c from Collaborateur c where  c.type_collaborateur = :type")
    public List<Collaborateur> findByTypeCollaborateur (@Param("type") String type) ;

}
