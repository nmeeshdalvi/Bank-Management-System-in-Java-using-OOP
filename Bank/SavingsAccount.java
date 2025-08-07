class SavingsAccount extends BankAccount {
            private double interestRate;

            public double getinterestRate(){
                return interestRate;
            }
            public void setInterestrate(Double interestRate){
                this.interestRate = interestRate;
            }

            public SavingsAccount(int accountNumber, String type, String holderName, double balance, double interestRate) {
                super(accountNumber, "SavingsAccount", holderName, balance);
                this.interestRate = interestRate;
            }
//method tp apply interest to savings account
            public void applyInterest(int months){
                //Calculate monthly interest rate from annual interest rate
                double monthlyInterestRate = interestRate / 12 ;
                //Calculate interest from given number pf months
                double interest = getBalance() * monthlyinterestRate * months;
                //Add interesst to the balance
                setBalance(getBalance()+ interest);

                //prints the detials of the interest calculation for verification
                System.out.println("Interest applied for " + months + "months: ");
                System.out.println("Initial balance: " + (getBalance() - interest));
                System.out.println("interest rate: " + (interestRate * 100) + "% annually");
                System.out.println("Monthly interest rate: " + (monthlyInterestRate * 100) + "%");
                System.out.println("Interest appiled: " + interest);
                System.out.println("New balance after applying interest: " + getBalance());
            }
            }            
        