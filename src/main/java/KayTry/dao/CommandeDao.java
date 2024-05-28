package KayTry.dao;

import KayTry.model.Commande;
import KayTry.model.StatistiqueCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande,Integer> {

    @Query(value = "FROM Commande c JOIN c.statut s WHERE s.designation = :status")
    List<Commande> commandesByStatus(@Param("status") String status);

    //SELECT COUNT(*), designation FROM commande c JOIN statut s ON c.statut_id = s.id GROUP BY designation;
    @Query(value = "SELECT s.designation, COUNT(*) FROM Commande c JOIN c.statut s GROUP BY s.designation")
    List<Object[]> statusCommandeV1();

    @Query(value = "SELECT new KayTry.model.StatistiqueCommande( s.designation, COUNT(*)) FROM Commande c JOIN c.statut s GROUP BY s.designation")
    List<StatistiqueCommande> statusCommandeV2();

    @Query(nativeQuery = true, value = "SELECT COUNT(*), designation FROM commande c JOIN statut s ON c.statut_id = s.id GROUP BY designation")
    List<Object[]> statusCommandeV3();
}