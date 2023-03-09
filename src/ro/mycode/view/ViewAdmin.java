package ro.mycode.view;

import ro.mycode.controllers.ControlRacer;
import ro.mycode.models.Racer;

import java.util.Scanner;

public class ViewAdmin {

    private ControlRacer controlRacer;

    public ViewAdmin() {
        this.controlRacer = new ControlRacer();
        play();
    }

    private void menu() {
        System.out.println("Apasati tasta 1 pentru a vedea toti politii de curse");
        System.out.println("Apasati tasta 2 pentru a limina un pilor de curse din baza de date");
    }

    private void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    afisarePiloti();
                    break;
                case 2:
                    eliminarePilot();
                    break;
                default:
                    break;
            }
        }
    }

    private void afisarePiloti() {
        controlRacer.read();
    }

    private void eliminarePilot() {
        System.out.println("Inreoduceti numele de familie al pilotului");
        Scanner scanner = new Scanner(System.in);
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele pilotului");
        String prenume = scanner.nextLine();
        Racer racer = controlRacer.findByFirstNameLastname(prenume, nume);
        if (racer != null) {
            controlRacer.removeRacer(racer);
            System.out.println("Pilotul de curse a fost eliminat din baza de date");
        } else {
            System.out.println(prenume + " " + nume + " nu exista in baza de date ");
        }
    }


}
