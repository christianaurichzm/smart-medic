package br.ufsc.smartmedic.view;

import br.ufsc.smartmedic.controller.ControladorGeral;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainMenuScreen extends JFrame {
    private JButton showHistoryButton;
    private JButton newApointmentButton;
    private JButton changeRegisteredDataButton;
    private JLabel mainMenuTitle;
    private JButton logOutButton;
    private JButton answerCall;

    public MainMenuScreen() {
        initComponents();
    }

    private void initComponents() {
        mainMenuTitle = new JLabel();
        showHistoryButton = new JButton();
        logOutButton = new JButton();
        newApointmentButton = new JButton();
        changeRegisteredDataButton = new JButton();
        answerCall = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainMenuTitle.setText("Menu principal");

        showHistoryButton.setText("Ver histórico de consultas");
        showHistoryButton.addActionListener(this::showHistoryButtonActionPerformed);

        logOutButton.setText("Sair");
        logOutButton.addActionListener(this::logOutButtonActionPerformed);

        newApointmentButton.setText("Realizar nova chamada");
        newApointmentButton.addActionListener(this::newAppointmentButtonActionPerformed);

        changeRegisteredDataButton.setText("Alterar dados cadastrais");
        changeRegisteredDataButton.addActionListener(this::changeRegisteredDataButtonActionPerformed);

        answerCall.setText("Responder chamados");
        answerCall.addActionListener(this::answerCallButtonActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(logOutButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(122, 122, 122)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(showHistoryButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(changeRegisteredDataButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(newApointmentButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 113, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(mainMenuTitle)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(mainMenuTitle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(showHistoryButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(newApointmentButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeRegisteredDataButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(logOutButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
        setVisible(true);
    }

    private void showHistoryButtonActionPerformed(ActionEvent evt) {
        ControladorGeral.getInstance().abreHistoricoConsultas();
        this.dispose();
    }

    private void logOutButtonActionPerformed(ActionEvent evt) {
        //ControladorGeral.getInstance().realizaLogout();
        ControladorGeral.getInstance().abreTelaResponderChamado();
        this.dispose();
    }

    private void newAppointmentButtonActionPerformed(ActionEvent evt) {
        ControladorGeral.getInstance().abreTelaRealizarNovaChamada();
        this.dispose();
    }

    private void changeRegisteredDataButtonActionPerformed(ActionEvent evt) {
        ControladorGeral.getInstance().abreTelaAlterarCadastro();
        this.dispose();
    }

    private void answerCallButtonActionPerformed(ActionEvent evt) {
        ControladorGeral.getInstance().abreTelaResponderChamado();
        this.dispose();
    }
}
