
package bolsavalores.persistencia;

import bolsavalores.model.Periodo;
import bolsavalores.model.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;


public class PeriodoDAO {

    
    private HashMap<Integer, Periodo> cachePeriodo;
    private String filename = "periodo.car";

    public PeriodoDAO() {
        this.cachePeriodo = new HashMap<>();
        load();
    }
    
    public void put(Periodo periodo) {
        this.cachePeriodo.put(periodo.getId(), periodo);
        persist();
    }



    public Periodo get(int id) {
        return this.cachePeriodo.get(id);
    }

    private void load() {
        File file = new File(filename);
        if(file.isFile()){
            try {

                    FileInputStream fileIn = new FileInputStream(filename);
                    ObjectInputStream objIn = new ObjectInputStream(fileIn);

                    this.cachePeriodo = (HashMap<Integer, Periodo>) objIn.readObject();

                    objIn.close();
                    fileIn.close();

            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    private void persist() {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this.cachePeriodo);
            
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
    
}