package Principal;

/**
 *
 * @author Gustavo
 * 19/06/2018
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Relogio extends TimerTask  //Herdando da classe TimeTask
{
    JLabel data; //atributo do tipo JLabel
    SimpleDateFormat formatador = new SimpleDateFormat("dd'/'MM'/'yyyy' - 'HH':'mm':'ss"); //Instanciando mascara de data da classe SimpleDateFormat

    public Relogio(JLabel jLabel) //construtor com parametro JLabel
    {
        this.data = jLabel; //Setando o valor do atributo data
    }

    @Override
    public void run() //Sobreescrevendo método 'run' 
    {
        Date dataAtual = new Date(); //Instanciando a classe Date
        data.setText(this.formatador.format(dataAtual)); //Definindo o texto do atributo / jLabel 'data' / como a hora atual do sistema
    }
}