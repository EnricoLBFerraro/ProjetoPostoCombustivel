
package DAO;

public class Frentista {
    private int ID;
    private String nome;
    
    public Frentista(){
        
    }
    public Frentista(int ID, String nome){
        this.ID = ID;
        this.nome = nome;
    }
    
    public int getId(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
