package KayTry;

import KayTry.model.Produit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUnitaires {
    @Test
    public void test1() {
        Produit produit = new Produit();
       Assertions.assertNotNull(produit.getListeEtiquettes());
    }
}
