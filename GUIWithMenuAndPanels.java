import javax.swing.*;
import java.awt.*;

public class GUIWithMenuAndPanels extends JFrame {
    private JMenuBar menuBar;
    private JMenu pagesMenu, editMenu, helpMenu;
    private JMenuItem menuItem1, menuItem2;

    public GUIWithMenuAndPanels() {
        setTitle("AWT MENU Practice");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu bar
        menuBar = new JMenuBar();

        // Pages Menu
        pagesMenu = new JMenu("Pages");
        menuItem1 = new JMenuItem("Login");
        menuItem2 = new JMenuItem("Student");
        pagesMenu.add(menuItem1);
        pagesMenu.add(menuItem2);

        // Edit Menu
        editMenu = new JMenu("Edit");
        

        // Help Menu
        helpMenu = new JMenu("Help");

        // Add menus to menu bar
        menuBar.add(pagesMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        // North Panel
        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.CYAN);
        JLabel northLabel = new JLabel("AWT MENU LAYOUT");
        northPanel.add(northLabel);
        add(northPanel, BorderLayout.NORTH);

        // South Panel
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.cyan);
        JLabel southLabel = new JLabel();
        southPanel.add(southLabel);
        add(southPanel, BorderLayout.SOUTH);

        // Center Panel (Login Form)
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel userLabel = new JLabel("Username:");
        JTextField userTextField = new JTextField(15);
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            // Login logic here
            String username = userTextField.getText();
            String password = new String(passField.getPassword());
            if (username.equals("admin") && password.equals("admin")) {
                JOptionPane.showMessageDialog(this, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        centerPanel.add(userLabel, gbc);

        gbc.gridx = 1;
        centerPanel.add(userTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(passLabel, gbc);

        gbc.gridx = 1;
        centerPanel.add(passField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(loginButton, gbc);

        add(centerPanel, BorderLayout.CENTER);

        // Left Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.BLUE);
        JLabel leftLabel = new JLabel("              ");
        leftPanel.add(leftLabel);
        add(leftPanel, BorderLayout.WEST);

        // Right Panel
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.blue);
        JLabel rightLabel = new JLabel("          ");
        rightPanel.add(rightLabel);
        add(rightPanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUIWithMenuAndPanels().setVisible(true);
            }
        });
    }
}
