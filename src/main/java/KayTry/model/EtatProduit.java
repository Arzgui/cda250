package KayTry.model;

import KayTry.view.EtatProduitView;
import KayTry.view.ProduitView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "etat")
public class EtatProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({ProduitView.class, EtatProduitView.class})
    protected Integer id;

    @JsonView({ProduitView.class, EtatProduitView.class})
    protected String designation;

//    @OneToMany(mappedBy = "etat")
//    @JsonView(EtatProduitView.class)
//    protected List<Produit> listeProduits = new ArrayList<>();
}
