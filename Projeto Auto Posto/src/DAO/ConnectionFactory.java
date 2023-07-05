
package DAO;
import java.sql.*;

public class ConnectionFactory {
    public Connection getConnection(){
        try{
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/Projeto ","app","app");
            return conexao;
        } catch(SQLException ex){
            System.out.println("Falha no servidor " + ex);
        }
        return null;
    }
    
}
