
package DAO;
import java.sql.*;
import java.util.ArrayList;

public class FrentistaDAO {
    private Connection connection;
    public FrentistaDAO (){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Frentista func){
        String sql = "INSERT INTO frentistas VALUES (?,?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1,func.getId());
            stmt.setString(2, func.getNome());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Frentista> getLista(){
        String sql = "SELECT * FROM frentistas";
        ArrayList<Frentista> funcionarios = new ArrayList<Frentista>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Frentista func = new Frentista();
                func.setID(rs.getInt("ID"));
                func.setNome(rs.getString("Nome"));
                funcionarios.add(func);
            }
            rs.close();;
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return funcionarios;
    }
    
    public boolean deleta(int ID){
        String sql = "DELETE FROM frentistas WHERE ID = ?";
        int frentistasRemovidos = 0;
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, ID);
            frentistasRemovidos = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return frentistasRemovidos == 1;
    }
}
