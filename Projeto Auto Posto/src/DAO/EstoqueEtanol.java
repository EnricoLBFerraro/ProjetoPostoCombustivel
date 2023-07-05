
package DAO;


public class EstoqueEtanol{
    private float Quantidade;
    private int ID;
    private float Valor;
    
    public EstoqueEtanol(){
        
    }
    public EstoqueEtanol(float Quantidade, float preco){
        this.ID = 1;
        this.Quantidade = Quantidade;
        this.Valor = Valor;
    }
    public float getQuantidade(){
        return Quantidade;
    }
    public void setQuantidade(float Quantidade){
        this.Quantidade = Quantidade;
    }
    public float getValor(){
        return Valor;
    }
    public void setValor(float Valor){
        this.Valor = Valor;
    }
}
