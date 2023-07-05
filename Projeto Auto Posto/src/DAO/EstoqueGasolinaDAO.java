
package DAO;
import java.util.ArrayList;
import java.sql.*;

public class EstoqueGasolinaDAO {
    private Connection connection;
    public EstoqueGasolinaDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public float getValor(){
        String sql = "SELECT Valor FROM EstoqueGasolina WHERE ID = 2";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getFloat("Valor");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return 0;
    }
    public void setValor(float Valor){
        String sql = "UPDATE EstoqueEtanol SET Valor = (?) WHERE ID = 2";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setFloat(1, Valor);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public ArrayList<EstoqueGasolina> getLista(){
        String sql = "SELECT * FROM EstoqueGasolina";
        ArrayList<EstoqueGasolina> vendas = new ArrayList<>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                EstoqueGasolina gas = new EstoqueGasolina();
                gas.setQuantidade(rs.getFloat("Quantidade"));
                vendas.add(gas);
                
            }
            rs.close();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return vendas;
    }
    
    public void Abastecimento(float quantidade){
        String sqlSelect = "SELECT Quantidade FROM EstoqueGasolina";
        String sqlUpdate = "UPDATE EstoqueGasolina SET Quantidade = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sqlSelect);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                float quantidadeAntiga = rs.getFloat("Quantidade");
                float novaQuantidade = quantidadeAntiga + quantidade;
                PreparedStatement updatestmt = this.connection.prepareStatement(sqlUpdate);
                updatestmt.setFloat(1, novaQuantidade);
                updatestmt.executeUpdate();
                updatestmt.close();
            }
            rs.close();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void Desabastecimento(float quantidade){
        String sqlSelect = "SELECT Quantidade FROM EstoqueGasolina";
        String sqlUpdate = "UPDATE EstoqueGasolina SET Quantidade = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sqlSelect);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                float quantidadeAntiga = rs.getFloat("Quantidade");
                float novaQuantidade = quantidadeAntiga - quantidade;
                if(novaQuantidade < 0){
                    System.out.print("Não há estoque suficiente");
                    return;
                }
                PreparedStatement updatestmt = this.connection.prepareStatement(sqlUpdate);
                updatestmt.setFloat(1, novaQuantidade);
                updatestmt.executeUpdate();
                updatestmt.close();
            }
            rs.close();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
