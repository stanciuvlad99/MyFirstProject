package ro.mycode.models;

public class Racer {
    private int racerId = 0;
    private String firstName = "";
    private String lastName = "";
    private int age = 0;
    private String email = "";
    private String password = "";

    public Racer(String text) {
        String[] split = text.split(",");
        this.racerId = Integer.parseInt(split[0]);
        this.lastName = split[1];
        this.firstName = split[2];
        this.age = Integer.parseInt(split[3]);
        this.email = split[4];
        this.password = split[5];
    }

    private void setRacerId(int id) {
        this.racerId = id;
    }

    private int getRacerId() {
        return racerId;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String getFirstName() {
        return firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String getLastName() {
        return lastName;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private int getAge() {
        return age;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private String getEmail() {
        return email;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private String getPassword() {
        return password;
    }

    public String descriere() {
        String descriere = "Id-ul pilotului de curse este " + racerId + ", numele si prenumele sunt " + lastName + " " +
                firstName + ", varsta este " + age + " ani" + " iar email-ul si parola sunt " + email + " " + password;
        return descriere;
    }
}

