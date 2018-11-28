
package templateexemplo;


public class TemplateMain {

   
    public static void main(String[] args) {
        String texto = "linha 1\n" 
                + "linha2\n"
                + "fim\n";                                
      ExportFiles export;
      export = new ExportHTML();
      export.export(texto);
      
      export = new ExportWord();
      export.export(texto);
    }
    
}
