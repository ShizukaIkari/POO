package persistenciaFILE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import lanchonete.Hamburguer;
import lanchonete.Suco;
import lanchonete.Refrigerante;
import lanchonete.Produto;

/**
 *
 * @author Serenna
 */
public class PersistenciaProduto {
    
    public static ArrayList readCSVFile(){
        String csvFile = ".\\cardapio.csv";
        String[] arrayLinhaCSV = null;
        BufferedReader br = null;
        String linha = "";
        ArrayList<Produto> listaProdutos = new ArrayList();
        try{
            br = new BufferedReader(new FileReader(csvFile));
            while ((linha = br.readLine()) != null){
                arrayLinhaCSV = linha.split(";");
                if(arrayLinhaCSV[2].equalsIgnoreCase("hamburguer")){
                    Hamburguer hamburguer = new Hamburguer();
                    hamburguer.setNome(arrayLinhaCSV[1]);
                    hamburguer.setCodigo(Integer.parseInt(arrayLinhaCSV[0]));
                    hamburguer.setTipo(arrayLinhaCSV[2]);
                    hamburguer.setValor(Double.parseDouble(arrayLinhaCSV[3]));
                    hamburguer.setDescricao(arrayLinhaCSV[5]);
                    listaProdutos.add(hamburguer);
                }
                else if (arrayLinhaCSV[2].equalsIgnoreCase("suco")){
                    Suco suco = new Suco();
                    suco.setCodigo(Integer.parseInt(arrayLinhaCSV[0]));
                    suco.setNome(arrayLinhaCSV[1]);
                    suco.setSabor(arrayLinhaCSV[3]);
                    suco.setValor(Double.parseDouble(arrayLinhaCSV[4]));
                    suco.setDescricao(arrayLinhaCSV[5]);
                    listaProdutos.add(suco);
                }
                else if (arrayLinhaCSV[2].equalsIgnoreCase("refrigerante")){
                    Refrigerante refrigerante = new Refrigerante();
                    refrigerante.setCodigo(Integer.parseInt(arrayLinhaCSV[0]));
                    refrigerante.setNome(arrayLinhaCSV[1]);
                    refrigerante.setMarca(arrayLinhaCSV[3]);
                    refrigerante.setValor(Double.parseDouble(arrayLinhaCSV[4]));
                    refrigerante.setDescricao(arrayLinhaCSV[5]);
                    listaProdutos.add(refrigerante);
                }  
            }             
        }  catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }   catch (IOException ex) {
            ex.printStackTrace();
        }   finally {
            if (br != null){
               try{
                   br.close();
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
            }
        }
        return listaProdutos;
    }
    public static void saveProduto(Produto produto){
        try{
            FileWriter writer = new FileWriter(".\\cardapio.csv",true);
            writer.append(produto.getCodigo()+";");
            writer.append(produto.getNome()+";");
            if (produto instanceof Hamburguer){
                writer.append("hamburguer;");
                writer.append(((Hamburguer) produto).getTipo()+";");
            } else if (produto instanceof Suco){
                writer.append("suco;");
                writer.append(((Suco) produto).getSabor()+";");
            } else if (produto instanceof Refrigerante){
                writer.append("refrigerante;");
                writer.append(((Refrigerante) produto).getMarca()+";");
            }
            writer.append(String.valueOf(produto.getValor()));
            writer.append(';');
            writer.append(produto.getDescricao());
            writer.append('\n');
            writer.flush();
            writer.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
               
