package com.github.controller;

import com.github.model.Computer;
import com.github.model.Laptop;
import com.github.model.Phone;
import com.github.utilities.ModelMapper;
import com.github.utilities.ScriptsContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class JDBCController implements DBQueryController {
    private Connection con;
    private Statement statement;
    private ModelMapper modelMapper;
    private ScriptsContainer scriptsContainer;

    @Autowired
    public JDBCController(Connection con, ModelMapper modelMapper, ScriptsContainer scriptsContainer) throws SQLException {
        statement = con.createStatement();
        this.modelMapper = modelMapper;
        this.scriptsContainer = scriptsContainer;
    }

    @Override
    public void creteTableProducts() throws SQLException {
        String script = scriptsContainer.getScriptForCreateProductsTable();

        statement.executeQuery(script);
    }

    @Override
    public void createTableComputers() throws SQLException {
        String script = scriptsContainer.getScriptForCreateComputersTable();

        statement.executeQuery(script);
    }

    @Override
    public void createTableLaptops() throws SQLException {
        String script = scriptsContainer.getScriptForCreateLaptopsTable();

        statement.executeQuery(script);
    }

    @Override
    public void createTablePhones() throws SQLException {
        String script = scriptsContainer.getScriptForCreatePhonesTable();

        statement.executeQuery(script);
    }

    @Override
    public List<Computer> getAllDataFromComputersTable() throws SQLException {
        String script = scriptsContainer.getScriptForSelectAllDataFromComputersTable();

        try (ResultSet resultSet = statement.executeQuery(script)) {
            List<Computer> computers = new ArrayList<>();
            while (resultSet.next()) {
                computers.add(modelMapper.createComputerFromResultSet(resultSet));
            }
            return computers;
        }
    }

    @Override
    public List<Laptop> getAllDataFromLaptopsTable() throws SQLException {
        String script = scriptsContainer.getScriptForSelectAllDataFromLaptopsTable();

        try (ResultSet resultSet = statement.executeQuery(script)) {
            List<Laptop> laptops = new ArrayList<>();
            while (resultSet.next()) {
                laptops.add(modelMapper.createLaptopFromResultSet(resultSet));
            }
            return laptops;
        }
    }

    @Override
    public List<Phone> getAllDataFromPhonesTable() throws SQLException {
        String script = scriptsContainer.getScriptForSelectAllDataFromPhonesTable();

        try (ResultSet resultSet = statement.executeQuery(script)) {
            List<Phone> phones = new ArrayList<>();
            while (resultSet.next()) {
                phones.add(modelMapper.createPhoneFromResultSet(resultSet));
            }
            return phones;
        }
    }

    @Override
    public List<String> getAllProductsByManufacturer(String manufacturer) throws SQLException {
        String script = scriptsContainer.getScriptForSelectAllProductsByManufacturer(manufacturer);

        try (ResultSet resultSet = statement.executeQuery(script)) {
            List<String> results = new ArrayList<>();
            while (resultSet.next()) {
                String result = resultSet.getString("model") + "\t" +
                        resultSet.getString("manufacturer") + "\t" +
                        resultSet.getDouble("price") + "\t" +
                        resultSet.getInt("quantity") + "\t" +
                        resultSet.getString("type");

                results.add(result);
            }
            return results;
        }
    }

    @Override
    public List<String> getAllPcModelsWhereRamManufacturerAlsoProducesRamForLaptops() throws SQLException {

        String script = scriptsContainer.getScriptForSelectAllPcModelsWhereRamManufacturerAlsoProducesRamForLaptops();

        try (ResultSet resultSet = statement.executeQuery(script)) {
            List<String> results = new ArrayList<>();
            while (resultSet.next()) {
                String result = resultSet.getString("model");

                results.add(result);
            }
            return results;
        }
    }

    @Override
    public List<String> getModelsOfPcLaptopsPhonesByCriteria() throws SQLException {
        //Criteria:
        // pc power > 40
        // laptop screen diagonal < 20
        //phone battery capacity = 2000
        String script = scriptsContainer.getScriptForSelectModelsOfPcLaptopsPhonesByCriteria();

        try (ResultSet resultSet = statement.executeQuery(script)) {
            List<String> results = new ArrayList<>();
            while (resultSet.next()) {
                String result = resultSet.getString("model");

                results.add(result);
            }
            return results;
        }
    }

    @Override
    public List<String> getAllLaptopsAndPcModelsWhichHaveTheSameRamManufacturers() throws SQLException {
        String script = scriptsContainer.getScriptForSelectAllLaptopsAndPcModelsWhichHaveTheSameRamManufacturers();

        try (ResultSet resultSet = statement.executeQuery(script)) {
            List<String> results = new ArrayList<>();
            while (resultSet.next()) {
                String result = resultSet.getString("model");

                results.add(result);
            }
            return results;
        }
    }
}

