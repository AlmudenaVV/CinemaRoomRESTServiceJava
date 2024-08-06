class BankAccount {

    protected String number;
    protected Long balance;

    public BankAccount(String number, Long balance) {
        this.number = number;
        this.balance = balance;
    }
}
class CheckingAccount extends BankAccount {

    double fee;

    public CheckingAccount(String number, Long balance, double fee) {
        super(number, balance); // Call superclass constructor
        this.fee = fee; // Initialize the fee field
    }
}
class SavingsAccount extends BankAccount {

    double interestRate;

    public SavingsAccount(String number, Long balance, double interestRate) {
        super(number, balance); // Call superclass constructor
        this.interestRate = interestRate; // Initialize the interestRate field
    }
}