/**
 *
 * @author Kesego
 */
import java.text.*;
import java.util.*;

public class BankTester {

    public static Scanner input = new Scanner(System.in); //for input
    public static DecimalFormat amountFormat = new DecimalFormat("#.00");//gets two decimals
    public static String money,money_withdrawn,money_deposited; //for display and used for formatting
    public static final double RATE=12; //Interest rate in percentage 
    
    public static  int mainMenu(){  //main menu method
       
        int option;
        System.out.println("Select an option");
        System.out.println("Select 1 to withdraw");
        System.out.println("Select 2 to Deposit");
        System.out.println("Select 3 to create an Account");
        System.out.println("select 0 to Exit");
        option =input.nextInt();
        while(option<0 || option>3){
            System.out.println("Invalid input");
            System.out.println("Re-enter option :");
            option =input.nextInt();
        }
        return option;
    }
    public static void withdraw(ChequeAccount acc){ //Cheque account withdrawal method
        double amountWithdrawn;
        System.out.println("\nCheque Account number: "+acc.getAccountNumber()+"\tOwner:"+acc.getOwner());
        money=amountFormat.format(acc.getBalance());
        System.out.println("Initial Balance: "+money);
        System.out.println("please Enter the amount you wish to withdraw");
        amountWithdrawn=input.nextDouble();
        acc.withDrawal(amountWithdrawn);
        money_withdrawn = amountFormat.format(amountWithdrawn);
        money=amountFormat.format(acc.getBalance());
        System.out.println ("After withDrawal of $" + money_withdrawn + ",  balance = $" + money);
    }
    public static void withdraw(InterestBearingChequeAccount acc){  //interestBearingCheque account withdrawal method
        double amountWithdrawn;
        System.out.println("\nCheque Account number: "+acc.getAccountNumber()+"\tOwner:"+acc.getOwner());
        money=amountFormat.format(acc.getBalance());
        System.out.println("Balance: "+money);
        System.out.println("please Enter the amount you wish to withdraw");
        amountWithdrawn=input.nextDouble();
        acc.withDrawal(amountWithdrawn);
        acc.payInterest(RATE);
        money_withdrawn = amountFormat.format(amountWithdrawn);
        money=amountFormat.format(acc.getBalance());
        System.out.println ("After withDrawal of $" + money_withdrawn + ",  balance = $" + money);
    }
    public static void deposit(Savings acc){ //savings account deposit method
        double deposit;
        System.out.println("\nSavings Account number: "+acc.getAccountNumber()+"\tOwner:"+acc.getOwner());
        money=amountFormat.format(acc.getBalance());
        System.out.println("Balance: "+money);
        System.out.println("please Enter the amount you wish to Deposit");
        deposit=input.nextDouble();
        acc.depositAmount(deposit);
        acc.payInterest(RATE);
        money_deposited=amountFormat.format(acc.getBalance());
        System.out.println("After deposit and interest: "+money_deposited);
    }
    public static void deposit(ChequeAccount acc){ //Cheque account deposit method
        double deposit;
        System.out.println("\nCheque Account number: "+acc.getAccountNumber()+"\tOwner:"+acc.getOwner());
        money=amountFormat.format(acc.getBalance());
        System.out.println("Balance: "+money);
        System.out.println("please Enter the amount you wish to Deposit");
        deposit=input.nextDouble();
        acc.depositAmount(deposit);
        money_deposited=amountFormat.format(acc.getBalance());
        System.out.println("After deposit : "+money_deposited);
    }
    public static void deposit(InterestBearingChequeAccount acc){ //interestBearingCheque account deposit method
        double deposit;
        System.out.println("\nInterestBearingCheque Account number: "+acc.getAccountNumber()+"\tOwner:"+acc.getOwner());
        money=amountFormat.format(acc.getBalance());
        System.out.println("Balance: "+money);
        System.out.println("please Enter the amount you wish to Deposit");
        deposit=input.nextDouble();
        acc.depositAmount(deposit);
        acc.payInterest(RATE);
        money_deposited=amountFormat.format(acc.getBalance());
        System.out.println("After deposit and interest: "+money_deposited);
    }
    public static ArrayList <Savings> createSavingsAccount(ArrayList <Savings> accs){   //create savings account
        int accnumber=-1;
        String owner;
        double balance=0;
        accnumber++;
        System.out.println("Please Enter your Firstname and Lastname :");
        owner=input.nextLine();
        Savings acc = new Savings(accnumber,owner,balance);
        accs.add(acc);
        System.out.println("Account successfully created!");
        money=amountFormat.format(acc.getBalance());
        System.out.println("ACCOUNT DETAILS\n"+"Account Number :"+
        acc.getAccountNumber()+"\nOwner :"+acc.getOwner()+"Initial Balance :"+money);
      return accs;  
    }
    public static ArrayList <ChequeAccount> createChequeAccount(ArrayList <ChequeAccount> accs){   //create Cheque account
        int accnumber=-1;
        String owner;
        double balance=0;
        accnumber++;
        System.out.println("Please Enter your Firstname and Lastname :");
        owner=input.nextLine();
        ChequeAccount acc = new ChequeAccount(accnumber,owner,balance);
        accs.add(acc);
        System.out.println("Account successfully created!");
        money=amountFormat.format(acc.getBalance());
        System.out.println("ACCOUNT DETAILS\n"+"Account Number :"+
        acc.getAccountNumber()+"\nOwner :"+acc.getOwner()+"Initial Balance :"+money);
      return accs;  
    }
    public static ArrayList <InterestBearingChequeAccount> createInterestBearingChequeAccount(ArrayList <InterestBearingChequeAccount> accs){   //create InterestBearingCheque account
        int accnumber=-1;
        String owner;
        double balance=0;
        accnumber++;
        System.out.println("Please Enter your Firstname and Lastname :");
        owner=input.nextLine();
        InterestBearingChequeAccount acc = new InterestBearingChequeAccount(accnumber,owner,balance);
        accs.add(acc);
        System.out.println("Account successfully created!");
        money=amountFormat.format(acc.getBalance());
        System.out.println("ACCOUNT DETAILS\n"+"Account Number :"+
        acc.getAccountNumber()+"\nOwner :"+acc.getOwner()+"Initial Balance :"+money);
      return accs;  
    }
    
