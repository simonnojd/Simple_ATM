public class Person {

    private String name;
    private String ID;
    private String mail;
    private String password;
    private Account account;

    public Person(String name, String ID, String mail, String password, Account account) {
        this.name = name;
        this.ID = ID;
        this.mail = mail;
        this.password = password;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public Account getAccount() {
        return account;
    }
}