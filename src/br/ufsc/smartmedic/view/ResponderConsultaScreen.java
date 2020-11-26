package br.ufsc.smartmedic.view;

import br.ufsc.smartmedic.controller.ControladorConsulta;
import br.ufsc.smartmedic.controller.ControladorGeral;
import br.ufsc.smartmedic.controller.ControladorMedicamentos;
import br.ufsc.smartmedic.model.Consulta;
import br.ufsc.smartmedic.model.Medicamento;
import br.ufsc.smartmedic.model.PrescricaoMedicamento;
import br.ufsc.smartmedic.model.formularios.FormularioRespostaChamado;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ResponderConsultaScreen extends JFrame {
    private JComboBox<Consulta> selectConsultaComboBox;
    private Consulta consultaAtual;
    private Consulta[] consultas;
    private JScrollPane fichaDeSintomasTextPane;
    private JScrollPane diagnosticoScrollPane;
    private JButton concluirButton;
    private JCheckBox encaminharCheckbox;
    private JTextField frequanciaMedicamentoTextField;
    private JLabel frequenciaMedicamentoLabel;
    private JLabel diagnosticoLabel;
    private JScrollPane jScrollPane1;
    private JTextPane diagnosticoTextPane;
    private JLabel medicamentosLabel;
    private JList<String> medicamentosList;
    private JLabel medicamentosOutroLabel;
    private JTextField medicamentosOutroTextField;
    private JLabel medicamentosOutroTooltip;
    private JLabel responderConsultaLabel;
    private JLabel selectConsultaLabel;
    private JLabel sintomasLabel;
    private JTextPane sintomasTextPane;
    private JComboBox<String> unidadesDeSaudeComboBox;
    private JLabel unidadesDeSaúdeLabel;
    private JButton voltarButton;

    public ResponderConsultaScreen(Consulta[] consultas) {
        this.consultas = consultas;
        initComponents();
    }

    private void initComponents() {
        responderConsultaLabel = new JLabel();
        selectConsultaComboBox = new JComboBox<>();
        selectConsultaLabel = new JLabel();
        fichaDeSintomasTextPane = new JScrollPane();
        sintomasTextPane = new JTextPane();
        sintomasLabel = new JLabel();
        diagnosticoLabel = new JLabel();
        diagnosticoScrollPane = new JScrollPane();
        diagnosticoTextPane = new JTextPane();
        jScrollPane1 = new JScrollPane();
        medicamentosList = new JList<>();
        medicamentosLabel = new JLabel();
        medicamentosOutroTextField = new JTextField();
        medicamentosOutroLabel = new JLabel();
        medicamentosOutroTooltip = new JLabel();
        frequanciaMedicamentoTextField = new JTextField();
        frequenciaMedicamentoLabel = new JLabel();
        encaminharCheckbox = new JCheckBox();
        unidadesDeSaudeComboBox = new JComboBox<>();
        unidadesDeSaúdeLabel = new JLabel();
        concluirButton = new JButton();
        voltarButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        responderConsultaLabel.setText("Responder a um chamado");
        responderConsultaLabel.setAlignmentY(0.0F);

        selectConsultaComboBox.setModel(new DefaultComboBoxModel<>(this.consultas));
        selectConsultaComboBox.addActionListener(this::selectConsultaComboBoxActionPerformed);

        selectConsultaLabel.setText("Selecione a consulta:");

        sintomasTextPane.setEditable(false);
        fichaDeSintomasTextPane.setViewportView(sintomasTextPane);

        sintomasLabel.setText("Sintomas do paciente:");

        diagnosticoLabel.setText("Diagnóstico/Observações:");

        diagnosticoScrollPane.setViewportView(diagnosticoTextPane);

        jScrollPane1.setViewportView(medicamentosList);

        medicamentosLabel.setText("Medicamentos que serão receitados:");

        medicamentosOutroTextField.setText("");
        medicamentosOutroTextField.addActionListener(this::medicamentosOutroTextFieldActionPerformed);

        medicamentosOutroLabel.setText("Medicamentos a serem receitados (outro):");

        medicamentosOutroTooltip.setText("Para múltiplos medicamentos favor separar por vírgula.");

        frequanciaMedicamentoTextField.setText("");

        frequenciaMedicamentoLabel.setText("Frequência que o medicamento deverá ser utilizado:");

        encaminharCheckbox.setText("Encaminhar o paciente");
        encaminharCheckbox.addActionListener(this::encaminharCheckboxActionPerformed);

        unidadesDeSaudeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        unidadesDeSaúdeLabel.setText("Unidades de saúde");

        concluirButton.setText("Concluir");
        concluirButton.addActionListener(this::concluirButtonActionPerformed);

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(this::voltarButtonActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(137, 137, 137)
                                                .addComponent(responderConsultaLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(medicamentosOutroTooltip)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(medicamentosOutroTextField, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                                                .addComponent(medicamentosOutroLabel)
                                                                .addComponent(medicamentosLabel)
                                                                .addComponent(sintomasLabel)
                                                                .addComponent(selectConsultaLabel)
                                                                .addComponent(diagnosticoLabel)
                                                                .addComponent(fichaDeSintomasTextPane)
                                                                .addComponent(selectConsultaComboBox, GroupLayout.Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(diagnosticoScrollPane)
                                                                .addComponent(jScrollPane1))
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(frequanciaMedicamentoTextField)
                                                                        .addGap(38, 38, 38))
                                                                .addComponent(frequenciaMedicamentoLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(encaminharCheckbox)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(unidadesDeSaudeComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addGap(0, 37, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(unidadesDeSaúdeLabel)
                                                .addGap(119, 119, 119))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(voltarButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(concluirButton)
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(responderConsultaLabel)
                                .addGap(12, 12, 12)
                                .addComponent(selectConsultaLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectConsultaComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sintomasLabel)
                                .addGap(4, 4, 4)
                                .addComponent(fichaDeSintomasTextPane, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diagnosticoLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diagnosticoScrollPane, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(medicamentosLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(medicamentosOutroLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(medicamentosOutroTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(medicamentosOutroTooltip)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(frequenciaMedicamentoLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(frequanciaMedicamentoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unidadesDeSaúdeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(encaminharCheckbox)
                                        .addComponent(unidadesDeSaudeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(concluirButton)
                                        .addComponent(voltarButton))
                                .addContainerGap())
        );
        pack();
        updateMedicamentosData();
        setVisible(true);
    }

    private void selectConsultaComboBoxActionPerformed(ActionEvent evt) {
        Consulta consultaSelecionada = (Consulta) selectConsultaComboBox.getSelectedItem();
        setConsultaAtual(ControladorConsulta.getInstance().getConsultaById(consultaSelecionada.getId()));
        sintomasTextPane.setText(consultaAtual.getFichaSintomas().getCorpo());
    }

    private void medicamentosOutroTextFieldActionPerformed(ActionEvent evt) {
        // TODO
    }

    private void encaminharCheckboxActionPerformed(ActionEvent evt) {
        // TODO
    }

    private void concluirButtonActionPerformed(ActionEvent evt) {
        FormularioRespostaChamado formularioRespostaChamado = new FormularioRespostaChamado();
        formularioRespostaChamado.setDiagnostico(diagnosticoTextPane.getText());
        List<Medicamento> listaMedicamentos = (List<Medicamento>)(List<?>)medicamentosList.getSelectedValuesList();
        List<Medicamento> outrosMedicamentos = null;
        if (medicamentosOutroTextField != null) {
            List<String> outrosMedicamentosField = Arrays.asList(medicamentosOutroTextField.getText().split(", "));
            if (!outrosMedicamentosField.isEmpty()) {
                outrosMedicamentos = ControladorMedicamentos.getInstance().criaOutrosMedicamentos(outrosMedicamentosField);
            }
        }
        assert outrosMedicamentos != null;
        listaMedicamentos.addAll(outrosMedicamentos);
        List<String> frequencias = Arrays.asList(frequanciaMedicamentoTextField.getText().split(", "));
        List<PrescricaoMedicamento> prescricaoMedicamentos = ControladorMedicamentos.getInstance().novasPrescricoes(listaMedicamentos, frequencias);
        formularioRespostaChamado.setPrescricaoMedicamentos(prescricaoMedicamentos);
    }

    private void voltarButtonActionPerformed(ActionEvent evt) {
        ControladorGeral.getInstance().abreTelaPrincipal();
        this.dispose();
    }

    private void setConsultaAtual(Consulta consultaAtual) {
        this.consultaAtual = consultaAtual;
    }

    private void updateMedicamentosData() {
        DefaultListModel medicamentosModel = new DefaultListModel();
        Medicamento[] medicamentos = (ControladorConsulta.getInstance().getMedicamentosConsulta());
        Stream<Medicamento> medicamentoStream = Arrays.stream(medicamentos);
        medicamentoStream.forEach(medicamentosModel::addElement);
        this.medicamentosList.setModel(medicamentosModel);
        this.repaint();
    }
}
