package fr.polytech.nancy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cm9Novembre2020Application implements CommandLineRunner {
    @Autowired
private ProductDao productDao;
    public static void main(String[] args) {
        SpringApplication.run(Cm9Novembre2020Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productDao.save(new Product(1, "Ordinateur", 1200));
        productDao.save(new Product(2, "Routeur", 1200));
        productDao.save(new Product(3, "Switch", 1200));
        productDao.save(new Product(4, "Ordinateur de bureau", 1200));
        productDao.save(new Product(5, "Ordinateur de bureau", 1800));

        productDao.save(new Product(6, "Ordinateur", 1200));
        productDao.save(new Product(7, "Routeur", 1200));
        productDao.save(new Product(8, "Switch", 1200));
        productDao.save(new Product(9, "Ordinateur de bureau", 1200));
        productDao.save(new Product(10, "Ordinateur de bureau", 1800));


        productDao.save(new Product(11, "Ordinateur", 1200));
        productDao.save(new Product(12, "Routeur", 1200));
        productDao.save(new Product(13, "Switch", 1200));
        productDao.save(new Product(14, "Ordinateur de bureau", 1200));
        productDao.save(new Product(15, "Ordinateur de bureau", 1800));


        productDao.save(new Product(16, "Ordinateur", 1200));
        productDao.save(new Product(17, "Routeur", 1200));
        productDao.save(new Product(18, "Switch", 1200));
        productDao.save(new Product(19, "Ordinateur de bureau", 1200));
        productDao.save(new Product(20, "Ordinateur de bureau", 1800));


        productDao.save(new Product(21, "Ordinateur", 1200));
        productDao.save(new Product(22, "Routeur", 1200));
        productDao.save(new Product(23, "Switch", 1200));
        productDao.save(new Product(24, "Ordinateur de bureau", 1200));
        productDao.save(new Product(25, "Ordinateur de bureau", 1800));

        productDao.save(new Product(26, "Ordinateur", 1200));
        productDao.save(new Product(27, "Routeur", 1200));
        productDao.save(new Product(28, "Switch", 1200));
        productDao.save(new Product(29, "Ordinateur de bureau", 1200));
        productDao.save(new Product(30, "Ordinateur de bureau", 1800));


        productDao.save(new Product(31, "Ordinateur", 1200));
        productDao.save(new Product(32, "Routeur", 1200));
        productDao.save(new Product(33, "Switch", 1200));
        productDao.save(new Product(34, "Ordinateur de bureau", 1200));
        productDao.save(new Product(35, "Ordinateur de bureau", 1800));


        productDao.save(new Product(36, "Ordinateur", 1200));
        productDao.save(new Product(37, "Routeur", 1200));
        productDao.save(new Product(38, "Switch", 1200));
        productDao.save(new Product(39, "Ordinateur de bureau", 1200));
        productDao.save(new Product(40, "Ordinateur de bureau", 1800));

        productDao.save(new Product(41, "Ordinateur", 1200));
        productDao.save(new Product(42, "Routeur", 1200));
        productDao.save(new Product(43, "Switch", 1200));
        productDao.save(new Product(44, "Ordinateur de bureau", 1200));
        productDao.save(new Product(45, "Ordinateur de bureau", 1800));

        productDao.findAll().forEach(product -> {
            System.out.println(product.getDesignatio());
        });


    }
}
