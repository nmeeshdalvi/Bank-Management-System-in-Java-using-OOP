import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
class BankAccount{
    List<BankAccount> accounts = new ArrayList<>();
    private int accountNumber;
    private String type;
    private String holderName;
    private double balance;
    
    
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    BankAccount(int accountNumber, String type, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void createAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating a new account");
        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();
        System.out.println("Enter account type (Savings/Current/Loan): ");
        type = sc.next();
        System.out.print("Enter account holder name: ");
        holderName = sc.next();
        System.out.println("Enter initial balance: ");
        balance = sc.nextDouble();
        System.out.println("Account created successfully!");

        BankAccount newAccount;
        if(type.equalsIgnoreCase("Savings")){
            System.out.println("Enter interest rate for savings account: ");
            double interestRate = sc.nextDouble();
            interestRate = interestRate / 100; // Convert percentage to decimal
            newAccount = new SavingsAccount(accountNumber, type, holderName, balance, interestRate);
        }else if(type.equalsIgnoreCase("Current")){
            newAccount = new CurrentAccount(accountNumber , holderName, balance);
        }else if(type.equalsIgnoreCase("Loan")){
            System.out.println("Enter Loan amount: ");
            double loanAmount = sc.nextDouble();
            System.out.println("Enter interest rate for loan account: ");
            double loanInterestRate = sc.nextDouble();
            System.out.println("Enter loan term in years: ");
            int loanTerm = sc.nextInt();
            loanInterestRate = loanInterestRate / 100; // Convert percentage to decimal
            newAccount = new LoanAccount(accountNumber, type, holderName, balance, loanAmount, loanInterestRate, loanTerm);
        } else{
            System.out.println("Invalid account type. Please try again.");
            return;
        }
    }
    class CurrentAccount extends BankAccount {
            private double overdraftLimit;
            public CurrentAccount(int accountNumber, String holderName, double balance) {
                super(accountNumber, "Current", holderName, balance);
            }
        }
    private BankAccount findAccount(int accountNumber){
        for(BankAccount account : accounts){
            if(account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        return null;
    }
    public void displayAccount(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Displaying account details");
        System.out.println("Enter account number: ");
        int accountNumber = sc.nextInt();
        BankAccount account = findAccount(accountNumber);
        if(account != null){
            account.displayAccountDetials();
        }else{
            System.out.println("Account not found.");
        }
        sc.close();
    }
    public void displayAccountDetials(){
        System.out.println("Account Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + type);
        System.out.println("Account Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
    public void deposit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Depositing money into account");
        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();
        System.out.println("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        BankAccount account = findAccount(accountNumber);
        if(account != null){
            account.deposit(amount);
        } else{
            System.out.println("Account not found.");
        }
        sc.close();
    }
    public void deposit(double amount){
        balance+= amount;
        System.out.println("Amount Deposited: " + amount);
    }
    public void withdraw(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Withdrawing money from account");
        System.out.println("Enter account number: ");
        int accountNumber = sc.nextInt();
        System.out.println("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        
        BankAccount account = findAccount(accountNumber);
        if(account != null){
            account.withdraw(amount);
        } else{
            System.out.println("Account not found.");
        }
        sc.close();
    }
    public boolean withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println("Amount Withdrawn: "+amount);
            return true;
        }else{
            System.out.println("Insufficient balance.");
            return false;
        }
    }
    ///Create a new opation for applying interest to savings account
    public void applyInterest(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Applying interest to savings account");
        System.out.println("Enter account number: ");
        int accountNumber =  sc.nextInt();
        System.out.println("Enter the number of months to apply interest: ");
        int months =  sc.nextInt();
        BankAccount account = findAccount(accountNumber);
        if(account instanceof SavingsAccount){
            ((SavingsAccount)account).applyInterest(months);
        }else{
            System.out.println("Account not found or not a savings account.");
        }
        sc.close();
    }
    //creating  methods to display Loan detials and make payments towward loans
    // public void displayLoanDetials(){
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Displaying loan account detials");
    //     System.out.println("Enter account number: ");
    //     int accountNumber = sc.nextInt();

    //     BankAccount account = findAccount(accountnumber);
    //     if(account instanceof )
    // }
    // }
}

