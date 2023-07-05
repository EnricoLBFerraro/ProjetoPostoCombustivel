/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.Random;
import DAO.*;

/**
 *
 * @author enric
 */
public class GeraVendas {
    private Connection connection;
    public GeraVendas(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public static void main(String args[]){ //Codigo gerado com finalidade de gerar dados para relatorio
        EstoqueEtanolDAO est = new EstoqueEtanolDAO();
        float valor = est.getValor();
        System.out.println(valor);
    }
    /**
    public void Gerador(String data, int cont){
        int minFren = 1;
        int maxFren = 5;
        int minComb = 1;
        int maxComb = 2;
        int minQuant = 10;
        int maxQuant = 60;
        int minCli = 1;
        int maxCli = 2;
        int max = cont+40;
        
        Random random = new Random();

        while(cont<max){
            Venda venda;
            VendaDAO vendaDao = new VendaDAO();
            int numFren = random.nextInt(maxFren -minFren +1 )+minFren;
            int numComb = random.nextInt(maxComb - minComb +1)+ minComb;
            float numQuant = random.nextInt(maxQuant-minQuant+1)+ minQuant;
            int numCli = random.nextInt(maxCli-minCli+1)+ minCli;
            float valor = numQuant*5;
            venda = new Venda(cont,numCli,numFren,numComb,numQuant,data,valor);
            vendaDao.venda(venda);
            cont++;
        }
    }
    public static void main(String args[]){
        GeraVendas ge = new GeraVendas();

        ge.Gerador("2023-07-03",81);
        ge.Gerador("2023-07-10",121);
        ge.Gerador("2023-07-14",161);
        ge.Gerador("2023-07-17",201);
        ge.Gerador("2023-07-20",241);
        ge.Gerador("2023-07-26",281);
        ge.Gerador("2023-07-30",321);
        ge.Gerador("2023-08-03",361);
        ge.Gerador("2023-08-10",401);
        ge.Gerador("2023-08-14",441);
        ge.Gerador("2023-08-17",481);
        ge.Gerador("2023-08-20",521);
        ge.Gerador("2023-08-26",561);
        ge.Gerador("2023-08-30",601);
        ge.Gerador("2023-09-03",641);
        ge.Gerador("2023-09-10",681);
        ge.Gerador("2023-09-14",721);
        ge.Gerador("2023-09-17",761);
        ge.Gerador("2023-09-20",801);
        ge.Gerador("2023-09-26",841);
        ge.Gerador("2023-09-30",881);
        ge.Gerador("2023-10-03",921);
        ge.Gerador("2023-10-10",961);
        ge.Gerador("2023-10-14",1001);
        ge.Gerador("2023-10-17",1041);
        ge.Gerador("2023-10-20",1081);
        ge.Gerador("2023-10-26",1121);
        ge.Gerador("2023-10-30",1161);
    }
    **/
    
}
