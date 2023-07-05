
package DAO;


public class ContaCliente {
    private int IDCliente;
    private int IDCompra;
    private float Quantidade;
    private int IDCombustivel;
    private String data;
    private float valor;
    
    public ContaCliente(){
        
    }
    public ContaCliente(int IDCliente,int IDCompra, float Quantidade, int IDCombustivel, String data){
        this.IDCliente = IDCliente;
        this.IDCompra = IDCompra;
        this.Quantidade = Quantidade;
        this.IDCombustivel = IDCombustivel;
        this.data = data;
    }
        public ContaCliente(int IDCliente,int IDCompra, float Quantidade, int IDCombustivel, String data, float valor){
        this.IDCliente = IDCliente;
        this.IDCompra = IDCompra;
        this.Quantidade = Quantidade;
        this.IDCombustivel = IDCombustivel;
        this.data = data;
        this.valor = valor;
    }
    
    public int getIDCliente(){
        return IDCliente;
    }
    public int getIDCompra(){
        return IDCompra;
    }
    public float getQuantidade(){
        return Quantidade;
    }
    public int getIDCombustivel(){
        return IDCombustivel;
    }
    public String getData(){
        return data;
    }
    public float getValor(){
        return valor;
    }
    public void setIDCliente(int IDCliente){
        this.IDCliente = IDCliente;
    }
    public void setIDCompra(int IDCompra){
        this.IDCompra = IDCompra;
    }
    public void setQuantidade(float Quantidade){
        this.Quantidade = Quantidade;
    }
    public void setIDCombustivel(int IDCombustivel){
        this.IDCombustivel = IDCombustivel;
    }
    public void setData(String data){
        this.data = data;
    }
    public void setValor(float valor){
        this.valor = valor;
    }
}
