import java.util.Scanner;


class BankManagementSystem{
    public static void main(String args[]){
        BankManagementSystem system = new BankManagementSystem();
        system.run();
    }
    public void run(){
        BankAccount b = new BankAccount(null , null, null, );
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Bank Management System");
        System.out.println("Please choose an option from the menu below:");
        int choice=0;
        do{
            System.out.println("1. Create New Account");
            System.out.println("2. Display Account Details");
            System.out.println("3. Desposit Money");
            System.out.println("4. Withdraw Amount");
            System.out.println("5. Apply interest to savings account");
            System.out.println("6. Display loan Account detials");
            System.out.println("7. make a loan payment");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    b.createAccount();
                    break;
                case 2:
                    b.displayAccount();
                    break;
                case 3:
                    b.deposit();
                    break;
                case 4:
                    b.withdraw();
                    break;
                case 5:
                    // b.displayLoanDetials();
                    break;
                case 6:
                   // b.makeLoanDetials();
                    break;
                case 7:
                    //b.makeLoanPayment();
                    break;
                case 8:
                    System.out.println("Thank you for using the Bank Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again.");
            }
        }
        while(choice !=8);
    }


    
}