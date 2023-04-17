package Takeaway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginUI() {
        super("雪豹餐饮");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // 创建用户名输入框和密码输入框
        JLabel usernameLabel = new JLabel("用户名:");
        JLabel passwordLabel = new JLabel("密   码:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');

        // 创建登录按钮
        loginButton = new JButton("登录");
        loginButton.addActionListener(this);

        // 创建注册按钮
        registerButton = new JButton("注册");
        registerButton.addActionListener(this);

        // 创建面板，并添加组件
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 添加用户名输入框和密码输入框
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        panel.add(usernamePanel);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        panel.add(passwordPanel);

        // 添加登录按钮和注册按钮
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(loginButton);
        buttonPanel.add(Box.createHorizontalStrut(10));
        buttonPanel.add(registerButton);
        panel.add(buttonPanel);

        add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("123")) {
            JOptionPane.showMessageDialog(this, "管理员登录成功！");

            // 管理员登录成功后跳转到管理员界面
            AdminUI adminUI = new AdminUI();
            adminUI.setVisible(true);

            // 隐藏登录界面
            this.setVisible(false);
        } else if (username.equals("customer") && password.equals("123")) {
            JOptionPane.showMessageDialog(this, "顾客登录成功！");

            // 顾客登录成功后跳转到顾客界面
            CustomerUI customerUI = new CustomerUI();
            customerUI.setVisible(true);

            // 隐藏登录界面
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "用户名或密码错误！");
        }
    }

    public static void main(String[] args) {
        LoginUI loginUI = new LoginUI();
        loginUI.setVisible(true);
    }
}
// 管理员界面
class AdminUI extends JFrame {
    public AdminUI() {
        super("雪豹餐饮仓库");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // 创建面板，并添加组件
        JPanel panel = new JPanel();
        JLabel label = new JLabel("管理仓库");
        panel.add(label);
        add(panel, BorderLayout.CENTER);
    }
}

// 顾客界面
class CustomerUI extends JFrame {
    public CustomerUI() {
        super("雪豹餐饮");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // 创建面板，并添加组件
        JPanel panel = new JPanel();
        JLabel label = new JLabel("菜品类别");
        panel.add(label);
        add(panel, BorderLayout.CENTER);
    }
}
