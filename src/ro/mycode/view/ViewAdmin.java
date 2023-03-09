package ro.mycode.view;

import ro.mycode.controllers.ControlRace;
import ro.mycode.controllers.ControlRacer;
import ro.mycode.models.Race;
import ro.mycode.models.Racer;

import java.util.Scanner;

public class ViewAdmin {

    private ControlRacer controlRacer;
    private ControlRace controlRace;

    public ViewAdmin() {
        this.controlRace = new ControlRace();
        this.controlRacer = new ControlRacer();
        play();
    }

    private void menu() {
        System.out.println("Apasati tasta 1 pentru a vedea toti politii de curse");
        System.out.println("Apasati tasta 2 pentru a limina un pilor de curse din baza de date");
        System.out.println("Apasati tasta 3 pentru a vedea toate cursele");
        System.out.println("Apasati tasta 4 pentru a elimina o cursa");
        System.out.println("Apasati tasta 5 pentru a face update unei curse");
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
                case 3:
                    afisareCurse();
                    break;
                case 4:
                    eliminareCursa();
                    break;
                case 5:update();
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

    private void afisareCurse() {
        controlRace.read();
    }

    private void eliminareCursa() {
        System.out.println("Introduceti numele cursei");
        Scanner scanner = new Scanner(System.in);
        String numeCursa = scanner.nextLine();
        Race race = controlRace.findByName(numeCursa);
        if (race != null) {
            controlRace.removeRace(race);
            System.out.println("Cursa a fost eliminata din lista");
        } else {
            System.out.println(numeCursa + " nu exista in baza de date");
        }
    }

    private void update() {
        System.out.println("Introduceti numele cursei");
        Scanner scanner = new Scanner(System.in);
        String numeCursa=scanner.nextLine();
        Race race = controlRace.findByName(numeCursa);
        if (race!=null){
            System.out.println("Inroducerti noul nume al cursei");
            String numeNou=scanner.nextLine();
            controlRace.updateName(new Race(race.getRaceId(),numeNou,race.getRaceType()));
            System.out.println("Introduceti id-ul cursei");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Introduceti tipul cursei");
            String raceType=scanner.nextLine();
            controlRace.updateIdRaceType(new Race(id,race.getName(),raceType));
            System.out.println("Cursei i s-a facut update cu succes");
        }else {
            System.out.println(numeCursa + " nu exista");
        }
    }














}