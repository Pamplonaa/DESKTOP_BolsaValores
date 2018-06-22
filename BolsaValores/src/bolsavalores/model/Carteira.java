
package bolsavalores.model;

import java.util.ArrayList;
import java.io.Serializable;


public class Carteira implements Serializable{
    
    private ArrayList<AcoesEmp> acEmp;
    private double valorTotal;
    private double variancia;
    private long id;

    public Carteira(long id) {
        super();
        this.id = id;
        this.acEmp = new ArrayList<>();
        this.valorTotal = 0;
        this.variancia = 0;
    }

    public ArrayList<AcoesEmp> getAcEmp() {
        return this.acEmp;
    }

    public void setAcEmp(ArrayList<AcoesEmp> acEmp) {
        this.acEmp = acEmp;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
     public double getVariancia() {
        return this.variancia;
    }

    public void setVariancia(double variancia) {
        this.variancia = variancia;
    }


    public long getId() {
        return id;
    }    
    
    
    public void add(Empresa empresa, int quantCompradas) {
        AcoesEmp ac = this.pesquisaAcao(empresa.getNome());
        if(ac == null){
            acEmp.add(new AcoesEmp(empresa, quantCompradas));
        }else{
            ac.setQuantAcoesUsuario(ac.getQuantAcoesUsuario()+ quantCompradas);
        }
        
    }

    public int verificaQuantAcoes(Empresa empresa) {
        AcoesEmp ac = this.pesquisaAcao(empresa.getNome());
        return ac.getQuantAcoesUsuario();
    }

    public void remove(Empresa empresa, int quantVendidas) throws Exception {
        AcoesEmp ac = this.pesquisaAcao(empresa.getNome());
        if(ac == null){
            throw new Exception("Acao  nao encontrada");
        }else{
            
            ac.setQuantAcoesUsuario(ac.getQuantAcoesUsuario() - quantVendidas);
        }
        
    }
     public AcoesEmp pesquisaAcao(String nome){
        AcoesEmp emp = null;
        for(AcoesEmp ac: this.acEmp){
            if(ac.getEmp().getNome().equals(nome)){
                return ac;
            }
        }
        return emp;
    }
     
    public double calculaValorTotal(){
        double valorTotal = 0;
        for(AcoesEmp ac: this.acEmp){
            if(ac != null){
               valorTotal += ac.getEmp().getPreco() * ac.getQuantAcoesUsuario(); 
            }
        }
        
        return valorTotal;
    }
        
    public void atualizaValorTotal(){
        this.setValorTotal(this.calculaValorTotal());
    }
    
    public void atualizaEmpPrecoCarteira(ArrayList<Empresa> empresas){
        double valorTotalOld = this.valorTotal;
        for(Empresa e: empresas){
            for(AcoesEmp ac : this.getAcEmp()){
                if(e.getNome().equals(ac.getEmp().getNome())){
                    ac.getEmp().setPreco(e.getPreco());
                }
            }
        }
        
        double valorTotalNew = this.calculaValorTotal();
        this.setVariancia(valorTotalOld/valorTotalNew);
    }
}