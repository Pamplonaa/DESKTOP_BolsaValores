
package bolsavalores.persistencia;

import bolsavalores.model.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;

public class UsuarioDAO {

    
    private HashMap<Long, Usuario> cacheUsuarios;
    private String filename = "usuarios.car";

    public UsuarioDAO() {
        this.cacheUsuarios = new HashMap<>();
        load();
    }
    
    public void put(Usuario usuario) {
        //testa null
        this.cacheUsuarios.put(usuario.getCpf(), usuario);
        persist();
    }



    public Usuario get(Long cpf) {
        return this.cacheUsuarios.get(cpf);
    }

    private void load() {

            try {

                    FileInputStream fileIn = new FileInputStream(filename);
                    ObjectInputStream objIn = new ObjectInputStream(fileIn);

                    this.cacheUsuarios = (HashMap<Long, Usuario>) objIn.readObject();

                    objIn.close();
                    fileIn.close();

            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
            }
//        }
    }

    private void persist() {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this.cacheUsuarios);
            
            objOut.flush();
            fileOut.flush();
            
            objOut.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void remove(Long matricula) {
        //testa null
        cacheUsuarios.remove(matricula);
    }
    
    public Collection<Usuario> getList() {
        return cacheUsuarios.values();
    }
    
    public boolean exists(Long cpf){
        return this.cacheUsuarios.containsKey(cpf);
    }
    
    
}