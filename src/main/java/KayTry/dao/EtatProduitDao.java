package KayTry.dao;

import KayTry.model.EtatProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatProduitDao extends JpaRepository<EtatProduit,Integer> {

}
