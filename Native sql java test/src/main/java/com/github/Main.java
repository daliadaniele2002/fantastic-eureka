package com.github;

import com.github.configurators.SpringContextConfigurator;
import com.github.controller.DBQueryController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = createApplicationContext();

        DBQueryController controller = getDBQueryController(applicationContext);

        executeQueries(controller);
    }

    private static ApplicationContext createApplicationContext() {
        return new AnnotationConfigApplicationContext(SpringContextConfigurator.class);
    }

    private static DBQueryController getDBQueryController(ApplicationContext applicationContext) {
        return applicationContext.getBean(DBQueryController.class);
    }

    private static void executeQueries(DBQueryController controller) throws SQLException {
        System.out.println("\tGet all data from computers table:");
        controller.getAllDataFromComputersTable().forEach(System.out::println);
        System.out.println("\n\tGet all data from laptops table:");
        controller.getAllDataFromLaptopsTable().forEach(System.out::println);
        System.out.println("\n\tGet all data from phones table:");
        controller.getAllDataFromPhonesTable().forEach(System.out::println);
        System.out.println("\n\tGet all products by manufacturer:");
        controller.getAllProductsByManufacturer("APPLE").forEach(System.out::println);
        System.out.println("\n\tGet all pc models where ram manufacturer also produced ram for laptops:");
        controller.getAllPcModelsWhereRamManufacturerAlsoProducesRamForLaptops().forEach(System.out::println);
        System.out.println("\n\tGet models of pc, laptops, phones by criteria:");
        controller.getModelsOfPcLaptopsPhonesByCriteria().forEach(System.out::println);
        System.out.println("\n\tGet models of all laptops and pc which have the same ram manufacturer:");
        controller.getAllLaptopsAndPcModelsWhichHaveTheSameRamManufacturers().forEach(System.out::println);
    }
}
