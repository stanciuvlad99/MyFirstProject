package ro.mycode.controllers;

import ro.mycode.models.Admin;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlAdmin {

    private ArrayList<Admin> admins;
    private final String FINAL_URL="C:\\mycode\\OOP\\Incapsularea\\MyProject3\\src\\ro\\mycode\\data\\admin.txt";

    public ControlAdmin(){
        this.admins=new ArrayList<>();
        load();
    }

    private void load() {
        try {
            File file = new File(FINAL_URL);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                Admin admin = new Admin(text);
                this.admins.add(admin);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza toti adminii
    public void read(){
        for (int i=0; i<admins.size(); i++){
            System.out.println(admins.get(i).descriere());
        }
    }

    //todo: functie ce returneaza returneaza un admin, primeste email si parola ca parametri
    public Admin findByEmailPassword(String email, String password){
        for (int i=0; i<admins.size(); i++){
            if (admins.get(i).getEmail().equals(email) && admins.get(i).getPassword().equals(password)){
                return admins.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza toti adiminii
    public String toSave(){
        int i=0;
        String save="";
        for (i=0; i<admins.size()-1; i++){
            save+=admins.get(i).toSave()+"\n";
        }
        save+=admins.get(i).toSave();
        return save;
    }

    //todo: functie ce salveasa fisierul text admin
    public void save() {
        try {
            File file = new File(FINAL_URL);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce adauga un admin in lista, primeste constructor ca parametru
    public void add(Admin admin){
        this.admins.add(admin);
    }

}
