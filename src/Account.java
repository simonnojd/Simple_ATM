public class Account {

    private String number;
    private double balance;
    private double loan;

    public Account(String number, double balance, double loan) {
        this.number = number;
        this.balance = balance;
        this.loan = loan;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }
}