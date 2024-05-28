package KayTry.model;

import KayTry.view.ProduitView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "etiquette")
public class EtiquetteProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ProduitView.class)
    protected Integer id;

    @JsonView(ProduitView.class)
    protected String designation;

    @JsonView(ProduitView.class)
    protected String couleur;
}
