/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenciaFILE;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lanchonete.ItemPedido;
import lanchonete.Produto;

/**
 *
 * @author Serenna
 */
public class PersistenciaItemPedido {
     public static void saveItemPedido(ItemPedido item) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(".\\itempedido.csv", true);
            
            writer.append(item.getProduto().getCodigo() +";");
            writer.append(item.getPreco() + ";");
            writer.append(item.getQuantidade() + ";");
            writer.append(item.getAnotacao() + "\n");
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public static ArrayList<ItemPedido> readCSVFile() throws FileNotFoundException {
        String csvFile = ".\\itempedido.csv";
        String[] arrayLinhaCSV = null;
        BufferedReader br = null;
        String line = "";
        ArrayList<ItemPedido> listaItemPedidos = new ArrayList();

        List<Produto> produtos = PersistenciaProduto.readCSVFile();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                arrayLinhaCSV = line.split(";");
                ItemPedido item = new ItemPedido();

                Produto produto = null;
                int cod = Integer.parseInt(arrayLinhaCSV[0]);
                for (Produto prod : produtos) {
                    if (prod.getCodigo() == cod) {
                        produto = prod;
                        break;
                    }
                }

                item.setPreco(Double.parseDouble(arrayLinhaCSV[1]));
                item.setProduto(produto);
                item.setQuantidade(Integer.parseInt(arrayLinhaCSV[2]));
                item.setAnotacao(arrayLinhaCSV[3]);
                listaItemPedidos.add(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return listaItemPedidos;
    }
}
