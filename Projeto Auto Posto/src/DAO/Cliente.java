
package DAO;

import java.util.ArrayList;


public class Cliente {
    private int ID;
    private String nome;
    private int telefone;
    
    public Cliente(){
        
    }
    public Cliente(int ID, String nome, int telefone){
        this.ID = ID;
        this.nome = nome;
        this.telefone = telefone;
    }
    public int getID(){
        return ID;
    }
    public String getNome(){
        return nome;
    }
    public int getTelefone(){
        return telefone;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
}
