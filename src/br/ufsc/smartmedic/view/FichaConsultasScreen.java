package br.ufsc.smartmedic.view;


import br.ufsc.smartmedic.controller.ControladorGeral;
import br.ufsc.smartmedic.controller.ControladorUsuario;
import br.ufsc.smartmedic.model.Usuario;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.model.formularios.FormularioNovaConsulta;

import javax.swing.*;
import java.util.List;

public class FichaConsultasScreen extends javax.swing.JFrame {

    private String[] competencias;
    public FichaConsultasScreen(List<String> competencias) {
        this.competencias = new String[competencias.size()];
        this.competencias = competencias.toArray(this.competencias);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        windowTitle = new javax.swing.JLabel();
        medicSpeciality = new javax.swing.JComboBox<>();
        comboBoxLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        symptonsTextArea = new javax.swing.JTextArea();
        textFieldLabel = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        windowTitle.setText("Preencher ficha de sintomas");

        medicSpeciality.setModel(new javax.swing.DefaultComboBoxModel<>(this.competencias));

        comboBoxLabel.setText("Especialidade do médico:");

        symptonsTextArea.setColumns(20);
        symptonsTextArea.setRows(5);
        jScrollPane1.setViewportView(symptonsTextArea);

        textFieldLabel.setText("Descreva seus sintomas:");

        sendButton.setText("Enviar");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    sendButtonActionPerformed(evt);
                } catch (FormException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(44, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(comboBoxLabel)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(medicSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(textFieldLabel))
                                                .addGap(41, 41, 41))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(cancelButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sendButton)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(windowTitle)
                                                .addGap(130, 130, 130))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(windowTitle)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(medicSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(sendButton)
                                        .addComponent(cancelButton))
                                .addContainerGap())
        );

        pack();
        setVisible(true);
    }

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) throws FormException {
        this.camposToForm();
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ControladorGeral.getInstance().abreTelaPrincipal();
        this.dispose();
    }

    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel comboBoxLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> medicSpeciality;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextArea symptonsTextArea;
    private javax.swing.JLabel textFieldLabel;
    private javax.swing.JLabel windowTitle;


    private FormularioNovaConsulta camposToForm() throws FormException {
        String competencia = this.medicSpeciality.getSelectedItem().toString();
        String corpo = this.symptonsTextArea.getText();
        Usuario paciente = ControladorUsuario.getInstance().getUsuarioSessao();
        return new FormularioNovaConsulta(1L,competencia, corpo, paciente);
    }
}
