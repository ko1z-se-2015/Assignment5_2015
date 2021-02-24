package repositories;

import entities.Medicine;

import java.util.ArrayList;

public interface IMedRepository {
    public ArrayList<Medicine> SearchMedByName(String name);
    public Medicine getMedByID(int id);
    public boolean addMed(Medicine med);
    public boolean removeMedByID(int id);
    public ArrayList<Medicine> ShowAllMed();
    public ArrayList<Medicine> searchByPrice(double price);
}
