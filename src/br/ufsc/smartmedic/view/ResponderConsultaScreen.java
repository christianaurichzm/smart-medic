package br.ufsc.smartmedic.view;


public class ResponderConsultaScreen extends javax.swing.JFrame {

    public ResponderConsultaScreen() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        responderConsultaLabel = new javax.swing.JLabel();
        selectConsultaComboBox = new javax.swing.JComboBox<>();
        selectConsultaLabel = new javax.swing.JLabel();
        FichaDeSintomasTextPane = new javax.swing.JScrollPane();
        sintomasTextPane = new javax.swing.JTextPane();
        sintomasLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FichaDeSintomasTextPane1 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicamentosList = new javax.swing.JList<>();
        medicamentosLabel = new javax.swing.JLabel();
        medicamentosOutroTextField = new javax.swing.JTextField();
        medicamentosOutroLabel = new javax.swing.JLabel();
        medicamentosOutroTooltip = new javax.swing.JLabel();
        frequanciaMedicamentoTextField = new javax.swing.JTextField();
        frequenciaMedicamentoLabel = new javax.swing.JLabel();
        encaminharCheckbox = new javax.swing.JCheckBox();
        unidadesDeSaudeComboBox = new javax.swing.JComboBox<>();
        unidadesDeSaúdeLabel = new javax.swing.JLabel();
        concluirButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        responderConsultaLabel.setText("Responder a um chamado");
        responderConsultaLabel.setAlignmentY(0.0F);

        selectConsultaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectConsultaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectConsultaComboBoxActionPerformed(evt);
            }
        });

        selectConsultaLabel.setText("Selecione a consulta:");

        sintomasTextPane.setEditable(false);
        FichaDeSintomasTextPane.setViewportView(sintomasTextPane);

        sintomasLabel.setText("Sintomas do paciente:");

        jLabel2.setText("Diagnóstico/Observações:");

        FichaDeSintomasTextPane1.setViewportView(jTextPane2);

        medicamentosList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(medicamentosList);

        medicamentosLabel.setText("Medicamentos que serão receitados:");

        medicamentosOutroTextField.setText("jTextField1");
        medicamentosOutroTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicamentosOutroTextFieldActionPerformed(evt);
            }
        });

        medicamentosOutroLabel.setText("Medicamentos a ser receitados (outro):");

        medicamentosOutroTooltip.setText("Para múltiplos medicamentos favor separar por vírgula.");

        frequanciaMedicamentoTextField.setText("jTextField1");

        frequenciaMedicamentoLabel.setText("Frequência que o medicamento deverá ser utilizado:");

        encaminharCheckbox.setText("Encaminhar o paciente");
        encaminharCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encaminharCheckboxActionPerformed(evt);
            }
        });

        unidadesDeSaudeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        unidadesDeSaúdeLabel.setText("Unidades de saúde");

        concluirButton.setText("Concluir");
        concluirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concluirButtonActionPerformed(evt);
            }
        });

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(137, 137, 137)
                                                .addComponent(responderConsultaLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(medicamentosOutroTooltip)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(medicamentosOutroTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                                                .addComponent(medicamentosOutroLabel)
                                                                .addComponent(medicamentosLabel)
                                                                .addComponent(sintomasLabel)
                                                                .addComponent(selectConsultaLabel)
                                                                .addComponent(jLabel2)
                                                                .addComponent(FichaDeSintomasTextPane)
                                                                .addComponent(selectConsultaComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(FichaDeSintomasTextPane1)
                                                                .addComponent(jScrollPane1))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(frequanciaMedicamentoTextField)
                                                                        .addGap(38, 38, 38))
                                                                .addComponent(frequenciaMedicamentoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(encaminharCheckbox)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(unidadesDeSaudeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addGap(0, 37, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(unidadesDeSaúdeLabel)
                                                .addGap(119, 119, 119))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(voltarButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(concluirButton)
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(responderConsultaLabel)
                                .addGap(12, 12, 12)
                                .addComponent(selectConsultaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectConsultaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sintomasLabel)
                                .addGap(4, 4, 4)
                                .addComponent(FichaDeSintomasTextPane, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FichaDeSintomasTextPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(medicamentosLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(medicamentosOutroLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(medicamentosOutroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(medicamentosOutroTooltip)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(frequenciaMedicamentoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(frequanciaMedicamentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unidadesDeSaúdeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(encaminharCheckbox)
                                        .addComponent(unidadesDeSaudeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(concluirButton)
                                        .addComponent(voltarButton))
                                .addContainerGap())
        );

        pack();
    }

    private void selectConsultaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void medicamentosOutroTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void encaminharCheckboxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void concluirButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private javax.swing.JScrollPane FichaDeSintomasTextPane;
    private javax.swing.JScrollPane FichaDeSintomasTextPane1;
    private javax.swing.JButton concluirButton;
    private javax.swing.JCheckBox encaminharCheckbox;
    private javax.swing.JTextField frequanciaMedicamentoTextField;
    private javax.swing.JLabel frequenciaMedicamentoLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JLabel medicamentosLabel;
    private javax.swing.JList<String> medicamentosList;
    private javax.swing.JLabel medicamentosOutroLabel;
    private javax.swing.JTextField medicamentosOutroTextField;
    private javax.swing.JLabel medicamentosOutroTooltip;
    private javax.swing.JLabel responderConsultaLabel;
    private javax.swing.JComboBox<String> selectConsultaComboBox;
    private javax.swing.JLabel selectConsultaLabel;
    private javax.swing.JLabel sintomasLabel;
    private javax.swing.JTextPane sintomasTextPane;
    private javax.swing.JComboBox<String> unidadesDeSaudeComboBox;
    private javax.swing.JLabel unidadesDeSaúdeLabel;
    private javax.swing.JButton voltarButton;

}
