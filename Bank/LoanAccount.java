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
                double montthlyInterestRate = interestRate / 12;
                monthlyPayment = (loanAmount * monthlyInterestRate) /
                        (1-Math.pow(1 + monthlyInterestRate, -loanTerm));
                
            }   
        }