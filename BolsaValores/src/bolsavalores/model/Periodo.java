
package bolsavalores.model;

import java.io.Serializable;

public class Periodo  implements Serializable{
    int id;
    private int dia;
    private int totalDias;
    
    
    public Periodo(){
        super();
        this.id = 1;
        this.dia = 0;
        this.totalDias = 15;
    }
   
    public int getId(){
        return this.id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    public int getTotalDias(){
        return this.totalDias;
    }
    
    public void avancar() throws Exception{
        if(this.dia < this.totalDias){
            int newDia = this.dia + 1;
            this.setDia(newDia);
        }else{
            throw new Exception("Este eh o ultimo dia");
        }
    }
    
    public int diasRestantes(){
        return this.totalDias - this.dia;
    }
    
}
