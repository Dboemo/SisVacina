/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Table;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Label;
import controle.Conexao;
import controle.FornecedorControle;
import java.sql.Connection;
import modelo.Fornecedor;
/**
 *
 * @author boemo
 */
public class TelaListagemFornecedores extends Window {
    private Button botaoSair;
    private Table tblCli;
    private Panel pnlLista;
    private Component[] linha=new Component[2];
    private static GUIScreen guiScreen;

    public TelaListagemFornecedores(GUIScreen gs) {
        super("Relação de Fornecedores");
              this.guiScreen=gs;
    init();   
    }

    private void init() {
      Connection conn = Conexao.AbrirConexao();
      FornecedorControle ctrl=new FornecedorControle(conn);
        setBorder(new Border.Standard());
        pnlLista = new Panel(Panel.Orientation.HORISONTAL);
        tblCli = new Table(2, "Relação de Fornecedores");
        tblCli.setColumnPaddingSize(1);
        tblCli.removeAllRows();
        linha[0] = new Label("CNPJ");
        linha[1] = new Label("Nome              ");
        tblCli.addRow(linha);
        linha[0] = new Label("----");
        linha[1] = new Label("------------------");
        tblCli.addRow(linha);      
        for (Fornecedor forn : ctrl.listarTodosFornecedores("")) {
        linha[0] = new Label(forn.getCNPJ());
        linha[1] = new Label(forn.getNomeFornecedor());
        tblCli.addRow(linha);
        }  
        addComponent(tblCli);
        botaoSair = new Button("Retornar", new Action() {
        @Override
            public void doAction() {
                close();
            }
        });      
     addComponent(botaoSair);
    }
}
