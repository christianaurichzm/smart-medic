package br.ufsc.smartmedic.view;

import br.ufsc.smartmedic.controller.ControladorGeral;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CadastroScreen extends JFrame {
    private JButton goBackButton;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JButton medicoButton;
    private JButton patientButton;

    public CadastroScreen() {
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        medicoButton = new JButton();
        patientButton = new JButton();
        goBackButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        jLabel1.setText("Cadastro");

        jLabel2.setText("Você deseja se cadastrar como médico ou paciente?");

        medicoButton.setText("Médico");
        medicoButton.addActionListener(this::medicoButtonActionPerformed);

        patientButton.setText("Paciente");

        goBackButton.setText("Voltar");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jLabel1)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(100, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel2)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(patientButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(medicoButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(90, 90, 90))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(goBackButton)
                                                .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(medicoButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addComponent(goBackButton)
                                .addGap(25, 25, 25))
        );

        pack();
        setVisible(true);
    }

    private void medicoButtonActionPerformed(ActionEvent evt) {
        ControladorGeral.getInstance().abreTelaCadastroMedico();
    }
}
