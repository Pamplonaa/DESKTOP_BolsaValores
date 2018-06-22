
package bolsavalores.persistencia;

import bolsavalores.model.Empresa;
import bolsavalores.model.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class EmpresaDAO {

    
    private HashMap<String, Empresa> cacheEmpresas;
    private String filename = "empresas.car";

    public EmpresaDAO() {
        this.cacheEmpresas = new HashMap<>();
        load();
    }
    
    public void put(Empresa empresa) {
        //testa null
        this.cacheEmpresas.put(empresa.getNome(), empresa);
        persist();
    }

    public void putVarios(ArrayList<Empresa> emps){
        for(Empresa e : emps){
            this.put(e);
        }
    }

    public Empresa get(String nome) {
        return this.cacheEmpresas.get(nome);
    }

    private void load() {
        File file = new File(filename);
        if(file.isFile()){
         //   System.err.println("Aqui");
            try {

                    FileInputStream fileIn = new FileInputStream(filename);
                    ObjectInputStream objIn = new ObjectInputStream(fileIn);

                    this.cacheEmpresas = (HashMap<String, Empresa>) objIn.readObject();

                    objIn.close();
                    fileIn.close();

            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
            }
        }
    }

    private void persist() {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this.cacheEmpresas);
            
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

    public void remove(Integer matricula) {
        //testa null
        cacheEmpresas.remove(matricula);
    }
    
//    public Collection<Empresa> getList() {
//        return cacheEmpresas.values();
//    }
    
    public Collection<Empresa> getList() {
        return cacheEmpresas.values();
    }
    
    public boolean exists(String nome){
        return this.cacheEmpresas.containsKey(nome);
    }
    
    
}