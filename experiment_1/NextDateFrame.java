package Software_Quality_Assurance.liran.h01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;

public class NextDateFrame {
    public static void main(String[] args) {
        nextDateFrame();
    }

    public static void nextDateFrame() {
        // ���� JFrame ʵ��
        JFrame frame = new JFrame("NextDate");

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
        placeComponents(panel,frame);

        // ���ý���ɼ�
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel,JFrame frame) {

        //���ò���Ϊ null
        panel.setLayout(null);

        // ���� JLabel
        JLabel yearLabel = new JLabel("year", SwingConstants.RIGHT);
        JLabel monthLabel = new JLabel("month", SwingConstants.RIGHT);
        JLabel dayLabel = new JLabel("day", SwingConstants.RIGHT);
        JLabel nextDateLabel = new JLabel("NextDate", SwingConstants.RIGHT);

        // ���� JTextField
        JTextField yearText = new JTextField(20);
        JTextField monthText = new JTextField(20);
        JTextField dayText = new JTextField(20);
        JTextField nextDateText = new JTextField(20);

        // ���������λ�ò���ӽ�panel
        yearLabel.setBounds(20,20,60,25);
        monthLabel.setBounds(20,50,60,25);
        dayLabel.setBounds(20,80,60,25);
        nextDateLabel.setBounds(20,110,60,25);

        panel.add(yearLabel);
        panel.add(monthLabel);
        panel.add(dayLabel);
        panel.add(nextDateLabel);

        yearText.setBounds(100,20,165,25);
        monthText.setBounds(100,50,165,25);
        dayText.setBounds(100,80,165,25);
        nextDateText.setBounds(100,110,165,25);

        panel.add(yearText);
        panel.add(dayText);
        panel.add(monthText);
        panel.add(nextDateText);


        // ������¼��ť
        JButton nextDateButton = new JButton("NextDate");
        JButton closeButton = new JButton("Close");

        nextDateButton.setBounds(10, 140, 120, 25);
        closeButton.setBounds(150, 140, 120, 25);

        panel.add(nextDateButton);
        panel.add(closeButton);

        // ����ж��¼�
        nextDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  ��ȡ�ߵ�ֵ
                String year = yearText.getText();
                String month = monthText.getText();
                String day = dayText.getText();

                String regex = "^[0-9]{1,4}$";
                if(Pattern.matches(regex, year) && Pattern.matches(regex, month) && Pattern.matches(regex, day)){
                    int y = Integer.parseInt(year);
                    int m = Integer.parseInt(month);
                    int d = Integer.parseInt(day);
                    if(y > 0 && y  <= 2050 && m > 0 && m <=12){ //ȷ����ݺϷ�
                        int theLastDay = 0;
                        //��ȡ�������һ��
                        if(m == 2) {
                            if(y % 4 == 0 && y % 100 != 0 || y % 400 == 0){
                                theLastDay = 29;
                            }
                            else{
                                theLastDay = 28;
                            }

                        }
                        else if ( m == 4 || m == 6 || m == 9 || m == 11){
                            theLastDay = 30;
                        }
                        else{
                            theLastDay = 31;
                        }

                        //�ж�d �� theLastDay�Ĺ�ϵ
                        if(d <= theLastDay){
                            if( m == 12 && d == theLastDay){
                                //�ж�������һ��
                                y += 1;
                                m = 1;
                                d = 1;
                            }
                            else if(d == theLastDay) {
                                //�ж��·����һ��
                                m += 1;
                                d = 1;
                            }
                            else{
                                d += 1;
                            }
                            nextDateText.setText(String.format("%d��%d��%d��",y,m,d));
                            return; //ִ�е��������ʱ˵����������Ϸ��ˣ�ֱ�ӷ���
                        }
                    }
                }
                //ִ�е��������ʱ˵����������Ƿ��ˣ�ֱ�Ӳ�����
                nextDateText.setText("������");

            }
        });

        // ��������¼�
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING) );
            }
        });

    }
}
