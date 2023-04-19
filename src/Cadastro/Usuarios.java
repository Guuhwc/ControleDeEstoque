package Cadastro;

/**
 *
 * @author Gustavo Gonçalves
 * 15/06/2018
 */

public class Usuarios 
{
    //id, login, senha, sexo, datanasc, privlevel, email, telefone
    private int id;
    private String login;
    private String senha;
    private String sexo;
    private String dataNasc;
    private int privLevel;
    private String email;
    private String telefone;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
        
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
        
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    
    public String getDataNasc() { return dataNasc; }
    public void setDataNasc(String dataNasc) { this.dataNasc = dataNasc; }
    
    public int getPrivLevel() { return privLevel; }
    public void setPrivLevel(int privLevel) { this.privLevel = privLevel; }  
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
        
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) {  this.telefone = telefone; }
}
