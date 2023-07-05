
package DAO;
import java.sql.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RelatorioDAO {
    private Connection connection;
    public RelatorioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public float TotalDoFrentista(int ID){
        String sql = "SELECT * FROM venda WHERE IdFrentista = ?";
        
        float totalDeVendas = 0;
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, ID);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                totalDeVendas += rs.getFloat("Quantidade");
            }
        } catch(SQLException ex){
            throw new RuntimeException(ex);
        }
        return totalDeVendas;
    }
    
    public ArrayList<VendaRelatorio> relatorioVenda(int ID){
        String sql = "SELECT * FROM venda WHERE IdFrentista = ?";
        ArrayList<VendaRelatorio> vendasDeFunc = new ArrayList<VendaRelatorio>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, ID);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                VendaRelatorio vendRel = new VendaRelatorio();
                vendRel.setIDCombustivel(rs.getInt("IdCombustivel"));
                vendRel.setQuantidade(rs.getFloat("Quantidade"));
                vendRel.setData(rs.getString("Data"));
                vendasDeFunc.add(vendRel);
            } 
        } catch(SQLException ex){
            throw new RuntimeException(ex);
        }
        return vendasDeFunc;
    }
    
    public ArrayList<VendaRelatorio> relatorioData(String Datamin, String Datamax){
        String sql = "SELECT * FROM venda WHERE data >= ? AND data <= ?";
        ArrayList<VendaRelatorio> vendasdatada = new ArrayList<VendaRelatorio>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, Datamin);
            stmt.setString(2, Datamax);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                VendaRelatorio vendRel = new VendaRelatorio();
                vendRel.setIDCombustivel(rs.getInt("IdCombustivel"));
                vendRel.setQuantidade(rs.getFloat("Quantidade"));
                vendRel.setData(rs.getString("Data"));
                vendRel.setValor(rs.getFloat("Valor"));
                vendasdatada.add(vendRel);
            }
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return vendasdatada;
    }
    
    public ArrayList<VendaRelatorio> relatorioVendaData(int ID, String Datamin, String Datamax){
        RelatorioDAO rel = new RelatorioDAO();
        ArrayList<VendaRelatorio> vendas = new ArrayList<VendaRelatorio>();
        ArrayList<VendaRelatorio> vendasdatada = new ArrayList<VendaRelatorio>();
        vendas = rel.relatorioVenda(ID);
        LocalDate dataMinima = LocalDate.parse(Datamin, DateTimeFormatter.ISO_DATE);
        LocalDate dataMaxima = LocalDate.parse(Datamax, DateTimeFormatter.ISO_DATE);
        for(VendaRelatorio venda :vendas){
            LocalDate dataCont = LocalDate.parse(venda.getData(), DateTimeFormatter.ISO_DATE);
                if(dataCont.isAfter(dataMinima) && dataCont.isBefore(dataMaxima)){
                    vendasdatada.add(venda);
                }
            }
        return vendasdatada;
        }
}
    
