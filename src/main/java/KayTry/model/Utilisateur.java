package KayTry.model;

import KayTry.view.CommandeView;
import KayTry.view.UtilisateurView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(UtilisateurView.class)
    protected Integer id;

    @JsonView({UtilisateurView.class, CommandeView.class})
    @Column(unique = true)
    protected String email;

    protected String motDePasse;

    @JsonView(UtilisateurView.class)
    protected boolean administrateur;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    @JsonView(UtilisateurView.class)
    protected List<Commande> listeCommandes = new ArrayList<>();

}