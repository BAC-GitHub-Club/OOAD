package model;

/**
 *
 * @author Kesego
 */
import java.text.*;

public class BankTester {
    public static void menu(){
            System.out.println();
    }
    
    public static void main(String[] args){
        double withdraw=200,deposit=1000,interestRate=12;
        String money,money_withdrawn,money_deposited; //for display and used for formatting
        
        DecimalFormat amountFormat = new DecimalFormat("#.00");//gets two decimals
        
        //Test Savings Account
        Savings firstSavingsAcc = new Savings(1011001,"Tshepho Ranyemo",5000);
        money=amountFormat.format(firstSavingsAcc.getBalance());
        System.out.println("Savings Account number: "+firstSavingsAcc.getAccountNumber()+"\tOwner:"+firstSavingsAcc.getOwner());
        System.out.println("Initial Balance: "+money);
        firstSavingsAcc.depositAmount(deposit);
        firstSavingsAcc.payInterest(interestRate);
        money_deposited=amountFormat.format(firstSavingsAcc.getBalance());
        System.out.println("After deposit and interest: "+money_deposited);
        
        //Test ChequeAccount
        ChequeAccount cheque1 = new ChequeAccount(1011001,"Robert Theo",2000);
        System.out.println("\nCheque Account number: "+cheque1.getAccountNumber()+"\tOwner:"+cheque1.getOwner());
        money=amountFormat.format(cheque1.getBalance());
        System.out.println("Initial Balance: "+money);
        cheque1.depositAmount(deposit);
        money_deposited=amountFormat.format(cheque1.getBalance());
        System.out.println("After deposit: "+money_deposited);
        cheque1.withDrawal(withdraw);
        money_withdrawn = amountFormat.format(withdraw);
        money=amountFormat.format(cheque1.getBalance());
        System.out.println ("After withDrawal of $" + money_withdrawn + ",  balance = $" + money);
        
        //Test InterestBearing Account
        InterestBearingChequeAccount interestAcc1 = new InterestBearingChequeAccount(1012002,"Monei Joseph",2000);
        System.out.println("\nCheque Account number: "+interestAcc1.getAccountNumber()+"\tOwner:"+interestAcc1.getOwner());
        money=amountFormat.format(interestAcc1.getBalance());
        System.out.println("Initial Balance: "+money);
        interestAcc1.depositAmount(deposit);
        money_deposited=amountFormat.format(interestAcc1.getBalance());
        System.out.println("After deposit: "+money_deposited);
        interestAcc1.withDrawal(withdraw);
        interestAcc1.payInterest(interestRate);
        money_withdrawn = amountFormat.format(withdraw);
        money=amountFormat.format(interestAcc1.getBalance());
        System.out.println ("After withDrawal of $" + money_withdrawn + ",  balance = $" + money);
        
       
        
    }
}
