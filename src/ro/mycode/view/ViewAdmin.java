package ro.mycode.view;

import ro.mycode.controllers.ControlRacer;

import java.util.Scanner;

public class ViewAdmin {

    private ControlRacer controlRacer;

    public ViewAdmin(){
        this.controlRacer=new ControlRacer();
        play();
    }

    private void menu(){
        System.out.println("Apasati tasta 1 pentru a vedea toti politii de curse");
    }

    private void play(){
        menu();
        boolean running=true;
        while (running){
            Scanner scanner = new Scanner(System.in);
            int alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1:afisarePiloti();
                break;
                default:break;
            }
        }
    }

    private void afisarePiloti(){
        controlRacer.read();
    }







}
