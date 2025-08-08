 class LoanAccount extends BankAccount {
        private double loanAmount;
        private double interestRate;
        private int loanTerm;      
        private double monthlyPayment;
        public LoanAccount(int accountNumber, String type, String holderName, double balance, double loanAmount, double interestRate, int loanTerm) {
            super(accountNumber, "LoanAccount", holderName, 0.0); // Loan accounts typically start with zero balance
            this.loanAmount = loanAmount;
            this.interestRate = interestRate;
            this.loanTerm = loanTerm;
            calculateMonthlyPayment();
        }
        public void calculateMonthlyPayment() {
            double monthlyInterestRate = interestRate / 12;
            this.monthlyPayment = (loanAmount * monthlyInterestRate) /
                    (1-Math.pow(1 + monthlyInterestRate, -loanTerm));
            
        }   

        public void displayLoanDetails(){
            System.out.println("Loan account detials");
            System.out.println("Account Number: " + getAccountNumber());
            System.out.println("Account Holder Name: " + getHolderName());
            System.out.println("Loan Amount: " + loanAmount);
            System.out.println("interest Rate: " + interestRate);
            System.out.println("Loan Term (months): " + loanTerm);
            System.out.println("Monthly Payment: " + monthlyPayment);
        }
        public void makePayment(double paymentAmount){
            if(paymentAmount > monthlyPayment){
                System.out.println("Payment amount is higher than monthly payment. Please pay at least the monthly payment amount.");

                loanAmount -= paymentAmount;
                System.out.println("Payment made: " + paymentAmount);

                if(loanAmount <= 0){
                    System.out.println("Loan paid off successfully!");
                }
            }
        }

        }
    