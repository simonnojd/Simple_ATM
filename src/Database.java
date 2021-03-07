public class Database {

    Account account1 = new Account("ABC123", 5000, 2000);

    Person person1 = new Person("Simon", "9911113059",
            "test1@gmail.com", "Drottning1", account1);

    public void deposit (String account, double d) {
        if (account.equals(account1.getNumber()))
        account1.setBalance(account1.getBalance() + d);
    }

    public void withdraw (String account, double d) {
        if (account.equals(account1.getNumber()))
        account1.setBalance(account1.getBalance() - d);
    }

    public void addLoan (String account, double d) {
        account1.setLoan(account1.getLoan() + d);
    }

    public void removeLoan (String account, double d) {
        account1.setLoan(account1.getLoan() - d);
    }
}
