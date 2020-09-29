package br.ufsc.smartmedic.view;

import br.ufsc.smartmedic.controller.ControladorGeral;
import br.ufsc.smartmedic.controller.ControladorUsuario;
import br.ufsc.smartmedic.model.TipoUsuario;
import br.ufsc.smartmedic.model.excecoes.FormException;
import br.ufsc.smartmedic.model.formularios.FormularioCadastro;
import br.ufsc.smartmedic.model.formularios.FormularioCadastroMedico;
import br.ufsc.smartmedic.model.formularios.FormularioCadastroPaciente;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CadastroMainScreen extends JFrame {
    private JFormattedTextField birthdayField;
    private JButton goBackButton;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JLabel jLabel1;
    private JPasswordField jPasswordField1;
    private JPasswordField jPasswordField2;
    private JLabel nameLabel;
    private JLabel nameLabel1;
    private JLabel nameLabel10;
    private JLabel nameLabel2;
    private JLabel nameLabel3;
    private JLabel nameLabel4;
    private JLabel nameLabel5;
    private JLabel nameLabel6;
    private JLabel nameLabel7;
    private JLabel nameLabel8;
    private JLabel nameLabel9;
    private JTextField nameTextField;
    private JTextField nameTextField1;
    private JTextField nameTextField2;
    private JTextField nameTextField3;
    private JTextField nameTextField4;
    private JTextField nameTextField5;
    private JButton registerButton;
    private TipoUsuario flag;
    private String[] unidadesDeAtendimento;

    public CadastroMainScreen(TipoUsuario flag, String[] unidadesDeAtendimento) {
        initComponents();
        this.flag = flag;
        this.unidadesDeAtendimento = unidadesDeAtendimento;
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
        nameTextField3 = new JTextField();
        nameLabel6 = new JLabel();
        nameTextField4 = new JTextField();
        nameLabel7 = new JLabel();
        nameLabel8 = new JLabel();
        jPasswordField2 = new JPasswordField();
        nameTextField5 = new JTextField();
        nameLabel9 = new JLabel();
        nameLabel10 = new JLabel();
        jComboBox2 = new JComboBox<>();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cadastro");

        nameLabel.setLabelFor(nameTextField);
        nameLabel.setText("Nome:");

        nameLabel1.setLabelFor(nameTextField);
        nameLabel1.setText("Endereço:");

        nameLabel2.setLabelFor(nameTextField);
        nameLabel2.setText("CPF:");

        nameLabel3.setLabelFor(nameTextField);
        nameLabel3.setText("Sexo:");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outro" }));

        nameLabel4.setLabelFor(nameTextField);
        nameLabel4.setText("Data de nascimento:");

        nameLabel5.setLabelFor(nameTextField);
        nameLabel5.setText("Senha:");

        jPasswordField1.setText("jPasswordField1");

        registerButton.setText("Cadastrar");
        registerButton.addActionListener(this::registerButtonActionPerformed);

        goBackButton.setText("Cancelar");
        goBackButton.addActionListener(this::goBackButtonActionPerformed);

        nameLabel6.setLabelFor(nameTextField);
        nameLabel6.setText("Idade:");

        if (this.flag.equals(TipoUsuario.MEDICO)) {
            nameLabel7.setLabelFor(nameTextField);
            nameLabel7.setText("CRM:");

            nameLabel9.setLabelFor(nameTextField);
            nameLabel9.setText("Competencia:");

            nameLabel10.setLabelFor(nameTextField);
            nameLabel10.setText("Unidade de atendimento:");
        }

        nameLabel8.setLabelFor(nameTextField);
        nameLabel8.setText("Confirmar senha:");

        jPasswordField2.setText("jPasswordField1");

        jComboBox2.setModel(new DefaultComboBoxModel<>(this.unidadesDeAtendimento));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jLabel1)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(goBackButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(registerButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(nameTextField1, GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(nameTextField5, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(nameLabel5, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(nameLabel, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(nameLabel1, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(nameLabel2, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(nameTextField2, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(birthdayField, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(nameLabel4, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jPasswordField1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                                                .addComponent(nameTextField, GroupLayout.Alignment.LEADING))
                                                                        .addComponent(nameLabel9))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(nameTextField3)
                                                                        .addComponent(nameTextField4)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(nameLabel6)
                                                                                        .addComponent(nameLabel7)
                                                                                        .addComponent(nameLabel3)
                                                                                        .addComponent(nameLabel8))
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addComponent(jPasswordField2)
                                                                        .addComponent(jComboBox1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(nameLabel10)
                                                                                .addGap(138, 138, 138))
                                                                        .addComponent(jComboBox2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(nameLabel6))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(nameTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(nameLabel2)
                                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(nameTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(nameLabel7)
                                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(nameTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(nameLabel4)
                                                                                .addGap(1, 1, 1)
                                                                                .addComponent(birthdayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(nameLabel3)
                                                                                .addGap(3, 3, 3)
                                                                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(nameLabel5)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(nameLabel8)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPasswordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nameLabel9)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nameTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(nameLabel10)
                                                .addGap(26, 26, 26)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(registerButton)
                                        .addComponent(goBackButton))
                                .addContainerGap())
        );

        pack();
        setVisible(true);

        if (this.flag.equals(TipoUsuario.PACIENTE)) {
            nameTextField4.setVisible(false);
            nameTextField5.setVisible(false);
            jComboBox2.setVisible(false);
        }
    }

    private void registerButtonActionPerformed(ActionEvent evt) {
        try {
            ControladorGeral.getInstance().realizaCadastro(this.toForm());
        } catch (FormException formException) {
            System.out.println(formException.getMessage());
        }
    }

    private FormularioCadastro toForm() {
        if (this.flag.equals(TipoUsuario.MEDICO)) {
            return new FormularioCadastroMedico(
                    this.cpf, //this.nameTextField1.getText(),
                    this.nome,
                    this.sexo,
                    this.senha,
                    this.idade,
                    this.endereco,
                    this.crm,
                    this.competencia,
                    this.unidadeDeAtendimento
            );
        } else {
            return new FormularioCadastroPaciente(
                    this.cpf,
                    this.nome,
                    this.sexo,
                    this.senha,
                    this.idade,
                    this.endereco
            );
        }
    }

    private void goBackButtonActionPerformed(ActionEvent evt) {
        ControladorGeral.getInstance().abreTelaInicial();
    }
}