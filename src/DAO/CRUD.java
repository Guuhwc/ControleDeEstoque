package DAO;

import Controle.Estoque;
import ConexaoDB.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Gonçalves
 * 14/06/2018
 */

//Comentários:


//PreparedStatement é uma forma de você fazer uma inserção no banco mais segura
//onde você prepara os parametros para serem inseridos.
//É usado para criar um objeto que representa a instrução SQL que será executada.

//O Resultset é uma classe da API JAVA que permite percorrermos um DataTable 
//de alguma consulta em um banco de dados.
//Representa o conjunto de resultados de uma tabela no banco de dados.

        
public class CRUD 
{
    public void salvarInsert(Estoque t) throws SQLException 
    {
        //COMANDO INSERT
        
        Connection con = ConexaoBD.conectar(); //Conecta ao banco de dados
        PreparedStatement stmt = null; //definindo PreparedStatement como nulo para usar depois
        ResultSet rs = null; //definindo o resultset como nulo para usar depois

        try {
            //Comando INSERT SQL
            stmt = con.prepareStatement("INSERT INTO estoque (nomeBebida, lote, qtd, validade, tipo, recebimento, preco) VALUES (?, ?, ?, ?, ?, ?, ?)");
            //
            //Definindo os valores dos "?" escrito no comando SQL
            stmt.setString(1, t.getNomeBebida());
            stmt.setString(2, t.getLote());
            stmt.setInt(3, t.getQtd());
            stmt.setString(4, t.getValidade());
            stmt.setString(5, t.getTipo());
            stmt.setString(6, t.getRecebimento());
            stmt.setDouble(7, t.getPreco());
            //
            stmt.executeUpdate(); //Executa o comando do stmt

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        } finally {
            ConexaoBD.fecharConexao(con, stmt, rs); //Fecha a conexão banco de dados e o prepared statement (stmt)
        }
    }

