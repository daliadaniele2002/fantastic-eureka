package com.github.utilities;

import com.github.model.Computer;
import com.github.model.Laptop;
import com.github.model.Phone;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ModelMapper {
    Computer createComputerFromResultSet(ResultSet resultSet) throws SQLException;

    Laptop createLaptopFromResultSet(ResultSet resultSet) throws SQLException;

    Phone createPhoneFromResultSet(ResultSet resultSet) throws SQLException;
}
