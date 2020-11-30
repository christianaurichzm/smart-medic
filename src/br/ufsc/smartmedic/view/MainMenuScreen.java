package br.ufsc.smartmedic.view;

import br.ufsc.smartmedic.controller.ControladorGeral;
import br.ufsc.smartmedic.controller.ControladorUsuario;
import br.ufsc.smartmedic.model.TipoUsuario;
import br.ufsc.smartmedic.model.excecoes.UserNotLoggedException;

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

        try {
            if (ControladorUsuario.getInstance().getUsuarioSessao().getTipoUsuario() == TipoUsuario.PACIENTE) {
                answerCall.setVisible(false);
            }
        } catch (UserNotLoggedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(mainMenuTitle)
                                .addContainerGap(167, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(changeRegisteredDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(showHistoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(newApointmentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(answerCall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(121, 121, 121))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(mainMenuTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(showHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(newApointmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeRegisteredDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(answerCall, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
    }

    private void showHistoryButtonActionPerformed(ActionEvent evt) {
        ControladorGeral.getInstance().abreHistoricoConsultas();
        this.dispose();
    }

    private void logOutButtonActionPerformed(ActionEvent evt) {
        try {
            ControladorGeral.getInstance().realizaLogout();
        } catch (UserNotLoggedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        this.dispose();
    }

    private void newAppointmentButtonActionPerformed(ActionEvent evt) {
        try {
            ControladorGeral.getInstance().abreTelaRealizarNovaChamada();
        } catch (UserNotLoggedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        this.dispose();
    }

    private void changeRegisteredDataButtonActionPerformed(ActionEvent evt) {
        try {
            ControladorGeral.getInstance().abreTelaAlterarCadastro();
        } catch (UserNotLoggedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        this.dispose();
    }

    private void answerCallButtonActionPerformed(ActionEvent evt) {
        try {
            ControladorGeral.getInstance().abreTelaResponderChamado();
        } catch (UserNotLoggedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        this.dispose();
    }
}
