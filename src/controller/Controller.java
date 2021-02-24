package controller;

import entities.Medicine;
import repositories.IMedRepository;

import java.time.LocalDate;

public class Controller {
    private final IMedRepository iMedRepository;

    public Controller(IMedRepository iMedRepository) {
        this.iMedRepository = iMedRepository;
    }

    public String seacrhMedByName(String name){
        String res = iMedRepository.SearchMedByName(name).toString();

        return  res;
    }

    public String searchMedByID(int id){
        String res = iMedRepository.getMedByID(id).toString();

        return res;
    }
    public String AddMed(String name, double price, LocalDate expiration_date,String manufacturer,int number){

        boolean res = iMedRepository.addMed(new Medicine(name,price,expiration_date, manufacturer,number));

        if(res){
            return "Medicine was added";
        }else{
            return "Error";
        }

    }
    public String RemoveMedByID(int id){

        boolean res = iMedRepository.removeMedByID(id);

        if(res){
            return "Medicine was removed";
        }else{
            return "Error";
        }

    }
    public String ShowMed(){
        String res = iMedRepository.ShowAllMed().toString();
        return  res;
    }
    public String SearchByPrice(double price){
        String res = iMedRepository.searchByPrice(price).toString();
        return  res;
    }
}
