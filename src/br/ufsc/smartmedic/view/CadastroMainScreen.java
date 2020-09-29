package br.ufsc.smartmedic.view;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CadastroMainScreen extends JFrame {
    private JFormattedTextField birthdayField;
    private JButton goBackButton;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JPasswordField jPasswordField1;
    private JLabel nameLabel;
    private JLabel nameLabel1;
    private JLabel nameLabel2;
    private JLabel nameLabel3;
    private JLabel nameLabel4;
    private JLabel nameLabel5;
    private JTextField nameTextField;
    private JTextField nameTextField1;
    private JTextField nameTextField2;
    private JButton registerButton;

    public CadastroMainScreen() {
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        nameTextField = new JTextField();
        nameLabel = new JLabel();
        nameLabel1 = new JLabel();
        nameTextField1 = new JTextField();
        nameTextField2 = new JTextField();
        nameLabel2 = new JLabel();
        birthdayField = new JFormattedTextField();
        nameLabel3 = new JLabel();
        jComboBox1 = new JComboBox<>();
        nameLabel4 = new JLabel();
        nameLabel5 = new JLabel();
        jPasswordField1 = new JPasswordField();
        registerButton = new JButton();
        goBackButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cadastro");

        nameLabel.setLabelFor(nameTextField);
        nameLabel.setText("Nome:");

        nameLabel1.setLabelFor(nameTextField);
        nameLabel1.setText("Endereço:");

        nameLabel2.setLabelFor(nameTextField);
        nameLabel2.setText("CPF");

        nameLabel3.setLabelFor(nameTextField);
        nameLabel3.setText("Sexo:");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        nameLabel4.setLabelFor(nameTextField);
        nameLabel4.setText("Data de nascimento:");

        nameLabel5.setLabelFor(nameTextField);
        nameLabel5.setText("Senha");

        jPasswordField1.setText("jPasswordField1");

        registerButton.setText("Cadastrar");
        registerButton.addActionListener(this::registerButtonActionPerformed);

        goBackButton.setText("Cancelar");
        goBackButton.addActionListener(this::goBackButtonActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(200, 200, 200)
                                                                .addComponent(jLabel1))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(120, 120, 120)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(nameLabel5)
                                                                        .addComponent(nameLabel)
                                                                        .addComponent(nameTextField)
                                                                        .addComponent(nameLabel1)
                                                                        .addComponent(nameTextField1, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                                        .addComponent(nameLabel2)
                                                                        .addComponent(nameTextField2, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                                        .addComponent(nameLabel3)
                                                                        .addComponent(birthdayField)
                                                                        .addComponent(nameLabel4)
                                                                        .addComponent(jComboBox1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jPasswordField1))))
                                                .addGap(0, 108, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(goBackButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(registerButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1)
                                .addGap(12, 12, 12)
                                .addComponent(nameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameLabel4)
                                .addGap(1, 1, 1)
                                .addComponent(birthdayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameLabel3)
                                .addGap(3, 3, 3)
                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(registerButton)
                                        .addComponent(goBackButton))
                                .addContainerGap())
        );

        registerButton.getAccessibleContext().setAccessibleName("Cadastrar");

        pack();
        setVisible(true);
    }

    private void registerButtonActionPerformed(ActionEvent evt) {
        // TODO
    }

    private void goBackButtonActionPerformed(ActionEvent evt) {
        // TODO
    }
}
