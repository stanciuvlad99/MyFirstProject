package ro.mycode;

import ro.mycode.controllers.*;
import ro.mycode.models.*;
import ro.mycode.view.ViewAdmin;
import ro.mycode.view.ViewLogin;
import ro.mycode.view.ViewRacer;

public class Main {
    public static void main(String[] args) {
//        ControlRacer controlRacer = new ControlRacer();
//        controlRacer.add(new Racer("10,Dumitru,Andrei,36,andrei.dumitru@example.com,Andrei456#"));
//        controlRacer.save();

//        ControlRace controlRace = new ControlRace();
//        controlRace.add(new Race("10,Touring Car Racing,cursa de masini de turism"));
//        controlRace.save();

//        ControlEnrolment controlEnrolment = new ControlEnrolment();
//        controlEnrolment.add(new Enrolmet("10,10,10"));
//        controlEnrolment.save();

//        ControlCar controlCar = new ControlCar();
//        controlCar.add(new Car("10,10,10,Mercedes-Benz,G550 4x4"));
//        controlCar.save();

//        ControlAdmin controlAdmin = new ControlAdmin();
//        controlAdmin.add(new Admin("10,Mihai,Tudor,mihai.tudor@example.com,Mihai789#"));
//        controlAdmin.save();


        ViewLogin viewLogin = new ViewLogin();
        viewLogin.play();

    }
}