package com.company;

import com.sun.nio.sctp.MessageInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Calculator extends JFrame {
    private final JLabel liczba1 = new JLabel("Liczba 1.");
    private final JLabel liczba2 = new JLabel("Liczba 2.");
    private final JLabel wynik = new JLabel("Wynik");
    private JTextField res = new JTextField();
    private final JTextField l1 = new JTextField("Wpisz liczbe");
    private final JTextField l2 = new JTextField("Wpisz liczbe");
    JButton mul = new JButton("*");
    JButton add = new JButton("+");
    JButton sub = new JButton("-");
    JButton div = new JButton("/");

    private boolean validateTextField(char c){
        return (c < '0' || c >'9') && c !='.';
    }
    Calculator(){
        setTitle("Kalkulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 280);
        setLocation(300, 300);
        setComponent();

        l1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {if(validateTextField(e.getKeyChar())) e.consume();}
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        l2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {if(validateTextField(e.getKeyChar())) e.consume();}
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        add.addActionListener(e -> {
            double num1 = TextFieldToNumber(l1);
            double num2 = TextFieldToNumber(l2);
            Double result = num1+num2;
            String str = String.format("%.3f", result);
            res.setText(str);
        });
        sub.addActionListener(e ->{
            double num1 = TextFieldToNumber(l1);
            double num2 = TextFieldToNumber(l2);
            Double result = num1 - num2;
            String str = String.format("%.3f", result);
            res.setText(str);
        });
        mul.addActionListener(e -> {
            double num1 = TextFieldToNumber(l1);
            double num2 = TextFieldToNumber(l2);
            Double result = num1 * num2;
            String str = String.format("%.3f", result);
            res.setText(str);
        });
        div.addActionListener(e -> {
            double num1 = TextFieldToNumber(l1);
            double num2 = TextFieldToNumber(l2);
            if(num2==0) JOptionPane.showMessageDialog(this, "Nie dziel przez zero!", "Zły argument", JOptionPane.WARNING_MESSAGE);
            else {
                Double result = num1 / num2;
                String str = String.format("%.3f", result);
                res.setText(str);
            }
        });
    }
    double TextFieldToNumber(JTextField textField){
        return  Double.parseDouble(textField.getText());
    }

    void setComponent(){
        getContentPane().setBackground(Color.lightGray);
        res.setEnabled(false);
        res.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        GroupLayout groupLayout =  new GroupLayout(getContentPane());
        getContentPane().setLayout(groupLayout);
        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(liczba1)
                        .addComponent(l1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 200, 200)
                        .addComponent(liczba2)
                        .addComponent(l2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addComponent(wynik)
                        .addComponent(res, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)

        ).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addGap(100, 200, 200)
                                .addComponent(add)
                                .addComponent(sub)
                                .addComponent(mul)
                                .addComponent(div)
                        )
        );

        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(liczba1)
                                        .addComponent(add)
                                .addGap(40)
                        )
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)

                                .addComponent(l1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sub)
                                .addGap(40)
                        )
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)

                                .addComponent(liczba2)
                                .addComponent(mul)
                                .addGap(40)
                        )
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)

                                .addComponent(l2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addComponent(div)
                                .addGap(40)
                        )
                        .addComponent(wynik)
                        .addComponent(res, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        );
    }

}
