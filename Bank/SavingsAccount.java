class SavingsAccount extends BankAccount {
            private double interestRate;

            public SavingsAccount(int accountNumber, String type, String holderName, double balance, double interestRate) {
                super(accountNumber, "SavingsAccount", holderName, balance);
                this.interestRate = interestRate;
            }
        }