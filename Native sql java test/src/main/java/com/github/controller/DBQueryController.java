package com.github.controller;

import com.github.model.Computer;
import com.github.model.Laptop;
import com.github.model.Phone;

import java.sql.SQLException;
import java.util.List;

public interface DBQueryController{
    void creteTableProducts() throws SQLException;

    void createTableComputers() throws SQLException;

    void createTableLaptops() throws SQLException;

    void createTablePhones() throws SQLException;

    List<Computer> getAllDataFromComputersTable() throws SQLException;

    List<Laptop> getAllDataFromLaptopsTable() throws SQLException;

    List<Phone> getAllDataFromPhonesTable() throws SQLException;

    List<String> getAllProductsByManufacturer(String manufacturer) throws SQLException;

    List<String> getAllPcModelsWhereRamManufacturerAlsoProducesRamForLaptops() throws SQLException;

    List<String> getModelsOfPcLaptopsPhonesByCriteria() throws SQLException;

    List<String> getAllLaptopsAndPcModelsWhichHaveTheSameRamManufacturers() throws SQLException;
}
