import java.util.Scanner;
class BankAccount{
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
        }

    }
}
