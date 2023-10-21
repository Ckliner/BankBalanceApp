import javax.swing.*;
import java.awt.event.*;

public class BankBalanceApp {

    private static double balance = 0;

    public static void main(String[] args) {
    	
    	//Get Bank Balance from User
        String initialInput = JOptionPane.showInputDialog("Enter bank account balance:");
        try {
            balance = Double.parseDouble(initialInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Starting with balance $0.");
            balance = 0;
        }
    	
        // Main frame
        JFrame frame = new JFrame("Bank Balance App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        // JPanel
        JPanel panel = new JPanel();
        panel.setBounds(50, 50, 300, 150);
        frame.add(panel);

        // Balance Label
        JLabel balanceLabel = new JLabel("Balance: $" + balance);
        panel.add(balanceLabel);

        // Deposit Button
        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount = JOptionPane.showInputDialog("Enter deposit amount:");
                balance += Double.parseDouble(amount);
                balanceLabel.setText("Balance: $" + balance);
            }
        });
        panel.add(depositButton);

        // Withdrawal Button
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount = JOptionPane.showInputDialog("Enter withdraw amount:");
                if (balance - Double.parseDouble(amount) >= 0) {
                    balance -= Double.parseDouble(amount);
                    balanceLabel.setText("Balance: $" + balance);
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient funds.");
                }
            }
        });
        panel.add(withdrawButton);

        frame.setVisible(true);
    }
}
