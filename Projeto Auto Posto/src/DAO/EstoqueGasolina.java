
package DAO;

public class EstoqueGasolina {
    private float Quantidade;
    private int ID;
    private float Valor;
    public EstoqueGasolina(){
        
    }
    public EstoqueGasolina(float Quantidade){
        this.ID = 2;
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
    public void setValor(){
        this.Valor = Valor;
    }
}
