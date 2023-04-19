package Login;

import ConexaoDB.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Gonçalves
 * 15/06/2018
 */
public class LoginPrincipal 
{
    public boolean permissaoLogar(String email, String senha) throws SQLException 
    {
        //PERMISSAO PARA LOGAR (BOOLEANO)
        
        Connection con = ConexaoBD.conectar(); //Conecta ao banco de dados
        PreparedStatement stmt = null; //definindo PreparedStatement como nulo para usar depois
        ResultSet rs = null; //definindo o resultset como nulo para usar depois
        
        boolean permissao = false; //Definindo a variavel permissao como boleana para usar depois

        try {
            //comando SELECT sql
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE email = ? and senha = ?");
            //
            //Definindo os valores dos "?" escrito no comando SQL
            stmt.setString(1, email);
            stmt.setString(2, senha);
            //
            rs = stmt.executeQuery(); //Executa o comando do stmt

            if (rs.next()) //se percorrer o resultset
            {
                permissao = true; //pode logar
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao permitir login: " + ex);
        } finally {
            ConexaoBD.fecharConexao(con, stmt, rs); //Fecha conexao com banco de dados, stmt e resultset
        }
        return permissao; //retorna o valor do booleano
    }
    
}
