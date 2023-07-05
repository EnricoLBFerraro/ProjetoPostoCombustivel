
package DAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Exportar {
    private Connection connection;
    public Exportar(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void exporta(String tabela) throws SQLException, IOException{
        try{
            String sql = "SELECT * FROM "+ tabela;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter fileWriter = new FileWriter("C:\\Users\\enric\\Desktop\\Projeto\\Excel\\"+tabela+".csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while(resultSet.next()){
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                StringBuilder rowData = new StringBuilder();
                for (int i=1;i<= columnCount;i++){
                    String value = resultSet.getString(i);
                    rowData.append(value);
                    if(i<columnCount){
                        rowData.append(",");
                    }
                }
                bufferedWriter.write(rowData.toString());
                bufferedWriter.newLine();
            }
            resultSet.close();
            statement.close();
            bufferedWriter.close();
            
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    
}
