/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import DAO.ClienteDAO;
import Entity.Cliente;
import Utils.InputVerifier;
import Utils.Util;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
/**
 *
 * @author Diego Justi
 */
public class CadastroCliente extends javax.swing.JDialog {
    
    int operation;
    ClienteDAO cDao = new ClienteDAO();
    InputVerifier iv = new InputVerifier();
    Cliente c;
    
    /**
     * Creates new form CadastroCliente
     */
    public CadastroCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public CadastroCliente(java.awt.Frame parent, boolean modal, int operation, Cliente c) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.operation = operation;
        this.c = c;
        buttonGroup1.add(jRadioButtonFisico);
        buttonGroup1.add(jRadioButtonJuridico);
        jRadioButtonFisico.setSelected(true);
        preencherCampos();
    }
    
    private void preencherCampos(){
        if(operation != Util.OPERATION_NEW){
            jTextFieldBairro.setText(c.getBairro());
            jTextFieldCidade.setText(c.getCidade());
            jTextFieldComplemento.setText(c.getComplemento());
            jTextFieldEmail.setText(c.getEmail());
            jTextFieldEndereco.setText(c.getEndereco());
            jTextFieldNome.setText(c.getNome());
            jTextFieldRazaoSocial.setText(c.getRazaoSocial());
            jFormattedTextFieldCEP.setText((c.getCep()));
            jFormattedTextFieldCpf_Cnpj.setText((c.getCpf_cnpj()));
            jFormattedTextFieldNumero.setText((c.getNumero()));
            jFormattedTextFieldTelefone1.setText((c.getTelefone1()));
            jFormattedTextFieldTelefone2.setText((c.getTelefone2()));
            jPanelTipoCliente.setVisible(false);
        }
        if(operation == Util.OPERATION_DELETE || operation == Util.OPERATION_VIEW){
            
            jTextFieldBairro.setEditable(false);
            jTextFieldCidade.setEditable(false);
            jTextFieldComplemento.setEditable(false);
            jTextFieldEmail.setEditable(false);
            jTextFieldEndereco.setEditable(false);
            jTextFieldNome.setEditable(false);
            jTextFieldRazaoSocial.setEditable(false);
            jFormattedTextFieldCpf_Cnpj.setEditable(false);
            jFormattedTextFieldNumero.setEditable(false);
            jFormattedTextFieldTelefone1.setEditable(false);
            jFormattedTextFieldTelefone2.setEditable(false);
            jFormattedTextFieldCEP.setEditable(false);
            
            if(operation == Util.OPERATION_DELETE)
                jButtonSalvar.setText("Remover");           
            else{
                jButtonSalvar.setVisible(false);
            }
        }
    }
    
    private boolean validarEntradas(){
        if(!iv.isTextValid(jTextFieldNome.getText())){
            JOptionPane.showMessageDialog(null, "Nome inválido");
            return false;
        }
        if(!iv.isCpfCnpjValid(jFormattedTextFieldCpf_Cnpj.getText())){
            JOptionPane.showMessageDialog(null, "CPF/CNPJ inválido");
            return false;
        }
        if(jRadioButtonJuridico.isSelected()){
            if(!iv.isTextValid(jTextFieldRazaoSocial.getText())){
                JOptionPane.showMessageDialog(null, "Razão Social inválida");
                return false;
            }
        }
        if(!iv.isTextValid(jTextFieldEndereco.getText())){
            JOptionPane.showMessageDialog(null, "Enedereço inválido");
            return false;
        }
        if(!iv.isIntegerPositiveValid(jFormattedTextFieldNumero.getText())){
            JOptionPane.showMessageDialog(null, "Número inválido");
            return false;
        }
        if(!iv.isIntegerPositiveValid(jFormattedTextFieldCEP.getText())){
            JOptionPane.showMessageDialog(null, "CEP inválido");
            return false;
        }
        if(!iv.isTextValid(jTextFieldBairro.getText())){
            JOptionPane.showMessageDialog(null, "Bairro inválido");
            return false;
        }
        if(!iv.isTextValid(jTextFieldCidade.getText())){
            JOptionPane.showMessageDialog(null, "Cidade inválida");
            return false;
        }
        if(!iv.isPhoneNumberValid(jFormattedTextFieldTelefone1.getText())){
            JOptionPane.showMessageDialog(null, "Telefone 1 inválido");
            return false;
        }
        if(jFormattedTextFieldTelefone2.getText().length() != 0){
            if(!iv.isPhoneNumberValid((jFormattedTextFieldTelefone2.getText()))){
                JOptionPane.showMessageDialog(null, "Telefone 2 inválido");
                return false;
            }
        }
        
        //falta verificar o e-mail, se tiver
        
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelCpfCnpj = new javax.swing.JLabel();
        jLabelRazaoSocial = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jFormattedTextFieldCpf_Cnpj = new javax.swing.JFormattedTextField();
        jTextFieldRazaoSocial = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jFormattedTextFieldNumero = new javax.swing.JFormattedTextField();
        jTextFieldComplemento = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldCidade = new javax.swing.JTextField();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jFormattedTextFieldTelefone1 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTelefone2 = new javax.swing.JFormattedTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jFormattedTextFieldCEP = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jPanelTipoCliente = new javax.swing.JPanel();
        jLabelTipo = new javax.swing.JLabel();
        jRadioButtonFisico = new javax.swing.JRadioButton();
        jRadioButtonJuridico = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro - Cliente");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabelNome.setText("Nome/Empresa:");

        jLabelCpfCnpj.setText("CPF/CNPJ:");

        jLabelRazaoSocial.setText("Razão Social:");

        jLabel5.setText("Endereço:");

        jLabel6.setText("Número:");

        jLabel7.setText("Complemento:");

        jLabel8.setText("Bairro:");

        jLabel9.setText("Cidade:");

        jLabel10.setText("Estado:");

        jLabel11.setText("Telefone 1:");

        jLabel12.setText("Telefone 2:");

        jLabel13.setText("E-mail:");

        jFormattedTextFieldCpf_Cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#+0"))));

        jFormattedTextFieldNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#+0"))));

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jComboBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel14.setText("CEP:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabelRazaoSocial)
                    .addComponent(jLabelCpfCnpj)
                    .addComponent(jLabelNome)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNome)
                    .addComponent(jTextFieldRazaoSocial)
                    .addComponent(jTextFieldEndereco)
                    .addComponent(jTextFieldComplemento)
                    .addComponent(jTextFieldBairro)
                    .addComponent(jTextFieldCidade)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(jFormattedTextFieldTelefone2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jFormattedTextFieldTelefone1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jFormattedTextFieldCpf_Cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 165, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldCpf_Cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCpfCnpj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRazaoSocial)
                    .addComponent(jTextFieldRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jFormattedTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jFormattedTextFieldTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jFormattedTextFieldTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelTipo.setText("Tipo:");

        jRadioButtonFisico.setText("Físico");
        jRadioButtonFisico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonFisicoItemStateChanged(evt);
            }
        });

        jRadioButtonJuridico.setText("Jurídico");
        jRadioButtonJuridico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonJuridicoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelTipoClienteLayout = new javax.swing.GroupLayout(jPanelTipoCliente);
        jPanelTipoCliente.setLayout(jPanelTipoClienteLayout);
        jPanelTipoClienteLayout.setHorizontalGroup(
            jPanelTipoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTipoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonFisico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonJuridico)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTipoClienteLayout.setVerticalGroup(
            jPanelTipoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTipoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTipoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipo)
                    .addComponent(jRadioButtonFisico)
                    .addComponent(jRadioButtonJuridico))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTipoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEstadoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        
        if(validarEntradas()){
            Cliente c1 = new Cliente();
            c1.setBairro(jTextFieldBairro.getText());
            c1.setCep(jFormattedTextFieldCEP.getText());
            c1.setCidade(jTextFieldCidade.getText());
            c1.setComplemento(jTextFieldComplemento.getText());
            c1.setCpf_cnpj(jFormattedTextFieldCpf_Cnpj.getText());
            c1.setEmail(jTextFieldEmail.getText());
            c1.setEndereco(jTextFieldEndereco.getText());
            c1.setEstado(jComboBoxEstado.getSelectedItem().toString());
            c1.setNome(jTextFieldNome.getText());
            c1.setNumero(jFormattedTextFieldNumero.getText());
            c1.setRazaoSocial(jTextFieldRazaoSocial.getText());
            c1.setRg_ie("");
            c1.setTelefone1(jFormattedTextFieldTelefone1.getText());
            c1.setTelefone2(jFormattedTextFieldTelefone2.getText());
            
            doOperation(c1);
        }
        
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void doOperation(Cliente c){
        int ret = 0;
        switch(operation){
            case Util.OPERATION_NEW:
                ret = cDao.insertCliente(c);
                Util.showStatusMessage(ret, null, "CPF/CNPJ já cadastrado!", null);
                break;
            case Util.OPERATION_EDIT:
                ret = cDao.updateCliente(c, this.c.getCpf_cnpj());
                Util.showStatusMessage(ret, null, null, null);
                break;
            case Util.OPERATION_DELETE:
                ret = cDao.deleteCliente(this.c.getCpf_cnpj());
                Util.showStatusMessage(ret, "Removido com sucesso!", null, null);
                break;
        }
        if(ret == 1)
            dispose();
    }
    
    
    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jRadioButtonFisicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonFisicoItemStateChanged
        // TODO add your handling code here:
        if(jRadioButtonFisico.isSelected()){
            jLabelNome.setText("Nome:");
            jLabelCpfCnpj.setText("CPF:");
            jTextFieldRazaoSocial.setVisible(false);
            jLabelRazaoSocial.setVisible(false);
            try {
                jFormattedTextFieldCpf_Cnpj.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
            } catch (ParseException ex) {
                Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jRadioButtonFisicoItemStateChanged

    private void jRadioButtonJuridicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonJuridicoItemStateChanged
        // TODO add your handling code here:
        if(jRadioButtonJuridico.isSelected()){
            jLabelNome.setText("Nome Fantasia:");
            jLabelCpfCnpj.setText("CNPJ:");
            jLabelRazaoSocial.setVisible(true);
            jTextFieldRazaoSocial.setVisible(true);       
            try {
                jFormattedTextFieldCpf_Cnpj.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##.###.###/####-##")));
            } catch (ParseException ex) {
                Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jRadioButtonJuridicoItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroCliente dialog = new CadastroCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JFormattedTextField jFormattedTextFieldCEP;
    private javax.swing.JFormattedTextField jFormattedTextFieldCpf_Cnpj;
    private javax.swing.JFormattedTextField jFormattedTextFieldNumero;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone1;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCpfCnpj;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelRazaoSocial;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelTipoCliente;
    private javax.swing.JRadioButton jRadioButtonFisico;
    private javax.swing.JRadioButton jRadioButtonJuridico;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldRazaoSocial;
    // End of variables declaration//GEN-END:variables
}
