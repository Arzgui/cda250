package KayTry.controller;

import com.fasterxml.jackson.annotation.JsonView;
import KayTry.dao.UtilisateurDao;
import KayTry.model.Utilisateur;
import KayTry.security.AppUserDetails;
import KayTry.security.JwtUtils;
import KayTry.view.UtilisateurView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class ConnexionController {

    @Autowired
    UtilisateurDao utilisateurDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    JwtUtils jwtUtils;

    /**
     * Action permettant de renvoyer un JWT à l'utilisateur
     *
     * @param utilisateur L'utilisateur qui tente de se connecter
     * @return Le JWT
     */
    @PostMapping("/connexion")
    public ResponseEntity<Map<String, Object>> connexion(@RequestBody Utilisateur utilisateur) {

        try {
            UserDetails userDetails = (UserDetails) authenticationProvider.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            utilisateur.getEmail(),
                            utilisateur.getMotDePasse())).getPrincipal();

            return new ResponseEntity<>(Map.of("jwt",jwtUtils.generateToken(userDetails)), HttpStatus.OK);

        } catch (AuthenticationException ex) {

            return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        }
    }

    @PostMapping("/inscription")
    public ResponseEntity<Map<String, Object>> inscription (@RequestBody Utilisateur utilisateur) {

        utilisateur.setMotDePasse(bCryptPasswordEncoder.encode(utilisateur.getMotDePasse()));

        utilisateurDao.save(utilisateur);

        return new ResponseEntity<>(Map.of("message","utilisateur créé"), HttpStatus.CREATED);

    }

    @GetMapping("/profil")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> profil (@AuthenticationPrincipal AppUserDetails userDetails){

        Utilisateur user = userDetails.getUtilisateur();
        //user.setListeCommandes(null);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }



}
