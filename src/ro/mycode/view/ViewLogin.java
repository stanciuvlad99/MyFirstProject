package ro.mycode.view;

import ro.mycode.controllers.ControlAdmin;
import ro.mycode.controllers.ControlRacer;
import ro.mycode.models.Admin;
import ro.mycode.models.Racer;

import java.util.Scanner;

public class ViewLogin {

    private ControlAdmin controlAdmin;
    private ControlRacer controlRacer;

    public ViewLogin() {
        this.controlAdmin = new ControlAdmin();
        this.controlRacer = new ControlRacer();
        play();
    }

    public void menu() {
        System.out.println("Apasti tasta 1 pentru a va loga");
    }

    public void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:login();
                    break;
                default:
                    break;
            }
        }
    }

    private void login() {
        System.out.println("Introduceti email");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        System.out.println("Introduceti parola");
        String password = scanner.nextLine();
        Racer racer = controlRacer.findByEmailPassword(email, password);
        if (racer != null) {
            System.out.println("Bine ai venit" + racer.getFirstName() + " " + racer.getLastName() + "!");
            System.out.println("");
            ViewRacer viewRacer = new ViewRacer();
        }
        Admin admin = controlAdmin.findByEmailPassword(email, password);
        if (admin != null) {
            System.out.println("Bine ai venit" + admin.getFirstName() + " " + admin.getLastName() + "!");
            System.out.println("");
            ViewAdmin viewAdmin = new ViewAdmin();
        }
    }


}

