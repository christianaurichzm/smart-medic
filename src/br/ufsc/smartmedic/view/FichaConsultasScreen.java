package br.ufsc.smartmedic.view;

import br.ufsc.smartmedic.controller.ControladorConsulta;
import br.ufsc.smartmedic.controller.ControladorGeral;
import br.ufsc.smartmedic.controller.ControladorUsuario;
import br.ufsc.smartmedic.model.Consulta;
import br.ufsc.smartmedic.model.Usuario;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.model.excecoes.NoDoctorAvailableException;
import br.ufsc.smartmedic.model.excecoes.UserNotLoggedException;
import br.ufsc.smartmedic.model.formularios.FormularioNovaConsulta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Objects;

public class FichaConsultasScreen extends JFrame {
    private JButton cancelButton;
    private JLabel comboBoxLabel;
    private JScrollPane jScrollPane1;
    private JComboBox<String> medicSpeciality;
    private JButton sendButton;
    private JTextArea symptonsTextArea;
    private JLabel textFieldLabel;
    private JLabel windowTitle;
    private String[] competencias;

    public FichaConsultasScreen(List<String> competencias, Usuario usuario) {
        if (usuario.getSexo().equals("Feminino") || usuario.getSexo().equals("Outro")) {
            competencias.add("ginecologista");
            competencias.add("obstetra");
        }
        if (usuario.getSexo().equals("Masculino") || usuario.getSexo().equals("Outro")) {
            competencias.add("andrologista");
        }
        if (usuario.isMinor()) {
            competencias.add("pediatra");
        }
        if (usuario.isElder()) {
            competencias.add("geriatra");
        }
        this.competencias = new String[competencias.size()];
        this.competencias = competencias.toArray(this.competencias);
        initComponents();
    }

    private void initComponents() {
        windowTitle = new JLabel();
        medicSpeciality = new JComboBox<>();
        comboBoxLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        symptonsTextArea = new JTextArea();
        textFieldLabel = new JLabel();
        sendButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        windowTitle.setText("Preencher ficha de sintomas");

        medicSpeciality.setModel(new DefaultComboBoxModel<>(this.competencias));

        comboBoxLabel.setText("Especialidade do médico:");

        symptonsTextArea.setColumns(20);
        symptonsTextArea.setRows(5);
        jScrollPane1.setViewportView(symptonsTextArea);

        textFieldLabel.setText("Descreva seus sintomas:");

        sendButton.setText("Enviar");
        sendButton.addActionListener(evt -> {
            try {
                sendButtonActionPerformed(evt);
            } catch (FormException | UserNotLoggedException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(44, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(comboBoxLabel)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(medicSpeciality, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(textFieldLabel))
                                                .addGap(41, 41, 41))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(cancelButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sendButton)
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(windowTitle)
                                                .addGap(130, 130, 130))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(windowTitle)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(medicSpeciality, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(sendButton)
                                        .addComponent(cancelButton))
                                .addContainerGap())
        );

        pack();
        setVisible(true);
    }

    private void sendButtonActionPerformed(ActionEvent evt) throws FormException, UserNotLoggedException {
        FormularioNovaConsulta form = this.camposToForm();
        try {
            ControladorConsulta.getInstance().criarNovaConsulta(form);
            ControladorGeral.getInstance().abreTelaPrincipal();
            this.dispose();
        } catch (NoDoctorAvailableException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            ControladorGeral.getInstance().abreTelaPrincipal();
            this.dispose();
        }
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        ControladorGeral.getInstance().abreTelaPrincipal();
        this.dispose();
    }

    private FormularioNovaConsulta camposToForm() throws FormException, UserNotLoggedException {
        String competencia = Objects.requireNonNull(this.medicSpeciality.getSelectedItem()).toString();
        String corpo = this.symptonsTextArea.getText();
        Usuario paciente = ControladorUsuario.getInstance().getUsuarioSessao();
        List<Consulta> consultas = ControladorConsulta.getInstance().getMapeadorConsulta().getList();

        long id = 1L;
        if (!consultas.isEmpty()) {
            Consulta ultimaConsulta = consultas.get(consultas.size() - 1);
            id = ultimaConsulta.getId() + 1;
        }

        return new FormularioNovaConsulta(
                id,
                competencia,
                corpo,
                paciente);
    }
}
