import java.util.ArrayList;
import java.util.Random;

public class Customer {
    String name;
    Status status;
    int id;
    ArrayList<BankAccount> accounts;

    public Customer(String name, Status status)
    {
        this.name = name;
        this.status = status;
        Random rand = new Random();
        this.id = rand.nextInt();
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account){
        //If account doesn't already exist, add it.
        for (BankAccount b : accounts){
            if (b.equals(account)){
                System.out.println("Account already exists.");
                return;
            }
        }
        accounts.add(account);

        if (!status.equals(Status.VIP)){
            //Then you can't add a Premium Account
        }

        if (!status.equals(Status.CHILD)){
            //Then you can't add a Salary account
        }


    }

    public void remove(BankAccount account){
        if (status.equals(Status.CHILD)){
            //Then you can't remove your account?
        }

        //If the account exists, then remove it.
        for (BankAccount b : accounts){
            if (b.equals(account)) accounts.remove(account);
        }
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        //Checks if input is empty or too long/short
        if (name == null) {
            this.name = "NOT_VALID";
            return;
        }
        else if (name.isEmpty()) this.name = "NOT_VALID";
        else if (name.length() > 15 || name.length() < 2) this.name = "NOT_VALID";

        //Checks if first letter is uppercase, and all other letters are lowercase.
        //Numbers will return false as Lower- & Uppercase.
        boolean valid = false;
        if (Character.isUpperCase(name.charAt(0))){
            valid = true;
            for (int i = 1; i < name.length(); i++){
                if (!Character.isLowerCase(name.charAt(i))){
                    valid = false;
                }
            }
        }
        //If nothing went wrong. Set name equal to input.
        if (!valid) this.name = "NOT_VALID";
        else{
            this.name = name;
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status == null){
            return;
        }
        else {
            this.status = status;
        }
    }

    public int getId(){
        return id;
    }
}