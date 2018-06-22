
package bolsavalores.model;

import java.io.Serializable;
import java.text.DecimalFormat;


public class Empresa  implements Serializable{

    private String nome;
    int quantAcoes;
    double preco;
    private double varianciaPreco;
    
    
    
    public Empresa(String nome, int quantAcoes, double preco){
        super();
        this.nome = nome;
        this.quantAcoes = quantAcoes;
        this.preco = preco;
        this.varianciaPreco = 0;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public int getQuantAcoes(){
        return this.quantAcoes;
    }
    
    public double getVarianciaPreco(){
        return this.varianciaPreco;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public void setVarianciaPreco(double variancia){
        this.varianciaPreco = variancia * 100;
    }
    
    public void precoDoDia(){
        double variancia = this.variancia();
        double temp = this.preco * variancia();
        double newPreco = this.preco + temp;
        
        this.setVarianciaPreco(variancia);
        this.setPreco(newPreco);
    }
    
    public double variancia(){
        double x = Math.random();
        double y = Math.random();
        return x - y;
    }
    
    
    
    
}
