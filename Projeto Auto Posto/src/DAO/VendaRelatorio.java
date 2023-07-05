
package DAO;

public class VendaRelatorio {
    private float Quantidade;
    private int IDCombustivel;
    private String data;
    private float valor;
    
    public VendaRelatorio(){
        
    }
    public VendaRelatorio(float Quantidade, int IDCombustivel, String data){
        this.Quantidade = Quantidade;
        this.IDCombustivel = IDCombustivel;
        this.data = data;
    }
    public VendaRelatorio(float Quantidade, int IDCombustivel, String data, float valor){
        this.Quantidade = Quantidade;
        this.IDCombustivel = IDCombustivel;
        this.data = data;
        this.valor = valor;
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

