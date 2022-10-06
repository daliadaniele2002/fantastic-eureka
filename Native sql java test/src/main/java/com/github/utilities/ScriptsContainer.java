package com.github.utilities;

public interface ScriptsContainer {
    String getScriptForCreateProductsTable();

    String getScriptForCreateComputersTable();

    String getScriptForCreateLaptopsTable();

    String getScriptForCreatePhonesTable();

    String getScriptForSelectAllDataFromComputersTable();

    String getScriptForSelectAllDataFromLaptopsTable();

    String getScriptForSelectAllDataFromPhonesTable();

    String getScriptForSelectAllProductsByManufacturer(String manufacturer);

    String getScriptForSelectAllPcModelsWhereRamManufacturerAlsoProducesRamForLaptops();

    String getScriptForSelectModelsOfPcLaptopsPhonesByCriteria();

    String getScriptForSelectAllLaptopsAndPcModelsWhichHaveTheSameRamManufacturers();
}
