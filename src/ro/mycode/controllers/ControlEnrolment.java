package ro.mycode.controllers;

import ro.mycode.models.Enrolmet;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlEnrolment {

    private ArrayList<Enrolmet> enrolmets;

    public ControlEnrolment(){
        this.enrolmets=new ArrayList<>();
        load();
    }

    private void load(){
        try {
            File file = new File("C:\\mycode\\OOP\\Incapsularea\\MyProject3\\src\\ro\\mycode\\data\\enrolment.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                Enrolmet enrolmet = new Enrolmet(text);
                enrolmets.add(enrolmet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza toate inscrierile
    public void read(){
        for (int i=0; i<enrolmets.size(); i++){
            System.out.println(enrolmets.get(i).descriere());
        }
    }

    //todo: functie ce creaza lista de inscrieri, primeste racer id ca parametru
    public ArrayList<Enrolmet> listaInscrieri(int racerId){
        ArrayList<Enrolmet> list = new ArrayList<>();
        for (int i=0; i<enrolmets.size(); i++){
            if (enrolmets.get(i).getRacerId()==racerId){
                list.add(enrolmets.get(i));
            }
        }
        return list;
    }
}
