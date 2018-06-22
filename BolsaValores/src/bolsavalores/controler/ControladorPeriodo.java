
package bolsavalores.controler;

import bolsavalores.model.Periodo;
import bolsavalores.persistencia.PeriodoDAO;


public class ControladorPeriodo {
    Periodo periodo;
    PeriodoDAO periodoDAO;
    
    public ControladorPeriodo(){
        this.periodo = new Periodo();
        this.periodoDAO = new PeriodoDAO();
    }
    
    public Periodo getPeriodo(){
        return this.periodo;
    }
    
    public void setPeriodo(Periodo periodo){
        this.periodo = periodo;
    }
    
    public int getDiasRestantes(){
        return this.periodo.diasRestantes();
    }
    
    public void avancarDia() throws Exception{
        this.periodo.avancar();
    }
    
    public int diaAtual(){
        return this.periodo.getDia();
    }
    
    public void loadPeriodo(){
        Periodo newPeriodo = periodoDAO.get(1);
//        Periodo newPeriodo = periodoDAO.get(this.periodo.getId());
        this.setPeriodo(newPeriodo);
    }

    public void salvarPeriodo() {
        periodoDAO.put(this.periodo);
    }
}