    public ArrayList<Estoque> lerSelect() throws SQLException 
    {
        //COMANDO SELECT
        
        Connection con = ConexaoBD.conectar(); //Conecta ao banco de dados
        PreparedStatement stmt = null; //definindo PreparedStatement como nulo para usar depois
        ResultSet rs = null; //definindo o resultset como nulo para usar depois

        ArrayList<Estoque> estoque = new ArrayList<>(); //Criando o vetor (arraylist) "estoque"

        try {
            stmt = con.prepareStatement("SELECT * FROM estoque"); //COMANDO SQL
            rs = stmt.executeQuery(); //executa o comando

            while (rs.next()) //Faz a verificação de enquanto conter registros, percorre e resgata os valores.
            {
                Estoque produtos = new Estoque(); //Instaciando o objeto "produtos" da classe de gets e sets

                //pega os valores      
                produtos.setId(rs.getInt("id"));
                produtos.setNomeBebida(rs.getString("nomeBebida"));
                produtos.setLote(rs.getString("lote"));
                produtos.setQtd(rs.getInt("qtd"));
                produtos.setValidade(rs.getString("validade"));
                produtos.setTipo(rs.getString("tipo"));
                produtos.setRecebimento(rs.getString("recebimento"));
                produtos.setPreco(rs.getDouble("preco"));
                produtos.setPrecoTotal(rs.getDouble("preco") * rs.getInt("qtd"));
                //
                estoque.add(produtos); //Adiciona os valores no arraylist
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } finally {
            ConexaoBD.fecharConexao(con, stmt, rs); //Fecha conexao com banco de dados, stmt e resultset
        }
        return estoque; //retorna o valor do arraylist
    }

    public ArrayList<Estoque> lerSelectPorId(String atributo, int posicao) throws SQLException 
    {
        //(tipo arraylist)
        //COMANDO SELECT POR MENU (combobox)
        
        Connection con = ConexaoBD.conectar(); //Conecta ao banco de dados
        PreparedStatement stmt = null; //definindo PreparedStatement como nulo para usar depois
        ResultSet rs = null; //definindo o resultset como nulo para usar depois

        ArrayList<Estoque> estoque = new ArrayList<>(); //Criando o vetor (arraylist) "estoque"

        try {
            //0 id, 1 nomeBebida, 2 lote, 3 qtd, 4 validade, 5 tipo, 6 recebimento, 7 preco
            //SWITCH CASE PARA AS POSIÇÕES DO COMBOBOX
            switch (posicao) 
            {
                case 0:
                    //Buscar por ID (Indice 0)
                    stmt = con.prepareStatement("SELECT * FROM estoque WHERE id LIKE ?"); //comando sql
                    stmt.setString(1, "%" + atributo + "%"); //Definindo o valor do "?" escrito no comando SQL
                    rs = stmt.executeQuery(); //Executa o comando
                    break;
                case 1:
                    //Buscar por nome (Indice 1)
                    stmt = con.prepareStatement("SELECT * FROM estoque WHERE nomeBebida LIKE ?"); //comando sql 
                    stmt.setString(1, "%" + atributo + "%"); //Definindo o valor do "?" escrito no comando SQL
                    rs = stmt.executeQuery(); //Executa o comando
                    break;
                case 2:
                    //Buscar por número de lote (Indice 2)
                    stmt = con.prepareStatement("SELECT * FROM estoque WHERE lote LIKE ?"); //comando sql
                    stmt.setString(1, "%" + atributo + "%"); //Definindo o valor do "?" escrito no comando SQL
                    rs = stmt.executeQuery(); //Executa o comando
                    break;
                case 3:
                    //Buscar por quantidade (Indice 3)
                    stmt = con.prepareStatement("SELECT * FROM estoque WHERE qtd LIKE ?"); //comando sql
                    stmt.setString(1, "%" + atributo + "%"); //Definindo o valor do "?" escrito no comando SQL
                    rs = stmt.executeQuery(); //Executa o comando
                    break;
                case 4:
                    //Buscar por validade (Indice 4)
                    stmt = con.prepareStatement("SELECT * FROM estoque WHERE validade LIKE ?"); //comando sql
                    stmt.setString(1, "%" + atributo + "%"); //Definindo o valor do "?" escrito no comando SQL
                    rs = stmt.executeQuery(); //Executa o comando
                    break;
                case 5:
                    //Buscar por tipo de produto (Indice 5)
                    stmt = con.prepareStatement("SELECT * FROM estoque WHERE tipo LIKE ?"); //comando sql
                    stmt.setString(1, "%" + atributo + "%"); //Definindo o valor do "?" escrito no comando SQL
                    rs = stmt.executeQuery(); //Executa o comando
                    break;
                default:
                    break;
            }

            while (rs.next()) //Faz a verificação de enquanto conter registros, percorre e resgata os valores
            {
                Estoque produtos = new Estoque(); //Instaciando o objeto "produtos" da classe de gets e sets
                
                //pega os valores                
                produtos.setId(rs.getInt("id"));
                produtos.setNomeBebida(rs.getString("nomeBebida"));
                produtos.setLote(rs.getString("lote"));
                produtos.setQtd(rs.getInt("qtd"));
                produtos.setValidade(rs.getString("validade"));
                produtos.setTipo(rs.getString("tipo"));
                produtos.setRecebimento(rs.getString("recebimento"));
                produtos.setPreco(rs.getDouble("preco"));
                produtos.setPrecoTotal(rs.getDouble("preco") * rs.getInt("qtd"));
                //
                estoque.add(produtos); //adiciona os valores no arraylist
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } finally {
            ConexaoBD.fecharConexao(con, stmt, rs); //Fecha conexao com banco de dados, stmt e resultset
        }
        return estoque; //retorna o valor do arraylist
    }

    public void atualizarUpdate(Estoque t) throws SQLException 
    {
        //COMANDO UPDATE
        Connection con = ConexaoBD.conectar(); //Conecta ao banco de dados
        PreparedStatement stmt = null; //definindo PreparedStatement como nulo para usar depois
        ResultSet rs = null; //definindo o resultset como nulo para usar depois
        
        try {
            //Comando UPDATE SQL
            stmt = con.prepareStatement("UPDATE estoque SET nomeBebida = ?, lote = ?, qtd = ?, validade = ?, tipo = ?, recebimento = ?, preco = ? WHERE id = ?");
            //
            //Definindo os valores dos "?" escrito no comando SQL
            stmt.setString(1, t.getNomeBebida());
            stmt.setString(2, t.getLote());
            stmt.setInt(3, t.getQtd());
            stmt.setString(4, t.getValidade());
            stmt.setString(5, t.getTipo());
            stmt.setString(6, t.getRecebimento());
            stmt.setDouble(7, t.getPreco());
            stmt.setInt(8, t.getId());
            //
            stmt.executeUpdate(); //Executa o comando do stmt

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConexaoBD.fecharConexao(con, stmt, rs); //Fecha a conexão banco de dados e o prepared statement (stmt)
        }
    }

    public void deletarDelete(Estoque t) throws SQLException 
    {
        //COMANDO DELETE        
        Connection con = ConexaoBD.conectar(); //Conecta ao banco de dados
        PreparedStatement stmt = null; //definindo PreparedStatement como nulo para usar depois
        ResultSet rs = null; //definindo o resultset como nulo para usar depois

        try {
            //Comando UPDATE SQL
            stmt = con.prepareStatement("DELETE FROM estoque WHERE id = ?");
            //Definindo o valor do "?" escrito no comando SQL
            stmt.setInt(1, t.getId());
            //
            stmt.executeUpdate();//Executa o comando do stmt

            JOptionPane.showMessageDialog(null, "ID '" + t.getId() + "' excluido com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConexaoBD.fecharConexao(con, stmt, rs); //Fecha a conexão e o prepared statement (stmt)
        }
    }
}
