
package bolsavalores.controler.ControladorTela;

import bolsavalores.controler.ControladorEmpresa;
import bolsavalores.controler.ControladorPeriodo;
import bolsavalores.model.Empresa;
import bolsavalores.model.Usuario;
import bolsavalores.view.AddUsuario;
import bolsavalores.view.TelaEmpresa;
import bolsavalores.view.TelaPrincipal;
import java.util.ArrayList;


public class ControladorTelaUsuarioEmpresa {
    
    
    private TelaEmpresa telaEmp;
    private AddUsuario telaAddUsuario;
    
    public ControladorTelaUsuarioEmpresa(TelaEmpresa telaEmp, AddUsuario telaAddUsuario){
        this.telaEmp = telaEmp;
        this.telaAddUsuario = telaAddUsuario;
    }
    
    public AddUsuario getTelaAddUsuario(){
        return this.telaAddUsuario;
    }
    
    public ControladorEmpresa getCtrlEmpTela(){
        return this.telaEmp.getCtrl();
    }
    
    public ControladorTelaEmpresa getCtrlTelaEmpTela(){
        return this.telaEmp.getCtrlTela();
    }
    
    public void setEmpsCtrlEmpTela(ArrayList<Empresa> empresas){
        this.telaEmp.getCtrl().setEmpresas(empresas);
    }
    
    public void acaoAdd(Usuario u) {
        //TelaPrincipal tela = new TelaPrincipal();
//        TelaEmpresa telaEmp = new TelaEmpresa();
//        if(this.ctrlUsuEmp.getCtrlTelaEmpTela().getAlterou()){
          TelaPrincipal  tela = new TelaPrincipal(this.getCtrlEmpTela());
//        }
        
        tela.getCtrlUsu().setUsuario(u); // seta o usuario atual na tela principal
        
        ControladorPeriodo ctrlPeriodo = new ControladorPeriodo();
        tela.setJTextField2(Long.toString(u.getCpf()));
        tela.setJTextField4(Integer.toString(ctrlPeriodo.diaAtual()));
        tela.setJTextField5(Integer.toString(ctrlPeriodo.getDiasRestantes()));
        tela.setJTextField6(u.getSaldoDisp());
        tela.setJTextField7(u.getSaldoDisp());
        tela.setJTextField8(u.getCarteira().getVariancia());
//        tela.setJTextField3();
        double corretagem = (u.getValorCorretagem()) * 100;
        tela.setJTextField9(corretagem);
        
//        tela.preecheTabelaAcoes(tela.ctrlEmp.getEmpresas());
        tela.setVisible(true);
    }
}
