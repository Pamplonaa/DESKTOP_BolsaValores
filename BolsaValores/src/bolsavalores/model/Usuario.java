
package bolsavalores.model;

import java.io.Serializable;


public class Usuario implements Serializable{
    
    private long cpf;
    private double saldoDisp;
    private double saldoTot;
    private Carteira carteira;
    private double valorCorretagem;

    public Usuario(long cpf) {
        super();
        this.cpf = cpf;
        this.saldoDisp = 1000;
        this.carteira = new Carteira(cpf);
        this.saldoTot = this.getSaldoTotal();
        this.valorCorretagem = 0;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    public double getSaldoDisp() {
        return this.saldoDisp;
    }

    public void setSaldo(double saldo) {
        this.saldoDisp = saldo;
    }
    
    public double getSaldoTotal(){
        this.carteira.atualizaValorTotal();
        return this.saldoDisp + this.carteira.getValorTotal();
    }
    
    public void atualizaSaldoTotal(){
        this.saldoTot = this.getSaldoTotal();
    }

    public Carteira getCarteira() {
        return this.carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }
    
    public double getValorCorretagem() {
        return this.valorCorretagem;
    }

    public void setValorCorretagem(double corretagem) {
        // a corretagem sempre vai ser alterada em porcentagem
        double porCento = (corretagem / 100);
        this.valorCorretagem = porCento;
    }
    
    public void comprar(Empresa empresa, int quantCompradas){
        double precoTot = calculaPreco(empresa.preco, quantCompradas);
        if(this.saldoDisp >= precoTot && empresa.quantAcoes >= quantCompradas){
            this.saldoDisp -= precoTot;
            empresa.quantAcoes -= quantCompradas;
            carteira.add(empresa, quantCompradas);
            this.atualizaSaldoTotal();
        }
    }
    
    public void vender(Empresa empresa, int quantVendidas) throws Exception{
        double precoTot = calculaPreco(empresa.preco, quantVendidas);
        if(carteira.verificaQuantAcoes(empresa) >= quantVendidas){
            this.saldoDisp += precoTot;
            empresa.quantAcoes += quantVendidas;
            carteira.remove(empresa, quantVendidas);
            this.atualizaSaldoTotal();
        }  
    }
    
    public double calculaPreco(double preco, int quant){
        double corr = this.valorCorretagem + 1;
        
        double precoCorretagem = preco * corr;
        double precoTot = precoCorretagem * quant;
        return precoTot;
    }
}
