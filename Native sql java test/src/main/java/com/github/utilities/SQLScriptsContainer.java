package com.github.utilities;

import org.springframework.stereotype.Component;

@Component
public class SQLScriptsContainer implements ScriptsContainer{
    @Override
    public String getScriptForCreateProductsTable() {
        return """
                CREATE TABLE product(
                \tproduct_id INT PRIMARY KEY NOT NULL,
                \tmodel VARCHAR(30) NOT NULL,
                \tmanufacturer VARCHAR(30) NOT NULL,
                \tprice DOUBLE PRECISION NOT NULL,
                \tquantity INT NOT NULL,
                \ttype VARCHAR(30) NOT NULL
                );""";
    }

    @Override
    public String getScriptForCreateComputersTable() {
        return """
                CREATE TABLE computers(
                \tcomputer_id INT PRIMARY KEY NOT NULL,
                \tmodel VARCHAR(30) NOT NULL,
                \tcpu_manufacturer VARCHAR(30) NOT NULL,
                \tram_manufacturer VARCHAR(30) NOT NULL,
                \tcomputer_power INT NOT NULL,
                \tconstraint computers_model_FK foreign key (model) references products (model)
                )""";
    }

    @Override
    public String getScriptForCreateLaptopsTable() {
        return """
                CREATE TABLE laptops(
                \tphone_id INT PRIMARY KEY NOT NULL,
                \tmodel VARCHAR(30) NOT NULL,
                \tscreen_diagonal DOUBLE PRECISION NOT NULL,
                \tbattery_capacity INT NOT NULL,
                \tcpu_manufacturer VARCHAR(30) NOT NULL,
                \tram_manufacturer VARCHAR(30) NOT NULL,
                \tconstraint laptops_model_FK foreign key (model) references products (model)
                )""";
    }

    @Override
    public String getScriptForCreatePhonesTable() {
        return """
                CREATE TABLE phones(
                \tphone_id INT PRIMARY KEY NOT NULL,
                \tmodel VARCHAR(30) NOT NULL,
                \tscreen_diagonal DOUBLE PRECISION NOT NULL,
                \tbattery_capacity INT NOT NULL,
                \tmemory INT NOT NULL,
                \tconstraint phones_model_FK foreign key (model) references products (model)
                )""";
    }

    @Override
    public String getScriptForSelectAllDataFromComputersTable() {
        return "SELECT * FROM computers LEFT JOIN products ON computers.model = products.model";
    }

    @Override
    public String getScriptForSelectAllDataFromLaptopsTable() {
        return "SELECT * FROM laptops LEFT JOIN products ON laptops.model = products.model";
    }

    @Override
    public String getScriptForSelectAllDataFromPhonesTable() {
        return "SELECT * FROM phones LEFT JOIN products ON phones.model = products.model";
    }

    @Override
    public String getScriptForSelectAllProductsByManufacturer(String manufacturer) {
        return "SELECT * FROM products WHERE products.manufacturer = '"+ manufacturer +"'";
    }

    @Override
    public String getScriptForSelectAllPcModelsWhereRamManufacturerAlsoProducesRamForLaptops() {
        return "SELECT DISTINCT c1.model FROM computers AS c1 " +
                "JOIN laptops AS l2 ON c1.ram_manufacturer = l2.ram_manufacturer";
    }

    @Override
    public String getScriptForSelectModelsOfPcLaptopsPhonesByCriteria() {
        return """
                (SELECT DISTINCT pr.model FROM products AS pr
                \tINNER JOIN computers AS pc ON pr.model = pc.model
                \tWHERE pc.computer_power > 40)

                UNION

                (SELECT DISTINCT pr.model FROM products AS pr
                \tINNER JOIN laptops AS lp ON pr.model = lp.model
                \tWHERE lp.screen_diagonal < 20)
                
                UNION

                (SELECT DISTINCT pr.model FROM products AS pr
                \tINNER JOIN phones AS ph ON pr.model = ph.model
                \tWHERE ph.battery_capacity = 2000)""";
    }

    @Override
    public String getScriptForSelectAllLaptopsAndPcModelsWhichHaveTheSameRamManufacturers() {
        return """
                SELECT DISTINCT pr.model FROM products AS pr\s
                \tJOIN (SELECT pc.model as pc_model, lp.model AS lp_model FROM computers AS pc
                \tRIGHT JOIN laptops AS lp ON pc.ram_manufacturer = lp.ram_manufacturer) AS res
                \tON res.pc_model = pr.model OR res.lp_model = pr.model;""";
    }
}
