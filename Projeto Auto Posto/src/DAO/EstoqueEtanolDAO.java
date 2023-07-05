package DAO;
import java.util.ArrayList;
import java.sql.*;

public class EstoqueEtanolDAO {
    private Connection connection;
    public EstoqueEtanolDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void setValor(float Valor){
        String sql = "UPDATE EstoqueEtanol SET Valor = (?) WHERE ID = 1";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setFloat(1, Valor);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public float getValor(){
        String sql = "SELECT Valor FROM EstoqueEtanol WHERE ID = 1";
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
    public ArrayList<EstoqueEtanol> getLista(){
        String sql = "SELECT * FROM EstoqueEtanol";
        ArrayList<EstoqueEtanol> vendas = new ArrayList<>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                EstoqueEtanol etanol = new EstoqueEtanol();
                etanol.setQuantidade(rs.getFloat("Quantidade"));
                vendas.add(etanol);
                
            }
            rs.close();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return vendas;
    }
    
    public void AtualizaValor(float preco){
        String sqlUpdate = "UPDATE ESTOQUEGASOLINA SET Valor = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sqlUpdate);
            stmt.setFloat(1, preco);
            stmt.executeUpdate();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void Abastecimento(float quantidade){
        String sqlSelect = "SELECT Quantidade FROM EstoqueEtanol";
        String sqlUpdate = "UPDATE EstoqueEtanol SET Quantidade = ?";
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
        String sqlSelect = "SELECT Quantidade FROM EstoqueEtanol";
        String sqlUpdate = "UPDATE EstoqueEtanol SET Quantidade = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sqlSelect);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                float quantidadeAntiga = rs.getFloat("Quantidade");
                float novaQuantidade = quantidadeAntiga - quantidade;
                if(novaQuantidade < 0){
                    System.out.print("Não há estoque suficiente");
                    throw new RuntimeException("Nao há estoque");
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
