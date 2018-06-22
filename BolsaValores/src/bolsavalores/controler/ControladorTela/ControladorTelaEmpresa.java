
package bolsavalores.controler.ControladorTela;

import bolsavalores.controler.ControladorEmpresa;
import bolsavalores.model.Empresa;
import bolsavalores.view.TelaAddEmpresa;
import bolsavalores.view.TelaRemoveEmpresa;
import bolsavalores.view.TelaEmpresa;
import java.util.ArrayList;


public class ControladorTelaEmpresa {
    private TelaEmpresa telaEmp;
    private TelaAddEmpresa telaAddEmp;
    private TelaRemoveEmpresa telaRemoveEmp;
    private ControladorEmpresa ctrlEmp;
    private boolean alterou;
    
    public ControladorTelaEmpresa(TelaEmpresa telaEmp){
        this.telaEmp = telaEmp;
        this.ctrlEmp = this.telaEmp.getCtrl();
        this.telaAddEmp = new TelaAddEmpresa(this);
        this.telaRemoveEmp = new TelaRemoveEmpresa(this);
        this.alterou = false;
    }
    
    public ControladorEmpresa getCtrl(){
        return this.ctrlEmp;
    }
    
    public TelaEmpresa getTelaEmpresa(){
        return this.telaEmp;
    }
    
    public boolean getAlterou(){
        return this.alterou;
    }
    
    public void setAlterou(boolean alterou){
        this.alterou = alterou;
    }
    
    public void abrirTelaAdd(){
        this.telaAddEmp.setVisible(true);
    }
    
    public void abrirTelaRemove(){
        this.telaRemoveEmp.setVisible(true);
    }
    
    public void setEmpCtrlTela(ArrayList<Empresa> empresas){
        this.telaEmp.getCtrl().setEmpresas(empresas);
    }
    
    public void setEmpsThisCtrlEmp(ArrayList<Empresa> empresas){
        this.ctrlEmp.setEmpresas(empresas);
    }
    
    public void preencheTabela(ArrayList<Empresa> empresas){
        this.telaEmp.preecheTabelaAcoes(empresas);
    }
    
    public void addEmp(String nome, int quant, double preco){
        this.ctrlEmp.add(new Empresa(nome, quant, preco));
        this.setEmpCtrlTela(this.ctrlEmp.getEmpresas());
        this.preencheTabela(this.ctrlEmp.getEmpresas());
    }
    
    public void removeEmp(String nome){
        this.ctrlEmp.remove(nome);
        this.setEmpCtrlTela(this.ctrlEmp.getEmpresas());
        this.preencheTabela(this.ctrlEmp.getEmpresas());
    }
    
    public ArrayList<Empresa> getNovasEmps(){
        ArrayList<Empresa> newEmps = new ArrayList<>();
        Object[][] table = this.telaEmp.getTableValues();
        int numLinhas = table.length;
        
        for(int i = 0; i < numLinhas; i++){
            String nome = table[i][0].toString();
            int quant= Integer.parseInt(table[i][3].toString());
            double preco = Double.parseDouble(table[i][1].toString());
            newEmps.add(new Empresa(nome, quant, preco));
        }
        
        return newEmps;
    }
    
    public void atualizaNovasEmps(){
        ArrayList<Empresa> newEmps = getNovasEmps();
        this.setEmpCtrlTela(newEmps);
        this.setEmpsThisCtrlEmp(newEmps);
    }
}
