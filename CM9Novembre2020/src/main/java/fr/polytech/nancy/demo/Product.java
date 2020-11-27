package fr.polytech.nancy.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    //@GeneratedValue
    private int id;
    private String designatio;
    private double prix;

    public Product() {
    }


    public Product(int id, String designatio, double prix) {
        this.id=id;
        this.designatio = designatio;
        this.prix = prix;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignatio() {
        return designatio;
    }

    public void setDesignatio(String designatio) {
        this.designatio = designatio;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", designatio='" + designatio + '\'' +
                ", prix=" + prix +
                '}';
    }
}
