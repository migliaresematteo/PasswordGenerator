import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {

    private JButton buttonGenera;
    private JButton buttonCopia;
    private JLabel labelLunghezza;
    private JLabel labelPassword;
    private JTextField textFieldLunghezza;
    private String passwordDaCopiare;

    public GUI() {
        super("Generatore Password");
        labelLunghezza = new JLabel("Lunghezza Password:");
        textFieldLunghezza = new JTextField(10);
        buttonGenera = new JButton("Genera Password");
        labelPassword = new JLabel("");
        labelPassword.setHorizontalAlignment(JLabel.CENTER);
        buttonCopia = new JButton("Copia Password");
        buttonCopia.setEnabled(false);
        buttonCopia.addActionListener(this);
        UIManager.put("Button.font", new Font("Arial", Font.PLAIN, 18));
        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 18));
        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 18));
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(labelLunghezza, BorderLayout.WEST);
        panel.add(textFieldLunghezza, BorderLayout.CENTER);
        panel.add(buttonGenera, BorderLayout.EAST);
        JPanel passwordPanel = new JPanel(new BorderLayout());
        passwordPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        passwordPanel.add(labelPassword, BorderLayout.CENTER);
        panel.add(buttonCopia, BorderLayout.SOUTH);
        add(panel, BorderLayout.NORTH);
        add(passwordPanel, BorderLayout.CENTER);
        setSize(400, 200);
        setLocationRelativeTo(null);
        buttonGenera.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonGenera) {
            int lunghezza = Integer.parseInt(textFieldLunghezza.getText());
            String password = PasswordGenerator.generaPassword(lunghezza);
            labelPassword.setText("La password casuale generata è: " + password);
            buttonCopia.setEnabled(true);
            passwordDaCopiare = password;
        } else if (e.getSource() == buttonCopia) {
            StringSelection stringSelection = new StringSelection(passwordDaCopiare);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            JOptionPane.showMessageDialog(null, "Password copiata negli appunti");
        }
    }
}