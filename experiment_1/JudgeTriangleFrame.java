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
        // 创建 JFrame 实例
        JFrame frame = new JFrame("判断三角形");

        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
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

        //设置布局为 null
        panel.setLayout(null);

        // 创建 JLabel
        JLabel textLabel = new JLabel("请输入三个1到200的整数：");
        JLabel aLabel = new JLabel("A");
        JLabel bLabel = new JLabel("B");
        JLabel cLabel = new JLabel("C");
        JLabel shapeLabel = new JLabel("形状");

        // 创建 JTextField
        JTextField aText = new JTextField(20);
        JTextField bText = new JTextField(20);
        JTextField cText = new JTextField(20);
        JTextField shapeText = new JTextField(20);

        // 定义组件的位置并添加进panel
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


        // 创建登录按钮
        JButton judgeButton = new JButton("判断形状");
        JButton resetButton = new JButton("重新输入");

        judgeButton.setBounds(10, 175, 120, 25);
        resetButton.setBounds(150, 175, 120, 25);

        panel.add(judgeButton);
        panel.add(resetButton);

        // 添加判断事件
        judgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  获取边的值
                String a = aText.getText();
                String b = bText.getText();
                String c = cText.getText();

                String regex = "^-{0,1}[0-9]{1,3}$";
                if(Pattern.matches(regex, a) && Pattern.matches(regex, b) && Pattern.matches(regex, c)){
                    int[] ls = new int[]{Integer.parseInt(a),Integer.parseInt(b),Integer.parseInt(c)};
                    if(ls[0] > 0 && ls[0]  <= 200 && ls[1] > 0 && ls[1] <= 200 && ls[2] > 0 && ls[2] < 200){
                        Arrays.sort(ls); //递增排序得到三个边
                        if(ls[0]+ls[1]>ls[2]){//此时构成三角形
                            if(ls[0] == ls[2]){
                                shapeText.setText("等边三角形");
                            }
                            else if(ls[0] == ls[1]){
                                shapeText.setText("等腰三角形");
                            }
                            else{
                                shapeText.setText("一般三角形");
                            }

                        }
                        else{
                        shapeText.setText("不能构成三角形");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(panel,"参数输入超限！");
                    }
                    return;
                }
                //执行到这个条件时说明参数输入非法了，直接弹窗
                JOptionPane.showMessageDialog(panel,"参数输入非法！");
                shapeText.setText("");
            }
        });

        // 添加重置事件
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