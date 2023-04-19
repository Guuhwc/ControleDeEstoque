package Controle;

/**
 *
 * @author Gustavo Gonçalves
 * 14/06/2018
 */
public class Estoque 
{
    //id, nomeBebida, lote, qtd, validade, tipo, recebimento, preco
    private int id;
    private String nomeBebida;
    private String lote;
    private int qtd;
    private String validade;
    private String tipo;
    private String recebimento;
    private Double preco;
    private Double precototal;

    public int getId() { return id; }        
    public void setId(int id) { this.id = id; }

    public String getNomeBebida() { return nomeBebida; }
    public void setNomeBebida(String nomeBebida) { this.nomeBebida = nomeBebida; }
        
    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }

    public int getQtd() { return qtd; }
    public void setQtd(int qtd) { this.qtd = qtd; }

    public String getValidade() { return validade; }
    public void setValidade(String validade) { this.validade = validade; }
  
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
        
    public String getRecebimento() { return recebimento; }
    public void setRecebimento(String recebimento) { this.recebimento = recebimento; }
 
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Double getPrecoTotal() { return precototal; }
    public void setPrecoTotal(Double precototal) { this.precototal = precototal; }

}