package com.github.utilities;

import com.github.model.Computer;
import com.github.model.Laptop;
import com.github.model.Phone;
import org.springframework.stereotype.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class JDBCModelMapper implements ModelMapper{
    @Override
    public Computer createComputerFromResultSet(ResultSet resultSet) throws SQLException {
        return new Computer(resultSet.getInt("computer_id"),
                resultSet.getString("model"),
                resultSet.getString("manufacturer"),
                resultSet.getDouble("price"),
                resultSet.getInt("quantity"),
                resultSet.getString("type"),
                resultSet.getString("cpu_manufacturer"),
                resultSet.getString("ram_manufacturer"),
                resultSet.getInt("computer_power"));
    }

    @Override
    public Laptop createLaptopFromResultSet(ResultSet resultSet) throws SQLException {
        return new Laptop(resultSet.getInt("laptop_id"),
                resultSet.getString("model"),
                resultSet.getString("manufacturer"),
                resultSet.getDouble("price"),
                resultSet.getInt("quantity"),
                resultSet.getString("type"),
                resultSet.getDouble("screen_diagonal"),
                resultSet.getInt("battery_capacity"),
                resultSet.getString("cpu_manufacturer"),
                resultSet.getString("ram_manufacturer"));
    }

    @Override
    public Phone createPhoneFromResultSet(ResultSet resultSet) throws SQLException {
        return new Phone(resultSet.getInt("phone_id"),
                resultSet.getString("model"),
                resultSet.getString("manufacturer"),
                resultSet.getDouble("price"),
                resultSet.getInt("quantity"),
                resultSet.getString("type"),
                resultSet.getDouble("screen_diagonal"),
                resultSet.getInt("battery_capacity"),
                resultSet.getInt("memory"));
    }
}
