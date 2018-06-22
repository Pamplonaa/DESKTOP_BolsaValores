
package bolsavalores.model;

import java.io.Serializable;


public class AcoesEmp  implements Serializable{
    private Empresa emp;
    private int quantAcoesUsuario;

    public AcoesEmp(Empresa emp, int quantAcoesUsuario) {
        super();
        this.emp = emp;
        this.quantAcoesUsuario = quantAcoesUsuario;
    }

    public Empresa getEmp() {
        return emp;
    }

    public void setNome(Empresa emp) {
        this.emp = emp;
    }

    public int getQuantAcoesUsuario() {
        return quantAcoesUsuario;
    }

    public void setQuantAcoesUsuario(int quant) {
        this.quantAcoesUsuario = quant;
    }

    
}
