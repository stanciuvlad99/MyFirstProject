package ro.mycode.controllers;

import ro.mycode.models.Racer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlRacer {
    private ArrayList<Racer> racers;

    public ControlRacer(){
        this.racers=new ArrayList<>();
        load();
    }

    private void load(){
        try {

            File file = new File("C:\\mycode\\OOP\\Incapsularea\\MyProject3\\src\\ro\\mycode\\data\\racer.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine();
                Racer racer = new Racer(linie);
                racers.add(racer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza toti studentii
    public void read(){
        for (int i=0; i<racers.size(); i++){
            System.out.println(racers.get(i).descriere());
        }
    }

    //todo: functie ce returneaza un pilot, primeste ca parametru firstname si lastname
    public Racer findByFirstNameLastname(String firstName, String lastname){
        for (int i=0; i<racers.size(); i++){
            if (racers.get(i).getFirstName().equals(firstName) && racers.get(i).getLastName().equals(lastname)){
                return racers.get(i);
            }
        }
        return null;
    }

    //todo: functie ce elimina un pilot, primeste constructor ca paramereu
    public void removeRacer(Racer racer){
        this.racers.remove(racer);
    }

    //todo: functie ce returneaza un id valabil
    public int nextId(){
        if (racers.size()==0){
            return -1;
        }
        return racers.get(racers.size()-1).getRacerId()+1;
    }

    //todo: functie ce adauga un pilot in baza de date, primeste construcor ca parametru
    public void add(Racer racer){
        this.racers.add(racer);
    }

    //todo functie ce returneaza id-ul pilotului, primeste firstName si lastName ca parametri
    public int returnIdRacer(String firstName, String lastName){
        for (int i=0; i<racers.size(); i++){
            if (racers.get(i).getFirstName().equals(firstName) && racers.get(i).getLastName().equals(lastName)){
                return racers.get(i).getRacerId();
            }
        }
        return -1;
    }

    //todo: functie ce returneaza pilot, primeste email si password
    public Racer findByEmailPassword(String email, String password){
        for (int i=0; i<racers.size(); i++) {
            if (racers.get(i).getEmail().equals(email) && racers.get(i).getPassword().equals(password)) {
                return racers.get(i);
            }
        }
        return null;
    }
}

