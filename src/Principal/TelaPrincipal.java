package Principal;

import Controle.PainelEstoque;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.Timer;

/**
 *
 * @author Gustavo Gonçalves
 * 07/06/2018
 */
public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        this.initComponents();
        this.setTitle("Menu");
        
        //Atualizar o a label data em tempo real
        Timer t = new Timer(); //Instanciando a classe Timer
        Relogio r = new Relogio(lblData); //Instanciando a classe Relogio
        t.scheduleAtFixedRate(r, 0, 1000); //permite a repetição da execução do código a cada 'x' tempo
        //
        
        /* 
        
        Cria e executa uma ação Runnable/Callable periódica que é ativada 
        pela primeira vez após o atraso inicial dado.
        scheduleAtFixedRate(tarefa, tempoInicial, tempoFinal);
        
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblData = new javax.swing.JLabel();
        lblVersao = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblBackground = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuSistema = new javax.swing.JMenu();
        submenuAlunoControle = new javax.swing.JMenu();
        submenuControleEstoque = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        submenuControleFinanceiro = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        submenuSobre = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        lblData.setFont(lblData.getFont().deriveFont(lblData.getFont().getStyle() & ~java.awt.Font.BOLD, lblData.getFont().getSize()+3));
        lblData.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        getContentPane().add(lblData);
        lblData.setBounds(10, 300, 240, 30);

        lblVersao.setFont(lblVersao.getFont().deriveFont(lblVersao.getFont().getStyle() & ~java.awt.Font.BOLD, lblVersao.getFont().getSize()+3));
        lblVersao.setText("v 1.0 [BETA]");
        getContentPane().add(lblVersao);
        lblVersao.setBounds(570, 300, 90, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 20, 0, 2);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bgPrincipal.jpg"))); // NOI18N
        lblBackground.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 660, 330);

        barraMenu.setBackground(new java.awt.Color(204, 204, 204));
        barraMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        menuSistema.setText("Sistema");

        submenuAlunoControle.setText("Controle");

        submenuControleEstoque.setText("Estoque");
        submenuControleEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuControleEstoqueActionPerformed(evt);
            }
        });
        submenuAlunoControle.add(submenuControleEstoque);
        submenuAlunoControle.add(jSeparator5);

        submenuControleFinanceiro.setText("Financeiro");
        submenuControleFinanceiro.setEnabled(false);
        submenuAlunoControle.add(submenuControleFinanceiro);

        menuSistema.add(submenuAlunoControle);

        barraMenu.add(menuSistema);

        menuAjuda.setText("Ajuda");
        menuAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAjudaActionPerformed(evt);
            }
        });

        submenuSobre.setText("Sobre");
        submenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuSobreActionPerformed(evt);
            }
        });
        menuAjuda.add(submenuSobre);

        barraMenu.add(menuAjuda);

        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        barraMenu.add(menuSair);

        setJMenuBar(barraMenu);

        setSize(new java.awt.Dimension(674, 390));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAjudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAjudaActionPerformed

    private void submenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuSobreActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Teste menu SOBRE", "Sobre", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_submenuSobreActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        //Menu > Sair
        int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (opc == JOptionPane.YES_OPTION) { System.exit(0); }
    }//GEN-LAST:event_menuSairMouseClicked

    private void submenuControleEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuControleEstoqueActionPerformed
        //SUBMENU CONTROLE DE ESTOQUE
        try {
            PainelEstoque p1 = new PainelEstoque(); //Instancia a Classe PainelEstoque
            p1.setLocationRelativeTo(null); //Centraliza o Form
            p1.setVisible(true); //Torna o form visível
            this.setResizable(false);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());

        }
    }//GEN-LAST:event_submenuControleEstoqueActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JLabel lblBackground;
    public javax.swing.JLabel lblData;
    private javax.swing.JLabel lblVersao;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenu menuSistema;
    private javax.swing.JMenu submenuAlunoControle;
    private javax.swing.JMenuItem submenuControleEstoque;
    private javax.swing.JMenuItem submenuControleFinanceiro;
    private javax.swing.JMenuItem submenuSobre;
    // End of variables declaration//GEN-END:variables
}