package ro.mycode.models;

public class Admin {
    private int adminId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public Admin(String text){
        String []split=text.split(",");
        this.adminId=Integer.parseInt(split[0]);
        this.firstName=split[1];
        this.lastName=split[2];
        this.email=split[3];
        this.password=split[4];

    }

    public Admin(int id, String email, String password, String firstName, String lastName){
        this.adminId =id;
        this.email=email;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public void setAdminId(int adminId){
        this.adminId = adminId;
    }

    public int getAdminId(){
        return adminId;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getPassword(){
        return password;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public String descriere(){
        String descriere="Id-ul adminului este " + adminId + ", adresa de email si parola sunt " + email + " "
                + password + ", iar prenumele si numele de familie sunt " + firstName + " " + lastName;
        return descriere;
    }
}