    public static void main(String[] args){ //Main method
        ArrayList <Savings> savingsAccs;
        ArrayList <ChequeAccount> chequeAccs;
        ArrayList <InterestBearingChequeAccount> ibcAccs;
        savingsAccs = new ArrayList<>();
        chequeAccs= new ArrayList<>();
        ibcAccs = new ArrayList<>();
        boolean systemOn=true;
        int choice,selection,option;
        
        while(systemOn){
            choice=mainMenu();
            switch (choice) {
                case 1:
                    System.out.println("Select account to withdraw from:");
                    System.out.println("1 Cheque Account");
                    System.out.println("2 InterestBearing Cheque Account");
                    selection=input.nextInt();
                    if(selection==1){
                        System.out.println("Enter account number :");
                        option=input.nextInt();
                        if(option<=chequeAccs.size()){
                            withdraw(chequeAccs.get(option));
                        }else{
                            System.out.println("Account does not exist");
                        }     
                    }else  if(selection==2){
                        System.out.println("Enter account number :");
                        option=input.nextInt();
                        if(option<=ibcAccs.size()){
                            withdraw(ibcAccs.get(option));
                        }else{
                            System.out.println("Account does not exist");
                        }
                    }else{
                        System.out.println("You have been taken back to the Main Menu");
                    }
                    break;
                case 2:
                    System.out.println("Select account to deposit to:");
                    System.out.println("1 Savings Account"); 
                    System.out.println("2 Cheque Account");
                    System.out.println("3 InterestBearing Cheque Account");
                    selection=input.nextInt();
                    if(selection==1){
                        System.out.println("Enter account number :");
                        option=input.nextInt();
                        if(option<=savingsAccs.size()){
                            deposit(savingsAccs.get(option));
                        }else{
                            System.out.println("Account does not exist");
                        }     
                    }else if(selection==2){
                        System.out.println("Enter account number :");
                        option=input.nextInt();
                        if(option<=chequeAccs.size()){
                            deposit(chequeAccs.get(option));
                        }else{
                            System.out.println("Account does not exist");
                        }     
                    }else  if(selection==3){
                        System.out.println("Enter account number :");
                        option=input.nextInt();
                        if(option<=ibcAccs.size()){
                            deposit(ibcAccs.get(option));
                        }else{
                            System.out.println("Account does not exist");
                        }
                    }else{
                        System.out.println("You have been taken back to the Main Menu");
                    }
                    break;
                case 3:
                     System.out.println("Select the type of account you wish to create:");
                    System.out.println("1 Savings Account"); 
                    System.out.println("2 Cheque Account");
                    System.out.println("3 InterestBearing Cheque Account");
                    selection=input.nextInt();
                    if(selection==1){
                        savingsAccs=createSavingsAccount(savingsAccs);
                    }else if(selection==2){
                        chequeAccs=createChequeAccount(chequeAccs);
                    }else  if(selection==3){
                        ibcAccs=createInterestBearingChequeAccount(ibcAccs);
                    }else{
                        System.out.println("You have been taken back to the Main Menu");
                    }
                    
                    
                    break;
                default:
                    break;
            }
        }
    }
}
