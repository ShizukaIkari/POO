package game.observer;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;

public class FabricaDeInimigos implements Serializable {
    String filePath;
    HashMap dic = new HashMap();
    
    FabricaDeInimigos() { 
        dic.put(1,new Inimigo(filePath + "\\src\\main\\java\\devil1.png", 500, -100));
        dic.put(2,new Inimigo(filePath + "\\src\\main\\java\\devil2.png", 300, -00));
        dic.put(3,new Inimigo(filePath + "\\src\\main\\java\\devil3.png", 400, -250));
        dic.put(4,new InimigoEsperto(filePath + "\\src\\main\\java\\devil3.png", 200, -250));
        
        try {
            File file = new File(".");
            filePath = file.getCanonicalPath();
        } catch (IOException ex) {
            Logger.getLogger(FabricaDeInimigos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    public Inimigo criarInimigo(int tipoInimigo) {
        Inimigo inimigo = null;
        if (tipoInimigo == 1) {
            inimigo = (Inimigo) deepClone(dic.get(1));
        } else if (tipoInimigo == 2) {
            inimigo = (Inimigo) deepClone(dic.get(2));
        } else if (tipoInimigo == 3) {
            inimigo = (Inimigo) deepClone(dic.get(3));
        }
        else if (tipoInimigo == 4) {
            inimigo = (InimigoEsperto) deepClone(dic.get(4));
        }
        return inimigo;
    }
    
    public static Object deepClone(Object o){
        try{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(o);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

   

}
