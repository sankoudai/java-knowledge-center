package com.sankoudai.java.api.swing;

import junit.framework.TestCase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestSwing extends TestCase {

    public void testDisposeFrame() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("label");

        //添加到画板中
        panel.add(label);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setSize(100, 100);
        frame.setVisible(true);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        frame.dispose();
    }


    public void testFrame() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.add(panel);
        frame.getContentPane().remove(panel);
    }


    public void testJLabel() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("label");

        //为JLabel安装收听器
        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("JLabel pressed..");
                System.out.println("JLabel has content:" + label.getText());
                label.setForeground(Color.BLUE);
                label.setBackground(Color.BLUE);
            }


        });

        //添加到画板中
        panel.add(label);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //显示
        frame.setSize(100, 100);
        frame.setVisible(true);
    }


    public void testPanelEvent() {
        //初始化承载元素
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(10, 1));

        //添加组件
        JTextField[] fields = new JTextField[10];
        for (int i = 0; i < 10; i++) {
            fields[i] = new JTextField(Double.toString(Math.random()));
            panel.add(fields[i]);
        }
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        //测试安装在panel上的eventListener, 不管用
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Component c = e.getComponent();
                System.out.println(c);
            }
        });

        //测试将一个listener安装到多个panel内装载的组建，
        //可以通过getComponent和instanceof来获得元素信息
        MouseListener listener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Component c = e.getComponent();
                if (c instanceof JTextField) {
                    JTextField field = (JTextField) c;
                    System.out.println(field.getText());
                }
            }
        };
        for (JTextField field : fields) {
            field.addMouseListener(listener);
        }

        //显示
        frame.setSize(400, 400);
        frame.setVisible(true);
    }


    public void testUpdatePanel() {
        //初始化承载元素
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(10, 1));

        //添加组件
        JTextField[] fields = new JTextField[10];
        for (int i = 0; i < 10; i++) {
            fields[i] = new JTextField(Integer.toString(i));
            panel.add(fields[i]);
        }
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        //显示
        frame.setSize(400, 400);
        frame.setVisible(true);

        //更新panel
        //尝试删除元素
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        panel.remove(fields[0]);    //移除之后， 留下空缺
        panel.repaint();
        frame.repaint();

    }


    public void testConstraintTextArea() {
        //初始化承载元素
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(10, 1));

        //创建JTextArea
        JTextArea area = new JTextArea(20, 20);
    }

    public void testJOptionPane() {
        JOptionPane.showMessageDialog(null, "注册成功，请登录!", "", JOptionPane.INFORMATION_MESSAGE);
    }
}
