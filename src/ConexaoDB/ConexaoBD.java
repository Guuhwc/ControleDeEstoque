package ConexaoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Gonçalves
 * 14/06/2018
 */
public class ConexaoBD 
{
    private static final String DRIVER = "com.mysql.jdbc.Driver"; //Driver do JDBC
    private static final String NOME_DB = "projErp"; //nome da database
    private static final String USER = "root"; //usuario do mysql
    private static final String SENHA = ""; //senha do mysql
    private static final String URL = "jdbc:mysql://localhost:3306/" + NOME_DB; //url do banco de dados
    
    public static Connection conectar() throws SQLException 
    {
        //MÉTODO CONECTAR AO MYSQL
        try {
            Class.forName(DRIVER); //carrega o driver do JDBC
            return DriverManager.getConnection(URL, USER, SENHA); //Retorna a conexão ao mysql
            
        } catch (ClassNotFoundException | SQLException ex) //multi catch p/ tratamento de erro SQLException e ClassNotFoundException
        {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados:\n" + ex.getMessage(), "ERRO", JOptionPane.OK_OPTION);
            System.exit(0);
            throw new RuntimeException("Erro na conexão com o banco de dados:\n: ", ex); //(throw)tratamento de erro
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs) 
    {
         //METODO FECHAR CONEXÃO COM MYSQL, PREPARED STATEMENT E RESULTSET
        try {
            //Verifica se há conexoes ativas
            if (con != null) //se a conexão for diferente de nulo (ou seja, estiver conectado)
            {
                con.close(); //fecha a conexão do mysql                
            }
            if (stmt != null) //se a conexão do prepared statement for diferente de nulo (ou seja, estiver conectado)
            {
                stmt.close(); //fecha a conexão do prepared statement    
            }
            if (rs != null) //se a conexão do resultset for diferente de nulo (ou seja, estiver conectado)
            {
                rs.close(); //fecha a conexão do resultset            
            }
            //
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro no fechamento da conexão: "+ex.getMessage());
        }
    }
}