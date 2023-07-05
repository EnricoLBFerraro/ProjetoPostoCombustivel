
package DAO;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {
    private Connection connection;
    public ClienteDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(Cliente cliente){
        String sql = "INSERT INTO clientes VALUES (?,?,?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getID());
            stmt.setString(2, cliente.getNome());
            stmt.setInt(3,cliente.getTelefone());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public boolean deleta(int ID){
        String sql = "DELETE FROM clientes WHERE ID = ?";
        int ClientesRemovidos = 0;
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, ID);
            ClientesRemovidos = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return ClientesRemovidos ==1;
    }
    
    public ArrayList<Cliente> getLista(){
        String sql = "SELECT * FROM clientes";
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setID(rs.getInt("ID"));
                cli.setNome(rs.getString("Nome"));
                cli.setTelefone(rs.getInt("Telefone"));
                clientes.add(cli);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return clientes;
    }
}
