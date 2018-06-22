
package bolsavalores.controler;

import bolsavalores.model.Empresa;
import bolsavalores.model.Usuario;


public class ControladorCompraVenda {
    private Usuario usuario;
    private ControladorEmpresa emp;

    public ControladorCompraVenda(Usuario usuario, ControladorEmpresa emp) {
        this.usuario = usuario;
        this.emp = emp;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ControladorEmpresa getEmp() {
        return emp;
    }

    public void setEmp(ControladorEmpresa emp) {
        this.emp = emp;
    }
    
    public void comprar(String nome, int quant){
        Empresa emp = this.emp.pesquisaEmp(nome);
        usuario.comprar(emp, quant);
    }
    
    public void vender(String nome, int quant){
        
    }
    
}
