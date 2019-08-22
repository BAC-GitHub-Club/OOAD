/**
 *
 * @author Kesego
 */
public class Savings extends BankAccount implements PayInterest{
    
    public Savings(int accountNumber, String owner, double balance) {
        super(accountNumber, owner, balance);
    }
    @Override
    public void payInterest(double rate) {
        double interest;
        interest = (super.getBalance()/100)*rate;
        super.depositAmount(-interest);
    }
}
