
package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;



public class VendaDAO {
    private Connection connection;
    public VendaDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public int ultimoID(){
        String sql = "SELECT MAX(IdVenda) AS UltimoId FROM venda";
        int ultimo = 0;
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ultimo = rs.getInt("UltimoId");
            }
            rs.close();
            stmt.close();
        } catch(SQLException ex){
            throw new RuntimeException(ex);
        }
        return ultimo;
    }
    public void vendaCliente(Venda venda){
        String sql = "INSERT INTO venda VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1,venda.getId());
            stmt.setInt(2,venda.getIdCliente());
            stmt.setInt(3, venda.getIdFrentista());
            stmt.setInt(4, venda.getIdCombustivel());
            stmt.setFloat(5, venda.getQuantidade());
            stmt.setString(6,venda.getData());
            stmt.setFloat(7,venda.getValor());
            if(venda.getIdCombustivel() == 1){
                EstoqueEtanolDAO etanol = new EstoqueEtanolDAO();
                etanol.Desabastecimento(venda.getQuantidade());
            } else {
                EstoqueGasolinaDAO gas = new EstoqueGasolinaDAO();
                gas.Desabastecimento(venda.getQuantidade());
            }
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex){
            throw new RuntimeException (ex);
        }
    }
    public void venda(Venda venda){
        String sql = "INSERT INTO venda VALUES (?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1,venda.getId());
            stmt.setInt(2,venda.getIdCliente());
            stmt.setInt(3, venda.getIdFrentista());
            stmt.setInt(4, venda.getIdCombustivel());
            stmt.setFloat(5, venda.getQuantidade());
            stmt.setString(6,venda.getData());
            
            if(venda.getIdCombustivel() == 1){
                EstoqueEtanolDAO etanol = new EstoqueEtanolDAO();
                float valor = etanol.getValor();
                stmt.setFloat(7,venda.getQuantidade() * valor);
                etanol.Desabastecimento(venda.getQuantidade());
            } else {
                EstoqueGasolinaDAO gas = new EstoqueGasolinaDAO();
                float valor = gas.getValor();
                stmt.setFloat(7,venda.getQuantidade() * valor);
                gas.Desabastecimento(venda.getQuantidade());
            }
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex){
            throw new RuntimeException (ex);
        }
    }
}
