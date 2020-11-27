package fr.polytech.nancy.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.Writer;
import java.net.URI;
import java.util.List;

@RestController
public class ControllerDemo {

    @Autowired
    private ProductDao productDao;

    @GetMapping(value = "/Ines")
    public String afficher(){
        return "Bonjour Inès et Augustin !";
    }

   // renvoyer tous les produits ....
    @GetMapping(value = "/tous")
    public List<Product> afficherTousLesProduits(){
        return this.productDao.findAll();
    }

    // renvoyer un produit sachant son ID ....
    @GetMapping(value = "/produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) throws ProductNotFound {
        Product product = this.productDao.findById(id); // vu ensemble ....
        if(product==null) throw  new
                ProductNotFound("Le produit avec l'id " + id + " " +
                "n'existe pas");



        return this.productDao.findById(id);
    }

    // renvoyer tous les produits dont le prix est supérieur à un paramètre .....
    @GetMapping(value = "/produitCher/{prix}")
    public List<Product> produitChers(@PathVariable double prix){
        return this.productDao.findByPrixGreaterThan(prix);
    }

   // "moteur de recherche textuel" .....
    @GetMapping(value = "/chercher/{s}")
    public List<Product> rechreche(@PathVariable String s){
        return this.productDao.findByDesignatioLike("%"+s+"%");
    }


    // Exercices : implémenter les méthodes POST, DELETE et PUT ....
    // POST : création d'une nouvelle ressource
    // PUT : mise à jour d'une ressource
    // DELETE : supprimer une ressource

    // Très important : le code que l'on doit renvoyer lorsque l'on envoie une requête POST et 201 Created





    @PostMapping(value = "/ajouter")
    public Product ajouterUnProduit_1(@RequestBody Product product){
        this.productDao.save(product);
        return  product;
    }



/* Mettre à jour un produit .....
@PutMapping(value = "/produits")
public void metrreAjourProduit(@RequestBody Product product){
    this.productDao.save(product);
}
*/
    @PostMapping("/ajouterUnSeulProduit")
    public void ajout(@RequestBody Product product){
        this.productDao.save(product);
    }






//ajouter un produit
@PostMapping(value = "/AjouterUnProduit")
public ResponseEntity<Void> ajouterUnProduit(@RequestBody Product product) {

    Product productAjoute =  productDao.save(product);

    if (productAjoute == null)
        return ResponseEntity.noContent().build();

    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(productAjoute.getId())
            .toUri();

    return ResponseEntity.created(location).build();
}


// La méthode DELETE ....
    @DeleteMapping(value = "produit/{id}")
    public void supprimerUnProduit(@PathVariable  int id){
    this.productDao.deleteById(id);
    }
    // on va discuter avec ById et un ByProduct ....


// On peut l'exposer sous forme de Get

    @RequestMapping(value = "produit/{id}", method = RequestMethod.GET)
    public void supprimerUnProduitBis(@PathVariable  int id){
        this.productDao.deleteById(id);
    }




    /*
    Un code de statut 202 (Accepted) si l'action est en passe de réussir mais n'a pas encore été confirmée.
    Un code de statut 204 (No Content) si l'action a été confirmée et qu'aucune information supplémentaire n'est à fournir.
    Un code de statut 200 (OK) si l'action a été confirmée et que le message de réponse inclut une représentation décrivant le statut.
     */


    @GetMapping("yes")
    public String ok(){
        return "Bonjour Ines et Augustin et Kahina et Samir Thanks, yes good !";
    }

}
