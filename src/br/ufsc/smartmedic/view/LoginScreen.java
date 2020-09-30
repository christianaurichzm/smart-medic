package br.ufsc.smartmedic.view;

import br.ufsc.smartmedic.controller.ControladorGeral;

import br.ufsc.smartmedic.model.excecoes.FormException;

import javax.swing.*;

import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {
    private JButton loginButton;
    private JLabel loginLabel;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JButton registerButton;
    private JLabel cpfLabel;
    private JTextField cpfTextField;

    public LoginScreen() {
        initComponents();
    }

    private void initComponents() {
        loginLabel = new JLabel();
        loginButton = new JButton();
        cpfTextField = new JTextField();
        cpfLabel = new JLabel();
        passwordLabel = new JLabel();
        passwordField = new JPasswordField();
        registerButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        loginLabel.setText("Login");

        loginButton.setText("Login");
        loginButton.addActionListener(this::loginButtonActionPerformed);

        cpfLabel.setText("Usuário");

        passwordLabel.setText("Senha");

        passwordField.setText("");

        registerButton.setText("Cadastre-se");
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.addActionListener(evt -> registerButtonActionPerformed(evt));

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
                                                                .addComponent(cpfTextField)
                                                                .addComponent(cpfLabel)
                                                                .addComponent(passwordLabel)
                                                                .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(181, 181, 181)
                                                .addComponent(loginLabel)))
                                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(loginLabel)
                                .addGap(32, 32, 32)
                                .addComponent(cpfLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpfTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
        try {
            ControladorGeral.getInstance().realizaLogin(cpfTextField.getText(), new String(passwordField.getPassword()));
            this.dispose();
        } catch (FormException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void registerButtonActionPerformed(ActionEvent evt) {
        ControladorGeral.getInstance().abreTelaCadastro();
        this.dispose();
    }
}
