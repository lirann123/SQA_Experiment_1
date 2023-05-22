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
        // ���� JFrame ʵ��
        JFrame frame = new JFrame("Login Example");

        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // �������
        JPanel panel = new JPanel();
        // ������
        frame.add(panel);
        // �����û�����ķ����������������
        placeComponents(panel);

        // ���ý���ɼ�
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        // ���� JLabel
        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);
        //�����ı��������û�����
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // ����������ı���
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        //�����������������ı���,�����������Ϣ���Ե�Ŵ��棬���ڰ�������İ�ȫ��
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // ������¼��ť
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();//��ȡ�û���
                String pwd = String.valueOf(passwordText.getPassword());//��ȡ����

                //������ʽ�ж��ַ���
                String regexUser = "^[a-zA-Z][a-zA-Z0-9]{5,9}$";
                String regexPwd = "^\\d{6}$";
                if(Pattern.matches(regexUser, user) && Pattern.matches(regexPwd, pwd)){
                    JOptionPane.showMessageDialog(panel,"����Ϸ�");
                }
                else{
                    JOptionPane.showMessageDialog(panel,"���벻�Ϸ�");
                }
                userText.setText("");
                passwordText.setText("");
            }
        });

    }
}