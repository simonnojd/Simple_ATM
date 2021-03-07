import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {

    Database d = new Database();

    private JPanel panel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();

    private JTextField username = new JTextField("Username");
    private JTextField password = new JTextField("Password");

    private JButton login = new JButton("Login");
    private JButton withdraw = new JButton("Ta ut pengar");
    private JButton deposit = new JButton("Lägg in pengar");
    private JButton confirmChoice = new JButton("OK");
    private JButton confirmWithdrawal = new JButton("OK");


    private JTextArea info = new JTextArea();


    public GUI() {

        panel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new GridLayout(1,3));
        northPanel.setLayout(new GridLayout(2,1));
        centerPanel.setLayout(new BorderLayout());

        northPanel.add(username);
        northPanel.add(password);
        northPanel.setBackground(Color.WHITE);

        bottomPanel.add(login);
        bottomPanel.add(deposit);
        bottomPanel.add(withdraw);
        bottomPanel.add(confirmChoice);
        bottomPanel.add(confirmWithdrawal);
        bottomPanel.setBackground(Color.WHITE);

        deposit.setVisible(false);
        withdraw.setVisible(false);
        confirmChoice.setVisible(false);
        confirmWithdrawal.setVisible(false);

        centerPanel.add(info);
        centerPanel.setVisible(false);
        centerPanel.setBackground(Color.WHITE);

        panel.add(bottomPanel,BorderLayout.SOUTH);
        panel.add(northPanel,BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.setBackground(Color.WHITE);

        info.setEditable(false);
        info.setFont(new Font("Sans Serif", Font.PLAIN,16));

        add(panel);
        setTitle("Min bankapp");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        login.addActionListener(e->{

            if (username.getText().equals(d.person1.getID()) && password.getText().equals(d.person1.getPassword())){

                login.setVisible(false);
                username.setVisible(false);
                password.setVisible(false);
                deposit.setVisible(true);
                withdraw.setVisible(true);

                centerPanel.setVisible(true);
                info.setText("Namn: " + d.person1.getName() + "\nID: " + d.person1.getID() + "\n\n\nKontonummer: "
                        + d.account1.getNumber() + "\nSaldo: " + d.account1.getBalance() + "\nLån: " + d.account1.getLoan());
            }
        });

        username.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (username.getText().equals("Username")
                        || username.getText().equals("Vilket konto vill du lägga in pengar på?")
                        || username.getText().equals("Vilket konto vill du ta ut pengar ifrån?")){
                    username.setText("");
                }
            }
        });

        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (password.getText().equals("Password")
                || password.getText().equals("Hur mycket vill du lägga in?")
                || password.getText().equals("Hur mycket vill du ta ut?")){
                    password.setText("");
                }
            }
        });


        deposit.addActionListener(e->{

            info.setText(null);

            login.setVisible(false);
            deposit.setVisible(false);
            withdraw.setVisible(false);
            password.setVisible(true);
            username.setVisible(true);
            confirmChoice.setVisible(true);

            username.setText("Vilket konto vill du lägga in pengar på?");
            password.setText("Hur mycket vill du lägga in?");

        });

        confirmChoice.addActionListener(e-> {

            d.deposit(username.getText(), Double.parseDouble(password.getText()));

            username.setVisible(false);
            password.setVisible(false);
            confirmChoice.setVisible(false);
            deposit.setVisible(true);
            withdraw.setVisible(true);
            centerPanel.setVisible(true);
            info.setText("Namn: " + d.person1.getName() + "\nID: " + d.person1.getID() + "\n\n\nKontonummer: "
                    + d.account1.getNumber() + "\nSaldo: " + d.account1.getBalance() + "\nLån: " + d.account1.getLoan());
        });

        withdraw.addActionListener(e->{

            info.setText(null);

            login.setVisible(false);
            deposit.setVisible(false);
            withdraw.setVisible(false);
            password.setVisible(true);
            username.setVisible(true);
            confirmWithdrawal.setVisible(true);

            username.setText("Vilket konto vill du ta ut pengar ifrån?");
            password.setText("Hur mycket vill du ta ut?");

        });

        confirmWithdrawal.addActionListener(e-> {

            if (Double.parseDouble(password.getText()) > d.account1.getBalance()){
                info.setText("Du har inte så mycket pengar på ditt konto, försök igen");
                centerPanel.setVisible(true);
            } else {
                d.withdraw(username.getText(), Double.parseDouble(password.getText()));

                username.setVisible(false);
                password.setVisible(false);
                confirmWithdrawal.setVisible(false);
                deposit.setVisible(true);
                withdraw.setVisible(true);
                centerPanel.setVisible(true);
                info.setText("Namn: " + d.person1.getName() + "\nID: " + d.person1.getID() + "\n\n\nKontonummer: "
                        + d.account1.getNumber() + "\nSaldo: " + d.account1.getBalance() + "\nLån: " + d.account1.getLoan());
            }
        });
    }
}