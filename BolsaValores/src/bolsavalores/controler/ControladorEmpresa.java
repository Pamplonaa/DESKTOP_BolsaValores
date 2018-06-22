
package bolsavalores.controler;

import bolsavalores.model.Empresa;
import bolsavalores.persistencia.EmpresaDAO;
import java.util.ArrayList;
import java.util.Collection;


public class ControladorEmpresa {
    ArrayList<Empresa> empresas;
    EmpresaDAO empresaDAO;
    
    
    public ControladorEmpresa(){
        empresas = new ArrayList<>();
        this.addEmpresa();
        empresaDAO = new EmpresaDAO();
    }
    
    public void add(Empresa emp){
        empresas.add(emp);
    }
    
     public void remove(String nome){
        for(Empresa e: this.empresas){
            if(e != null && nome.equals(e.getNome())){
                this.empresas.remove(e);
                break;
            }
        }
    }
    
    public void addEmpresa(){
        empresas.add(new Empresa("E1", 10, 12));
        empresas.add(new Empresa("E2", 15, 15.8));
        empresas.add(new Empresa("E3", 18, 13.6));
        empresas.add(new Empresa("E4", 18, 12.6));
        empresas.add(new Empresa("E5", 18, 13.7));
        empresas.add(new Empresa("E6", 18, 31.6));
        empresas.add(new Empresa("E7", 10, 20.8));
    }
    
    public ArrayList<Empresa> getEmpresas(){
        return this.empresas;
    }
    
    public void setEmpresas(ArrayList<Empresa> emps){
        this.empresas = emps;
    }
    
    public Empresa pesquisaEmp(String nome){
        Empresa emp = null;
        for(Empresa e: this.empresas){
            if(e.getNome().equals(nome)){
                return e;
            }
        }
        
        return emp;
    }
    
    public void atualizaPreco(){
        Empresa emp = null;
        for(Empresa e: this.empresas){
            e.precoDoDia();
        }
    }
    
    public ArrayList<Empresa> collectionToArrayList(Collection colecao){
        ArrayList<Empresa> emps = new ArrayList<>();
        
        for(Object c : colecao){
            emps.add((Empresa) c);
        }
        
        return emps;
    }
    
    public void loadEmpresas(){
//        ArrayList<Empresa> emps = new ArrayList<>(empresaDAO.getList());
        ArrayList<Empresa> emps = this.collectionToArrayList(empresaDAO.getList());
        this.setEmpresas(emps);
    }

    public void salvarVarios() {
        empresaDAO.putVarios(this.empresas);
    }
}
