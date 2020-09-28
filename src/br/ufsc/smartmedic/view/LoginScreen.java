package br.ufsc.smartmedic.view;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JButton loginButton;
    private JLabel loginTitle;
    private JPasswordField passField;
    private JLabel passLabel;
    private JButton registerButton;
    private JLabel userLabel;
    private JTextField userTextField;

    public LoginScreen() {
        initComponents();
    }

    private void initComponents() {
        loginTitle = new JLabel();
        loginButton = new JButton();
        userTextField = new JTextField();
        userLabel = new JLabel();
        passLabel = new JLabel();
        passField = new JPasswordField();
        registerButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        loginTitle.setText("Login");

        loginButton.setText("Login");
        loginButton.addActionListener(this::loginButtonActionPerformed);

        userTextField.setText("jTextField1");
        userTextField.addActionListener(this::userTextFieldActionPerformed);

        userLabel.setText("Usuário");

        passLabel.setText("Senha");

        passField.setText("");

        registerButton.setText("Cadastre-se");
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(registerButton)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(userTextField)
                                                                .addComponent(userLabel)
                                                                .addComponent(passLabel)
                                                                .addComponent(passField, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(181, 181, 181)
                                                .addComponent(loginTitle)))
                                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(loginTitle)
                                .addGap(32, 32, 32)
                                .addComponent(userLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(registerButton)
                                .addGap(18, 18, 18)
                                .addComponent(loginButton)
                                .addContainerGap(42, Short.MAX_VALUE))
        );
        pack();
        setVisible(true);
    }

    private void loginButtonActionPerformed(ActionEvent evt) {
        // TODO
    }

    private void registerButtonActionPerformed(ActionEvent evt) {
        // TODO
    }

    private void userTextFieldActionPerformed(ActionEvent evt) {
        // TODO
    }
}
