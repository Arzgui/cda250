package KayTry.model;

import com.fasterxml.jackson.annotation.JsonView;
import KayTry.view.CommandeView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "statut")
public class StatutCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @JsonView(CommandeView.class)
    protected String designation;

}