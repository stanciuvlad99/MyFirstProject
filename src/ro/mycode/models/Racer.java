package ro.mycode.models;

public class Racer {
    private int racerId = 0;
    private String lastName = "";
    private String firstName = "";
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

    public void setRacerId(int id) {
        this.racerId = id;
    }

    public int getRacerId() {
        return racerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String descriere() {
        String descriere = "Id-ul pilotului de curse este " + racerId + ", numele si prenumele sunt " + lastName + " " +
                firstName + ", varsta este " + age + " ani" + " iar email-ul si parola sunt " + email + " " + password;
        return descriere;
    }
}

