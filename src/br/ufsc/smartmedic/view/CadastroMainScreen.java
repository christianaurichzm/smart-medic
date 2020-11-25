package br.ufsc.smartmedic.view;

import br.ufsc.smartmedic.controller.ControladorGeral;
import br.ufsc.smartmedic.controller.ControladorUnidadeAtendimento;
import br.ufsc.smartmedic.model.TipoUsuario;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.model.excecoes.UserNotLoggedException;
import br.ufsc.smartmedic.model.formularios.FormularioAlteracaoDeDados;
import br.ufsc.smartmedic.model.formularios.FormularioCadastro;
import br.ufsc.smartmedic.model.formularios.FormularioCadastroMedico;
import br.ufsc.smartmedic.model.formularios.FormularioCadastroPaciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class CadastroMainScreen extends JFrame {
    private JFormattedTextField nascimentoTextField;
    private JButton goBackButton;
    private JComboBox<String> sexoComboBox;
    private JComboBox<String> unidadeAtendimentoComboBox;
    private JLabel cadastroLabel;
    private JPasswordField senhaPasswordField;
    private JPasswordField confirmarSenhaPasswordField;
    private JLabel nameLabel;
    private JLabel enderecoLabel;
    private JLabel unidadeAtendimentoLabel;
    private JLabel cpfLabel;
    private JLabel sexoLabel;
    private JLabel dataLabel;
    private JLabel senhaLabel;
    private JLabel crmLabel;
    private JLabel confirmarSenhaLabel;
    private JLabel competenciaLabel;
    private JTextField nomeTextField;
    private JTextField enderecoTextField;
    private JTextField cpfTextField;
    private JTextField crmTextField;
    private JTextField competenciaTextField;
    private JButton salvarButton;
    private TipoUsuario tipoUsuario;
    private String[] unidadesDeAtendimento;
    private boolean alterarCadastro;

    public CadastroMainScreen(TipoUsuario tipoUsuario, String[] unidadesDeAtendimento, boolean alterarCadastro) {
        this.tipoUsuario = tipoUsuario;
        this.unidadesDeAtendimento = unidadesDeAtendimento;
        this.alterarCadastro = alterarCadastro;
        initComponents();
    }

    private void initComponents() {
        cadastroLabel = new JLabel();
        nomeTextField = new JTextField();
        nameLabel = new JLabel();
        enderecoLabel = new JLabel();
        enderecoTextField = new JTextField();
        cpfTextField = new JTextField();
        cpfLabel = new JLabel();
        nascimentoTextField = new JFormattedTextField();
        sexoLabel = new JLabel();
        sexoComboBox = new JComboBox<>();
        dataLabel = new JLabel();
        senhaLabel = new JLabel();
        senhaPasswordField = new JPasswordField();
        salvarButton = new JButton();
        goBackButton = new JButton();
        crmTextField = new JTextField();
        crmLabel = new JLabel();
        confirmarSenhaLabel = new JLabel();
        confirmarSenhaPasswordField = new JPasswordField();
        competenciaTextField = new JTextField();
        competenciaLabel = new JLabel();
        unidadeAtendimentoLabel = new JLabel();
        unidadeAtendimentoComboBox = new JComboBox<>();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nameLabel.setLabelFor(nomeTextField);
        nameLabel.setText("Nome:");

        enderecoLabel.setLabelFor(enderecoTextField);
        enderecoLabel.setText("Endereço:");

        sexoLabel.setLabelFor(sexoComboBox);
        sexoLabel.setText("Sexo:");

        sexoComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outro" }));

        dataLabel.setLabelFor(nascimentoTextField);
        dataLabel.setText("Data de nascimento:");

        senhaLabel.setLabelFor(senhaPasswordField);
        senhaLabel.setText("Senha:");

        if (alterarCadastro) {
            salvarButton.setText("Salvar");
            salvarButton.addActionListener(this::salvarButtonActionPerformed);
            cadastroLabel.setText("Alterar dados cadastrais");
        } else {
            salvarButton.setText("Cadastrar");
            salvarButton.addActionListener(this::salvarButtonActionPerformed);
            cadastroLabel.setText("Cadastro");
            cpfLabel.setLabelFor(cpfTextField);
            cpfLabel.setText("CPF:");
        }

        goBackButton.setText("Cancelar");
        goBackButton.addActionListener(this::goBackButtonActionPerformed);

        if (this.tipoUsuario.equals(TipoUsuario.MEDICO)) {
            if (!this.alterarCadastro) {
                crmLabel.setLabelFor(crmTextField);
                crmLabel.setText("CRM:");
            }

            competenciaLabel.setLabelFor(competenciaTextField);
            competenciaLabel.setText("Competencia:");

            unidadeAtendimentoLabel.setLabelFor(unidadeAtendimentoComboBox);
            unidadeAtendimentoLabel.setText("Unidade de atendimento:");
        }

        confirmarSenhaLabel.setLabelFor(confirmarSenhaPasswordField);
        confirmarSenhaLabel.setText("Confirmar senha:");

        unidadeAtendimentoComboBox.setModel(new DefaultComboBoxModel<>(this.unidadesDeAtendimento));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(cadastroLabel)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(goBackButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(salvarButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(enderecoTextField, GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(competenciaTextField, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(senhaLabel, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(nameLabel, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(enderecoLabel, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(cpfLabel, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(cpfTextField, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(nascimentoTextField, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(dataLabel, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(senhaPasswordField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                                                .addComponent(nomeTextField, GroupLayout.Alignment.LEADING))
                                                                        .addComponent(competenciaLabel))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(crmTextField)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(crmLabel)
                                                                                        .addComponent(sexoLabel)
                                                                                        .addComponent(confirmarSenhaLabel))
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addComponent(confirmarSenhaPasswordField)
                                                                        .addComponent(sexoComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(unidadeAtendimentoLabel)
                                                                                .addGap(138, 138, 138))
                                                                        .addComponent(unidadeAtendimentoComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(cadastroLabel)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nomeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enderecoLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(enderecoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(cpfLabel)
                                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(cpfTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(crmLabel)
                                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(crmTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(dataLabel)
                                                                                .addGap(1, 1, 1)
                                                                                .addComponent(nascimentoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(sexoLabel)
                                                                                .addGap(3, 3, 3)
                                                                                .addComponent(sexoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(senhaLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(senhaPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(confirmarSenhaLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(confirmarSenhaPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(competenciaLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(competenciaTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(unidadeAtendimentoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(unidadeAtendimentoLabel)
                                                .addGap(26, 26, 26)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(salvarButton)
                                        .addComponent(goBackButton))
                                .addContainerGap())
        );

        pack();
        setVisible(true);

        if (this.tipoUsuario.equals(TipoUsuario.PACIENTE)) {
            crmTextField.setVisible(false);
            competenciaTextField.setVisible(false);
            unidadeAtendimentoComboBox.setVisible(false);
        }
        if (this.alterarCadastro) {
            cpfTextField.setVisible(false);
            crmTextField.setVisible(false);
        }
    }

    private void salvarButtonActionPerformed(ActionEvent evt) {
        ControladorGeral controladorGeral = ControladorGeral.getInstance();
        if (this.alterarCadastro) {
            try {
                controladorGeral.salvarAlteracaoDadosCadastrais(this.toFormularioAlteracao());
                controladorGeral.abreTelaPrincipal();
                this.dispose();
            } catch (FormException | UserNotLoggedException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            try {
                ControladorGeral.getInstance().realizaCadastro(this.toFormularioCadastral());
                controladorGeral.abreTelaInicial();
                this.dispose();
            } catch (FormException formException) {
                JOptionPane.showMessageDialog(null, formException.getMessage());
            }
        }
    }

    private void goBackButtonActionPerformed(ActionEvent evt) {
        if (this.alterarCadastro) {
            ControladorGeral.getInstance().abreTelaPrincipal();
        } else {
            ControladorGeral.getInstance().abreTelaInicial();
        }
        this.dispose();
    }

    private FormularioAlteracaoDeDados toFormularioAlteracao() throws FormException {
        String senha = new String(senhaPasswordField.getPassword());
        if (!senha.isEmpty()) {
            try {
                senha = this.compararSenhas();
            } catch (FormException formException) {
                JOptionPane.showMessageDialog(null, formException.getMessage() );
            }
        }

        if (this.tipoUsuario.equals(TipoUsuario.MEDICO)) {
            return new FormularioAlteracaoDeDados(
                this.nomeTextField.getText(),
                this.sexoComboBox.getSelectedItem().toString(),
                this.nascimentoTextField.getText(),
                senha,
                this.enderecoTextField.getText(),
                this.competenciaTextField.getText(),
                this.unidadeAtendimentoComboBox.getSelectedItem().toString());
        } else {
            return new FormularioAlteracaoDeDados(
                this.nomeTextField.getText(),
                this.sexoComboBox.getSelectedItem().toString(),
                this.nascimentoTextField.getText(),
                senha,
                this.enderecoTextField.getText(),
                competenciaTextField.getText(),
                null);
        }
    }

    private String compararSenhas() throws FormException{
        if (!Arrays.equals(senhaPasswordField.getPassword(), confirmarSenhaPasswordField.getPassword())) {
            throw new FormException("As senhas não coincidem");
        }
        return new String(senhaPasswordField.getPassword());
    }

    private FormularioCadastro toFormularioCadastral() throws FormException {
        String senha = "";
        try {
            senha = this.compararSenhas();
        } catch (FormException formException) {
            JOptionPane.showMessageDialog(null, formException.getMessage() );
        }

        if (this.tipoUsuario.equals(TipoUsuario.MEDICO)) {
            return new FormularioCadastroMedico(
                this.cpfTextField.getText(),
                this.nomeTextField.getText(),
                this.sexoComboBox.getSelectedItem().toString(),
                senha,
                this.nascimentoTextField.getText(),
                this.enderecoTextField.getText(),
                this.crmTextField.getText(),
                this.competenciaTextField.getText(),
                this.unidadeAtendimentoComboBox.getSelectedItem().toString(),
                this.tipoUsuario
            );
        } else {
            return new FormularioCadastroPaciente(
                this.cpfTextField.getText(),
                this.nomeTextField.getText(),
                this.sexoComboBox.getSelectedItem().toString(),
                senha,
                this.nascimentoTextField.getText(),
                this.enderecoTextField.getText(),
                this.tipoUsuario
            );
        }
    }
}