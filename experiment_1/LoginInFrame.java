package Software_Quality_Assurance.liran.h01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
public class LoginInFrame {

    public static void main(String[] args) {
        loginFrame();
    }

    public static void loginFrame() {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("Login Example");

        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // 创建面板
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        // 调用用户定义的方法并添加组件到面板
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        // 创建 JLabel
        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);
        //创建文本域用于用户输入
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        //这个类似用于输入的文本域,但是输入的信息会以点号代替，用于包含密码的安全性
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // 创建登录按钮
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();//获取用户名
                String pwd = String.valueOf(passwordText.getPassword());//获取密码

                //正则表达式判断字符串
                String regexUser = "^[a-zA-Z][a-zA-Z0-9]{5,9}$";
                String regexPwd = "^\\d{6}$";
                if(Pattern.matches(regexUser, user) && Pattern.matches(regexPwd, pwd)){
                    JOptionPane.showMessageDialog(panel,"输入合法");
                }
                else{
                    JOptionPane.showMessageDialog(panel,"输入不合法");
                }
                userText.setText("");
                passwordText.setText("");
            }
        });

    }
}