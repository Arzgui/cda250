package KayTry.dao;

import KayTry.model.EtiquetteProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetteProduitDao extends JpaRepository<EtiquetteProduit,Integer> {

}
