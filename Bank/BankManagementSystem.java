import java.util.Scanner;


class BankManagementSystem{
    public static void main(String args[]){
        BankManagementSystem b = new BankManagementSystem();
        b.run();
    }
    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Bank Management System");
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
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        while(choice !=8);
    }
}