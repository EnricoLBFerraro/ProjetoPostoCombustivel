
package DAO;
import java.sql.Date;
import java.time.LocalDate;
public class Venda {
    private int ID;
    private int IDCliente;
    private int IDFrentista;
    private float Quantidade;
    private int IDCombustivel;
    private String data;
    private float valor;
    
    public Venda(){
        
    }
    public Venda(int ID, int IDCliente, int IDFrentista, int IDCombustivel, float Quantidade, String data, float valor){
        this.ID = ID;
        this.IDCliente = IDCliente;
        this.IDFrentista = IDFrentista;
        this.IDCombustivel = IDCombustivel;
        this.Quantidade = Quantidade;
        this.data = data;
        this.valor = valor;
    }
        public Venda(int ID, int IDCliente, int IDFrentista, int IDCombustivel, float Quantidade, String data){
        this.ID = ID;
        this.IDCliente = IDCliente;
        this.IDFrentista = IDFrentista;
        this.IDCombustivel = IDCombustivel;
        this.Quantidade = Quantidade;
        this.data = data;
    }


    
    public int getId(){
        return ID;
    }
    public int getIdCliente(){
        return IDCliente;
    }
    public int getIdFrentista(){
        return IDFrentista;
    }
    public int getIdCombustivel(){
        return IDCombustivel;
    }
    public float getQuantidade(){
        return Quantidade;
    }
    public String getData(){
        return data;
    }
    public float getValor(){
        return valor;
    }
    public void setId(int ID){
        this.ID = ID;
    }
    public void setIdCliente(int IDCliente){
        this.IDCliente = IDCliente;
    }
    public void setIdFrentista(int IDFrentista){
        this.IDFrentista = IDFrentista;
    }
    public void setIdCombustivel(int IDCombustivel){
        this.IDCombustivel = IDCombustivel;
    }
    public void setQuantidade(float Quantidade){
        this.Quantidade = Quantidade;
    }
    public void setData(String data){
        this.data = data;
    }
    public void setValor(float valor){
        this.valor = valor;
    }
}
