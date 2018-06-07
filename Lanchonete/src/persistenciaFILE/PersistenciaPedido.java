/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenciaFILE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import lanchonete.ItemPedido;
import lanchonete.Pedido;

/**
 *
 * @author Serenna
 */
public class PersistenciaPedido {
    public static ArrayList<Pedido> readCSVFile() throws IOException {
        String csvFile = ".\\pedido.csv";
        String[] arrayLinhaCSV = null;
        ArrayList<ItemPedido> itensPedidos = PersistenciaItemPedido.readCSVFile();
        ArrayList<Pedido> listaPedidos = new ArrayList();
        BufferedReader br = null;
        String linha = "";
        Pedido pedido = null;
        
        try{
            br = new BufferedReader(new FileReader(csvFile));
            while ((linha = br.readLine())!= null){
                arrayLinhaCSV = linha.split(";");
                int idPedido = Integer.parseInt(arrayLinhaCSV[0]);
                pedido = new Pedido(idPedido);
                
                for(ItemPedido item : itensPedidos){
                    if(item.getCodPedido() == idPedido){
                        pedido.adicionarItem(item);
                    }
                }
                pedido.setDataPedido(arrayLinhaCSV[2]);
                if(arrayLinhaCSV[3].equalsIgnoreCase("aberto")){
                    pedido.setAberto(true);
                }
                else if(arrayLinhaCSV[3].equalsIgnoreCase("fechado")){
                    pedido.setAberto(false);
                } else System.out.println("?");
                listaPedidos.add(pedido);
            }
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
        return listaPedidos;
    }
    
    public static void savePedido(Pedido pedido)throws IOException{
        FileWriter writer = null;
        try {
            
            writer = new FileWriter(".\\pedido.csv", true);
            writer.append(pedido.getIdPedido() + ";");
            writer.append(pedido.getDataPedido()+";");
            if(pedido.isAberto()) writer.append("aberto\n");
            else writer.append("fechado\n");
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
       
    }
}
