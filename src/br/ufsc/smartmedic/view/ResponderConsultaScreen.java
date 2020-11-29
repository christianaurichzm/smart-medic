package br.ufsc.smartmedic.view;

import br.ufsc.smartmedic.controller.*;
import br.ufsc.smartmedic.model.*;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.model.excecoes.NoDoctorAvailableException;
import br.ufsc.smartmedic.model.formularios.FormularioRespostaChamado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
    private JComboBox<UnidadeAtendimento> unidadesDeSaudeComboBox;
    private JLabel unidadesDeSaúdeLabel;
    private JButton voltarButton;
    private JComboBox<String> especialidadeComboBox1;
    private JLabel especialidadeLabel1;
    private JLabel medicamentosOutroTooltip1;

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
        especialidadeLabel1 = new JLabel();
        especialidadeComboBox1 = new JComboBox<>();
        medicamentosOutroTooltip1 = new JLabel();

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

        medicamentosOutroTooltip.setText("Para múltiplos medicamentos favor separar por vírgula");

        frequanciaMedicamentoTextField.setText("");

        frequenciaMedicamentoLabel.setText("Frequência que o medicamento deverá ser utilizado:");

        encaminharCheckbox.setText("Encaminhar o paciente");
        encaminharCheckbox.addActionListener(this::encaminharCheckboxActionPerformed);

        unidadesDeSaudeComboBox.setModel(new DefaultComboBoxModel<>(ControladorUnidadeAtendimento.getInstance().getTodasUnidadesAtendimento().stream().toArray(UnidadeAtendimento[]::new)));

        unidadesDeSaúdeLabel.setText("Unidades de saúde");

        concluirButton.setText("Concluir");
        concluirButton.addActionListener(this::concluirButtonActionPerformed);

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(this::voltarButtonActionPerformed);

        medicamentosOutroTooltip1.setText("os campos de frequência e medicamentos receitados.");

        especialidadeLabel1.setText("Especialidade do médico");
        especialidadeComboBox1.setModel(new DefaultComboBoxModel<>(ControladorUsuario.getInstance().getAllSpecialties().stream().toArray(String[]::new)));

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
                                                        .addComponent(frequenciaMedicamentoLabel, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
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
                                                        .addComponent(frequanciaMedicamentoTextField, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(unidadesDeSaúdeLabel)
                                                        .addComponent(encaminharCheckbox)
                                                        .addComponent(especialidadeLabel1)
                                                        .addComponent(unidadesDeSaudeComboBox, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(especialidadeComboBox1, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(medicamentosOutroTooltip1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(medicamentosOutroTooltip, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(voltarButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(concluirButton)
                                .addContainerGap())
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
                                .addComponent(frequenciaMedicamentoLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(frequanciaMedicamentoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(medicamentosOutroTooltip)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(medicamentosOutroTooltip1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(encaminharCheckbox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unidadesDeSaúdeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unidadesDeSaudeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(especialidadeLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(especialidadeComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
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
        try {
            FormularioRespostaChamado formularioRespostaChamado = this.fieldsToForm();
            ControladorConsulta.getInstance().respondeChamado(consultaAtual, formularioRespostaChamado);
            this.dispose();
            ControladorGeral.getInstance().abreTelaPrincipal();
        } catch (FormException | NoDoctorAvailableException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
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

    private FormularioRespostaChamado fieldsToForm() throws FormException, NoDoctorAvailableException {
        FormularioRespostaChamado formularioRespostaChamado = new FormularioRespostaChamado();
        formularioRespostaChamado.setDiagnostico(diagnosticoTextPane.getText());
        List<Medicamento> listaMedicamentos = (List<Medicamento>)(List<?>)medicamentosList.getSelectedValuesList();
        List<Medicamento> outrosMedicamentos = null;
        List<PrescricaoMedicamento> prescricaoMedicamentos = null;
        if (!medicamentosOutroTextField.getText().isEmpty()) {
            List<String> outrosMedicamentosField = Arrays.asList(medicamentosOutroTextField.getText().split(", "));
            if (!outrosMedicamentosField.isEmpty()) {
                outrosMedicamentos = ControladorMedicamentos.getInstance().criaOutrosMedicamentos(outrosMedicamentosField);
            }
            assert outrosMedicamentos != null;
            listaMedicamentos.addAll(outrosMedicamentos);
        }
        if (!frequanciaMedicamentoTextField.getText().isEmpty()) {
            if (!listaMedicamentos.isEmpty()) {
                List<String> frequencias = Arrays.asList(frequanciaMedicamentoTextField.getText().split(", "));
                prescricaoMedicamentos = ControladorMedicamentos.getInstance().novasPrescricoes(listaMedicamentos, frequencias);
            }
        } else {
            throw new FormException("O preenchimento da frequência é obrigatória caso haja medicamentos para prescrever.");
        }
        formularioRespostaChamado.setPrescricaoMedicamentos(prescricaoMedicamentos);
        formularioRespostaChamado.setEncaminhamento(this.encaminharCheckbox.isSelected());
        if (this.encaminharCheckbox.isSelected()) {
            UnidadeAtendimento unidadeAtendimentoEncaminhamento = (UnidadeAtendimento) this.unidadesDeSaudeComboBox.getSelectedItem();
            formularioRespostaChamado.setUnidadeDeEncaminhamento(unidadeAtendimentoEncaminhamento);
            if (formularioRespostaChamado.getUnidadeDeEncaminhamento() != null) {
                Medico medicoDisponivel = ControladorUsuario.getInstance().getMedicoDisponivelNaUnidadeBySpecialty(
                        formularioRespostaChamado.getUnidadeDeEncaminhamento(),
                        Objects.requireNonNull(this.especialidadeComboBox1.getSelectedItem()).toString()
                );
                formularioRespostaChamado.setMedicoEncaminhamento(medicoDisponivel);
            }
        }
        return formularioRespostaChamado;
    }
}
