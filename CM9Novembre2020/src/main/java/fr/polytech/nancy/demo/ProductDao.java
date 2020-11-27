package fr.polytech.nancy.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    public Product findById(int id);

    List<Product> findByPrixGreaterThan(double prix);

    List<Product> findByDesignatioLike(String chaine);


    // quand on a une méthode qui renvoie une page, il faut absolument avoir un paramète Pageable
    // une autre possibilité est d'utiliser #Query avec votre requête ....
   Page<Product> findByDesignatioContains(String mot, Pageable pageable );




}
