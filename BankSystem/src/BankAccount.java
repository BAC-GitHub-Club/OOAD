/**
 *
 * @author Kesego
 */
public class BankAccount {
    private int accountNumber;
    private String owner;
    private double balance;

    public BankAccount(int accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
    	
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void depositAmount(double amount){
        balance+=amount;
    }
    
}
