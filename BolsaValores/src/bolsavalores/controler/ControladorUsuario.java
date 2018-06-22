
package bolsavalores.controler;

import bolsavalores.persistencia.UsuarioDAO;
import bolsavalores.model.Carteira;
import bolsavalores.model.Empresa;
import bolsavalores.model.Usuario;
import java.util.ArrayList;


public class ControladorUsuario {
    ArrayList<Usuario> usuarios;
    UsuarioDAO usuarioDao;
    Usuario user;
    
    public ControladorUsuario(){
        this.usuarios = new ArrayList<>();
        this.user = null;
        usuarioDao = new UsuarioDAO();
    }
    
    public Usuario getUser(){
        return this.user;
    }
    
    public void setUsuario(Usuario user){
        this.user = user;
    }
    
    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void addNovo(long cpf, double saldoInicial){
       usuarioDao.put(new Usuario(cpf));
       Usuario usu = this.pesquisaUsuario(cpf);
       usu.setSaldo(saldoInicial);
//        if(!this.existe(cpf)){
//             usuarios.add(new Usuario(cpf));
//        }else{
//            System.out.println("CPF ja existe");
//        }
    }
    
    private boolean existe(long cpf){
        return usuarioDao.exists(cpf);
//        for(Usuario u : this.usuarios){
//           if(cpf == u.getCpf()){
//               return true;
//           } 
//        }
//        return false;
    }
    
    public Usuario pesquisaUsuario(long cpf){
       Usuario usu = usuarioDao.get(cpf);
//       Usuario usu = null;
//       for(Usuario u: this.usuarios){
//           if(u.getCpf() == cpf){
//               return u;
//           }
//       }

       return usu;
    }
    public Object[][] preecheTabela(){
        Carteira carteira = this.user.getCarteira();
        int size = carteira.getAcEmp().size();
        Object[][] cart = new Object[size][4];
        
        for(int i = 0; i < size; i++){
            Empresa tempEmpresa = carteira.getAcEmp().get(i).getEmp();
            int quant = carteira.getAcEmp().get(i).getQuantAcoesUsuario();
            cart[i][0] = tempEmpresa.getNome();
            cart[i][1] = quant;
            cart[i][2] = tempEmpresa.getPreco() * quant;
        }
        
        return cart;
    }
    
    public void comprar(Empresa empresa, int quant) throws Exception{
        this.user.vender(empresa, quant);
    }
    
    public void vender(Empresa empresa, int quant) throws Exception{
        this.user.vender(empresa, quant);
    }

    public double getSaldo() {
       return this.user.getSaldoDisp();
    }

    public Carteira getCarteira() {
        return this.user.getCarteira();
    }
    
    public void loadUsuario(Long cpf){
        Usuario u = usuarioDao.get(cpf);
        this.setUsuario(u);
    }

    public void salvar() {
        usuarioDao.put(this.user);
    }
}
