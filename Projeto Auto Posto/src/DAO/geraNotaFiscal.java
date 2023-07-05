
package DAO;

import java.io.FileWriter;
import java.io.IOException;

public class geraNotaFiscal {
    public void geraNotaFiscalVendaCliente(String ID, String data,String IDCombustivel, String Litros, String valor){
        String diretorio = "C:\\Users\\enric\\Desktop\\Projeto - Copia\\Projeto Auto\\src\\NotasFiscais";
        String nomeArquivo = "Nota_Fiscal" + ID +".txt";
        
        int IDCombustivelInt = Integer.parseInt(IDCombustivel);
        String Combustivel;
        if(IDCombustivelInt == 1){
            Combustivel = "Etanol";
        } else {
            Combustivel = "Gasolina";
        }
        String conteudo = "Auto Posto Brigadeiro\nRua Angelina Pena Botto, 34 CEP: 02066012\nFone: (14)9964-45490\n--------------------\n"+data+"\n--------------------\nCUPOM FISCAL\nItem   Quantia Descrição\n"+Combustivel+"     "+Litros+ "    Combustivel\n Total = "+valor+"\n--------------------\n";
        try{
            FileWriter arquivo = new FileWriter(diretorio+"/"+nomeArquivo);
            arquivo.write(conteudo);
            arquivo.close();
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    public void geraNotaFiscalVenda(String ID, String data,String IDCombustivel, String Litros){
        String diretorio = "C:\\Users\\enric\\Desktop\\Projeto - Copia\\Projeto Auto\\src\\NotasFiscais";
        String nomeArquivo = "Nota_Fiscal_Venda_Cliente" + ID +".txt";
        String valor;
        int IDCombustivelInt = Integer.parseInt(IDCombustivel);
        String Combustivel;
        if(IDCombustivelInt == 1){
            EstoqueEtanolDAO etanol = new EstoqueEtanolDAO();
            valor = Float.toString(etanol.getValor());
            
            Combustivel = "Etanol";
        } else {
            EstoqueGasolinaDAO gas = new EstoqueGasolinaDAO();
            valor = Float.toString(gas.getValor());
            Combustivel = "Gasolina";
        }
        String conteudo = "Auto Posto Brigadeiro\nRua Angelina Pena Botto, 34 CEP: 02066012\nFone: (14)9964-45490\n--------------------\n"+data+"\n--------------------\nCUPOM FISCAL\nItem   Quantia Descrição\n"+Combustivel+"     "+Litros+ "    Combustivel\n Total = "+valor+"\n--------------------\n";
        try{
            FileWriter arquivo = new FileWriter(diretorio+"\\"+nomeArquivo);
            arquivo.write(conteudo);
            arquivo.close();
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
