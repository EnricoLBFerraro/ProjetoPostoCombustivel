/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author enric
 */
public class ContaClienteDAO {
    private Connection connection;
    public ContaClienteDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(ContaCliente contCliente){
        String sql = "INSERT INTO contaCliente VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1,contCliente.getIDCliente());
            stmt.setInt(2,contCliente.getIDCompra());
            stmt.setFloat(3,contCliente.getQuantidade());
            stmt.setInt(4, contCliente.getIDCombustivel());
            stmt.setString(5, contCliente.getData());
            stmt.setFloat(6, contCliente.getValor());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<ContaCliente> getLista(int id){
        String sql = "SELECT * FROM contaCliente WHERE IDCliente = ?";
        ArrayList<ContaCliente> lista = new ArrayList<ContaCliente>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ContaCliente conta = new ContaCliente();
                conta.setIDCliente(rs.getInt("IDCliente"));
                conta.setIDCompra(rs.getInt("IDCompra"));
                conta.setQuantidade(rs.getFloat("Quantidade"));
                conta.setIDCombustivel(rs.getInt("IDCombustivel"));
                conta.setData(rs.getString("Data"));
                conta.setValor(rs.getFloat("Valor"));
                lista.add(conta);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return lista;
    }
    
    public boolean deletaCompra(int IDCompra){
        String sql = "DELETE FROM contaCliente WHERE IDCompra = ?";
        int CompraDeletada = 0;
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, IDCompra);
            CompraDeletada = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return CompraDeletada == 1;
    }
}
