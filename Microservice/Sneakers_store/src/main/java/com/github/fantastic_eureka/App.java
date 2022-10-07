package com.github.fantastic_eureka;

import com.github.fantastic_eureka.configs.ApplicationConfig;
import com.github.fantastic_eureka.controller.RestSneakersController;
import com.github.fantastic_eureka.controller.SneakersController;
import com.github.fantastic_eureka.model.Size;
import com.github.fantastic_eureka.model.Sneakers;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("!!!!!!!!!!!");
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sneakers_store");
//        EntityManager manager = factory.createEntityManager();
//        manager.getTransaction().begin();
//        manager.persist(getTestSneakers());
//        manager.getTransaction().commit();
//        manager.close();
//        factory.close();
//
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//        SneakersController controller = applicationContext.getBean(RestSneakersController.class);
//
//        System.out.println(controller.getSneakers(1).toString());
    }

    private static Sneakers getTestSneakers() {
        Sneakers sneakers = new Sneakers();
        sneakers.setBrand("Adidas");
        sneakers.setModel("AMD");
        sneakers.setPrice(100);
        sneakers.setSizes(getSizes());
        return sneakers;
    }

    private static Set<Size> getSizes() {
        Set<Size> sizes = new HashSet<>();

        sizes.add(createSize(41, 9));
        sizes.add(createSize(42, 9.5));

        return sizes;
    }

    private static Size createSize(double eu_size, double us_size) {
        Size size = new Size();

        size.setEu_size(eu_size);
        size.setUs_size(us_size);

        return size;
    }
}
