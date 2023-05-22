package Software_Quality_Assurance.liran.h01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.regex.Pattern;

public class JudgeTriangleFrame {
    public static void main(String[] args) {
        jJudgeTriangleFrame();
    }

    public static void jJudgeTriangleFrame() {
        // ���� JFrame ʵ��
        JFrame frame = new JFrame("�ж�������");

        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
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

        //���ò���Ϊ null
        panel.setLayout(null);

        // ���� JLabel
        JLabel textLabel = new JLabel("����������1��200��������");
        JLabel aLabel = new JLabel("A");
        JLabel bLabel = new JLabel("B");
        JLabel cLabel = new JLabel("C");
        JLabel shapeLabel = new JLabel("��״");

        // ���� JTextField
        JTextField aText = new JTextField(20);
        JTextField bText = new JTextField(20);
        JTextField cText = new JTextField(20);
        JTextField shapeText = new JTextField(20);

        // ���������λ�ò���ӽ�panel
        textLabel.setBounds(10,20,180,25);
        aLabel.setBounds(10,50,80,25);
        bLabel.setBounds(10,80,80,25);
        cLabel.setBounds(10,110,80,25);
        shapeLabel.setBounds(10,140,80,25);

        panel.add(textLabel);
        panel.add(aLabel);
        panel.add(bLabel);
        panel.add(cLabel);
        panel.add(shapeLabel);

        aText.setBounds(100,50,165,25);
        bText.setBounds(100,80,165,25);
        cText.setBounds(100,110,165,25);
        shapeText.setBounds(100,140,165,25);

        panel.add(aText);
        panel.add(bText);
        panel.add(cText);
        panel.add(shapeText);


        // ������¼��ť
        JButton judgeButton = new JButton("�ж���״");
        JButton resetButton = new JButton("��������");

        judgeButton.setBounds(10, 175, 120, 25);
        resetButton.setBounds(150, 175, 120, 25);

        panel.add(judgeButton);
        panel.add(resetButton);

        // ����ж��¼�
        judgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  ��ȡ�ߵ�ֵ
                String a = aText.getText();
                String b = bText.getText();
                String c = cText.getText();

                String regex = "^-{0,1}[0-9]{1,3}$";
                if(Pattern.matches(regex, a) && Pattern.matches(regex, b) && Pattern.matches(regex, c)){
                    int[] ls = new int[]{Integer.parseInt(a),Integer.parseInt(b),Integer.parseInt(c)};
                    if(ls[0] > 0 && ls[0]  <= 200 && ls[1] > 0 && ls[1] <= 200 && ls[2] > 0 && ls[2] < 200){
                        Arrays.sort(ls); //��������õ�������
                        if(ls[0]+ls[1]>ls[2]){//��ʱ����������
                            if(ls[0] == ls[2]){
                                shapeText.setText("�ȱ�������");
                            }
                            else if(ls[0] == ls[1]){
                                shapeText.setText("����������");
                            }
                            else{
                                shapeText.setText("һ��������");
                            }

                        }
                        else{
                        shapeText.setText("���ܹ���������");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(panel,"�������볬�ޣ�");
                    }
                    return;
                }
                //ִ�е��������ʱ˵����������Ƿ��ˣ�ֱ�ӵ���
                JOptionPane.showMessageDialog(panel,"��������Ƿ���");
                shapeText.setText("");
            }
        });

        // ��������¼�
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aText.setText("");
                bText.setText("");
                cText.setText("");
                shapeText.setText("");
            }
        });

    }
}