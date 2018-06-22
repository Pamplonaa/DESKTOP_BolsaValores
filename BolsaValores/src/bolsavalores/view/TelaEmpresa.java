
package bolsavalores.view;

import bolsavalores.controler.ControladorEmpresa;
import bolsavalores.controler.ControladorTela.ControladorTelaEmpresa;
import bolsavalores.controler.ControladorTela.ControladorTelaUsuarioEmpresa;
import bolsavalores.model.Empresa;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class TelaEmpresa extends javax.swing.JFrame {


    
    ControladorEmpresa ctrlEmp;
    ControladorTelaEmpresa ctrlTelaEmp;
    
    public TelaEmpresa() {
        initComponents();
        this.ctrlEmp = new ControladorEmpresa();
        this.ctrlTelaEmp = new ControladorTelaEmpresa(this);
        this.preecheTabelaAcoes(ctrlEmp.getEmpresas());
    }
    
    public ControladorEmpresa getCtrl(){
        return this.ctrlEmp;
    }
    
    public ControladorTelaEmpresa getCtrlTela(){
        return this.ctrlTelaEmp;
    }
    
    public JTable getJTable2(){
        return this.jTable2;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ACOES");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Acao", "Preco $", "Variacao %", "Quantidade"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton3.setText("Salvar Alteracoes e começar!");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("(Para alterar algum valor, basta clicar e altera-lo na tabela)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(133, 133, 133))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(78, 78, 78)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(102, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.acaoSalvar();
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    
    public void acaoAddEmpresa(){
        this.ctrlTelaEmp.abrirTelaAdd();
        this.preecheTabelaAcoes(this.ctrlEmp.getEmpresas());
    }
    
     public void acaoRemoveEmpresa(){
        this.ctrlTelaEmp.abrirTelaRemove();
        this.preecheTabelaAcoes(this.ctrlEmp.getEmpresas());
    }
    
    public void acaoSalvar(){

        ArrayList<Empresa> emps = this.getNovasEmps();
        this.ctrlTelaEmp.atualizaNovasEmps();
        this.ctrlTelaEmp.setAlterou(true);
        this.ctrlEmp.setEmpresas(emps);
        JOptionPane.showMessageDialog(this, "Os dados foram salvos!");
        AddUsuario tela = new AddUsuario();
        ControladorTelaUsuarioEmpresa ctrlTela = new ControladorTelaUsuarioEmpresa(this, tela);

        ctrlTela.setEmpsCtrlEmpTela(emps);
        tela.setCtrlUsuEmp(ctrlTela);
        ctrlTela.getTelaAddUsuario().setVisible(true);
    }
    
    public void preecheTabelaAcoes(ArrayList<Empresa> empresas){
        int size = empresas.size();
        Object[][] emp = new Object[size][4];
        
        for(int i = 0; i < size; i++){
            emp[i][0] = empresas.get(i).getNome();
            emp[i][1] = this.padronizaDoubleParaTela(empresas.get(i).getPreco());
            emp[i][2] = this.padronizaDoubleParaTela(empresas.get(i).getVarianciaPreco());
            emp[i][3] = empresas.get(i).getQuantAcoes();
        }

           jTable2.setModel(new javax.swing.table.DefaultTableModel(
            
            emp,
            new String [] {
                "Acao", "Preco $", "Variacao %", "Quantidade"
            }
        ));
        
    }
    
    public String padronizaDoubleParaTela(double numeroQuebrado){
        if(numeroQuebrado != 0){
            numeroQuebrado = this.converterDoubleDoisDecimais(numeroQuebrado);
        }
        
        return Double.toString(numeroQuebrado);
    }
    
    public double converterDoubleDoisDecimais(double precoDouble) {
        DecimalFormat fmt = new DecimalFormat("0.00");      
        String string = fmt.format(precoDouble);
        String[] part = string.split("[,]");
        String string2 = part[0]+"."+part[1];
        double preco = Double.parseDouble(string2);
        return preco;
    }
    
    public Object[][] getTableValues(){
        int size = jTable2.getRowCount();
        Object[][] emp = new Object[size][4];
        for(int i = 0; i < size; i++){
            emp[i][0] = jTable2.getValueAt(i, 0);
            emp[i][1] = jTable2.getValueAt(i, 1);
            emp[i][2] = jTable2.getValueAt(i, 2);
            emp[i][3] = jTable2.getValueAt(i, 3);
        }
        return emp;
    }
    
    public ArrayList<Empresa> getNovasEmps(){
        ArrayList<Empresa> newEmps = new ArrayList<>();
        Object[][] table = this.getTableValues();
        int numLinhas = table.length;
        
        for(int i = 0; i < numLinhas; i++){
            String nome = table[i][0].toString();
            int quant= Integer.parseInt(table[i][3].toString());
            double preco = Double.parseDouble(table[i][1].toString());
            newEmps.add(new Empresa(nome, quant, preco));
        }
        
        return newEmps;
    }

}
