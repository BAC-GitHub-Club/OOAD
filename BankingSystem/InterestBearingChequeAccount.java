/**
 *
 * @author Kesego
 */
public class InterestBearingChequeAccount extends BankAccount implements WithDrawal,PayInterest {
    
    public InterestBearingChequeAccount(int accountNumber, String owner, double balance) {
        super(accountNumber, owner, balance);
    }

    @Override
    public void withDrawal(double amountWithDrawn) {
       double newBalance;
       if(super.getBalance()>amountWithDrawn){
           newBalance=super.getBalance()-amountWithDrawn;
           super.setBalance(newBalance);
       }
    }

    @Override
    public void payInterest(double rate) {
        double interest;
        interest = (super.getBalance()/100)*rate;
        
        super.depositAmount(-interest); 
    }
}
