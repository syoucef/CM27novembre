package fr.polytech.nancy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class    ControllerWeb {
    // comme dans RestController, on a besoin de l'interface DAO ....
    @Autowired
    private ProductDao productDao;


    @GetMapping("/")
    public String afficher(){
        return "produits";
    }



// on utilise l'nterface .....

    @GetMapping("/index")
    public String test (Model model){
        Page<Product> produits = productDao.findAll(PageRequest.of(2, 6));
        model.addAttribute("listeProduits", produits);
        model.addAttribute("pages", new int[produits.getTotalPages()]);
        return "produits";
    }



    @GetMapping("/indexpages")
    public String testpage (Model model){
        Page<Product> produits = productDao.findAll(PageRequest.of(0, 4)); // on récupère tous les prodiits ....
        model.addAttribute("listeProduits", produits);
        return "produits";
    }



    @GetMapping("/indexpagesameliorepage")
    public String testpageliens (Model model,@RequestParam(name = "page", defaultValue = "0") int page){
        Page<Product> produits = productDao.findAll(PageRequest.of(page, 6)); // on récupère tous les prodiits ....

        model.addAttribute("listeProduits", produits.getContent());
        model.addAttribute("pages", new int[produits.getTotalPages()]);
        // importante remarque : ce que l'on renvoie ici est un objet de type page ....
        // cet objet conetient donc plusieurs informations ....
        // on aurait pu utiliser produits.getContent(), mais défaut c'est cette méthode qui est appellée ....
        // pour activer le numéro de la page ....
        model.addAttribute("courante", page);
        // récupérer un objet de la couche métier ....
        return "produits";
    }


    // ce que l'on souhaite est de récupérer le numéro de la page dans la requête ....
    @GetMapping("/indexpagesameliore")
    // vous vous souvenez pour recupéer un paramètre avec Spring MVC, on utlise requestGetparam
    // ici, on n'a pas besoin, on utilise l'annotation  @RequestParam
    public String testpagerecuperer (Model model,@RequestParam(name = "page", defaultValue = "0") int page){
        Page<Product> produits = productDao.findAll(PageRequest.of(page, 4)); // on récupère tous les prodiits ....
        model.addAttribute("listeProduits", produits);
        return "produits";
    }


    // Afficher les liens de pagénation ....


// pour afficher un numéro de page dans le tableau, on utilise une liste, on retourne dans la partie html ....



    // avec un moteur de recherche avec mot clé ....

    @GetMapping("/indexpagesameliorepagemotcle")
    public String testpageliensmotcle (Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                                       @RequestParam(name = "mot", defaultValue = "") String mot){

        Page<Product> produits = productDao.findByDesignatioContains(mot, PageRequest.of(page, 4)); // on récupère tous les prodiits ....
        model.addAttribute("listeProduits", produits.getContent());
        model.addAttribute("pages", new int[produits.getTotalPages()]);
        // importante remarque : ce que l'on renvoie ici est un objet de type page ....
        // cet objet conetient donc plusieurs informations ....
        // on aurait pu utiliser produits.getContent(), mais défaut c'est cette méthode qui est appellée ....
        // pour activer le numéro de la page ....
        model.addAttribute("courante", page);
        return "produits";
    }






}
