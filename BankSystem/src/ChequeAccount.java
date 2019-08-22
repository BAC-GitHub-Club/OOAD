/**
 *
 * @author Kesego
 */
public class ChequeAccount extends BankAccount implements WithDrawal {

    public ChequeAccount(int accountNumber, String owner, double balance) {
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
    
}
