package repositories;


import data.IManager;
import entities.Medicine;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class MedRepository implements IMedRepository {
    private final IManager manager;

    public MedRepository(IManager manager) {
        this.manager = manager;
    }


    @Override
    public ArrayList<Medicine> SearchMedByName(String name) {

        Connection connection;

        try {
            connection = manager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicine WHERE name LIKE '%" + name + "%'");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Medicine> med = new ArrayList<>();
            while (resultSet.next()) {
                Medicine medicine = new Medicine(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("expiration_date").toLocalDate(),
                        resultSet.getString("manufacturer"),
                        resultSet.getInt("number")
                );
                med.add(medicine);
            }
            return med;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Medicine getMedByID(int id) {
        Connection connection = null;
        try {
            connection = manager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicine WHERE id=" + id);

            ResultSet resultSet = preparedStatement.executeQuery();
            Medicine medicine = new Medicine();
            if (resultSet.next()) {
                medicine.setId(resultSet.getInt("id"));
                medicine.setName(resultSet.getString("name"));
                medicine.setPrice(resultSet.getDouble("price"));
                medicine.setExpiration_date(resultSet.getDate("expiration_date").toLocalDate());
                medicine.setManufacturer(resultSet.getString("manufacturer"));
                medicine.setNumber(resultSet.getInt("number"));
            }
            return  medicine;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addMed(Medicine med) {
        Connection connection = null;
        try {

            connection = manager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO medicine(name, price, expiration_date,manufacturer,number) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, med.getName());
            preparedStatement.setDouble(2, med.getPrice());
            preparedStatement.setDate(3, Date.valueOf(med.getExpiration_date()));
            preparedStatement.setString(4, med.getManufacturer());
            preparedStatement.setInt(5,med.getNumber());

            preparedStatement.execute();

            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeMedByID(int id) {
        Connection connection = null;
        try {
            connection = manager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM medicine WHERE id=?");
            preparedStatement.setInt(1,id);
             preparedStatement.execute();
             return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public ArrayList<Medicine> ShowAllMed(){
        Connection connection = null;

        try {
            connection = manager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicine");
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Medicine> med = new ArrayList<>();
            while (resultSet.next()) {
                Medicine medicine = new Medicine(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("expiration_date").toLocalDate(),
                        resultSet.getString("manufacturer"),
                        resultSet.getInt("number")
                );
                med.add(medicine);
            }
            return med;

        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }



    @Override
    public ArrayList<Medicine> searchByPrice(double price){
        Connection connection;

        try {
            connection = manager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicine WHERE price =" + price);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Medicine> med = new ArrayList<>();
            while (resultSet.next()) {
                Medicine medicine = new Medicine(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("expiration_date").toLocalDate(),
                        resultSet.getString("manufacturer"),
                        resultSet.getInt("number")
                );
                med.add(medicine);
            }
            return med;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
