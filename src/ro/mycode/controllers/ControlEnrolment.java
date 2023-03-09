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

    //todo: functie ce creaza un id valabil
    public int nextId(){
        if (enrolmets.size()==0){
            return -1;
        }
        return enrolmets.get(enrolmets.size()-1).getEnrolemntId()+1;
    }

    //todo: functie ce creaza o inscriere, primeste constructor ca parametru
    public void add(Enrolmet enrolmet){
        this.enrolmets.add(enrolmet);
    }

    //todo: functie ce returnaza inscriere, primeste ca prametru race id si racer id
    public Enrolmet findByRaceIdRacerId(int raceId, int racerId){
        for (int i=0; i<enrolmets.size(); i++){
            if (enrolmets.get(i).getRaceId()==raceId && enrolmets.get(i).getRacerId()==racerId){
                return enrolmets.get(i);
            }
        }
        return null;
    }

    //todo: functie ce elimna o inscriere din lista, primeste constructor ca parametru
    public void removeEnrolment(Enrolmet enrolmet){
        this.enrolmets.remove(enrolmet);
    }


    //todo: functie ce returneaza frecventa
    public int[] frecventaCurse() {
        int frecventa[]=new int[1000];
        for (int i=0; i<enrolmets.size(); i++){
            frecventa[enrolmets.get(i).getRaceId()]++;
        }
            return frecventa;
    }

    //todo: functie ce returneaza pozitia celui mai populate curse, primeste vector ca parametru
    public int pozitieMaximaCurse(int vector[]){
        int max=vector[0];
        int pozitie=0;

        for (int i=0; i<vector.length; i++){
            if (max<vector[i]){
                max=vector[i];
                pozitie=i;
            }
        }
        return pozitie;
    }

    public int idCeaMaiPopulataCursa(){
        return pozitieMaximaCurse(frecventaCurse());
    }
}
