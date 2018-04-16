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
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.DialogButtons;
import com.googlecode.lanterna.gui.dialog.DialogResult;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import controle.Conexao;
import controle.FornecedorControle;
import java.sql.Connection;
import modelo.Fornecedor;

/**
 *
 * @author boemo
 */
public class TelaAlteraExcluiFornecedor extends Window {
    private Button botaoSair;
    private Table tblCli;
    private Panel pnlLista;
    private Label lblNome;
    private TextBox txtNome;
    private Button botaoConsultar;
    
    private Component[] linha=new Component[4];
    private static GUIScreen guiScreen;

    public TelaAlteraExcluiFornecedor(GUIScreen gs) {
        super("Relação de Fornecedores");
              this.guiScreen=gs;
    init();   
    }

    private void init() {
        setBorder(new Border.Standard());
        pnlLista = new Panel(Panel.Orientation.HORISONTAL);
        lblNome = new Label("Entre com o nome");
        txtNome = new TextBox();
        pnlLista.addComponent(lblNome);
        pnlLista.addComponent(txtNome);
        addComponent(pnlLista);
        botaoConsultar = new Button("Consultar", new Action() {
        @Override
            public void doAction() {
                removeComponent(tblCli);
                removeComponent(botaoSair);
                consulta(txtNome.getText());
            }
        }); 
        addComponent(botaoConsultar);
    }

private void consulta(String texto) {
        Connection conn = Conexao.AbrirConexao();
        FornecedorControle ctrl=new FornecedorControle(conn);       
        tblCli = new Table(4, "Relação de Fornecedores");
        tblCli.setColumnPaddingSize(1);
        tblCli.removeAllRows();
        linha[0] = new Label("CNPJ");
        linha[1] = new Label("Nome              ");
        linha[2] = new Label("Alteração");
        linha[3] = new Label("Exclusão");
        tblCli.addRow(linha);
        
        linha[0] = new Label("----");
        linha[1] = new Label("------------------");
        linha[2] = new Label("---------");
        linha[3] = new Label("--------");
        tblCli.addRow(linha);      
        
        
        for (Fornecedor forn : ctrl.listarTodosFornecedores(texto)) {
        linha[0] = new Label(forn.getCNPJ());
        linha[1] = new Label(forn.getNomeFornecedor());
        linha[2] = new Button("Alterar", new Action() {

            @Override
            public void doAction() {
//                DialogResult result =MessageBox.showMessageBox(guiScreen, "Alteração Fornecedor", "Deseja "
//                       + "alterar o fornecedor :"+forn.getNomeFornecedor().toString(),DialogButtons.OK_CANCEL);
//             if (result.equals(DialogResult.OK)){
//                MessageBox.showMessageBox(guiScreen, "mensagem", "OK"); 
//             }else{MessageBox.showMessageBox(guiScreen, "mensagem", "Toma papudo");}
                guiScreen.showWindow(new TelaModificarFornecedor(guiScreen,forn,"A"));
                
            }
        });
        linha[3] = new Button("Excluir", new Action() {

            @Override
            public void doAction() {
            guiScreen.showWindow(new TelaModificarFornecedor(guiScreen,forn,"E"));    
            
            }
        });
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
