/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;

/**
 *
 * @author boemo
 */
class TelaFornecedores extends Window {
 private Panel painel01;
 private Label label01;
 private Button botaoIncluir;
 private Button botaoAlteraExclui;
 private Button botaoListagem;
 private Button botaoSair;
 private GUIScreen guitelaFornecedores;
 
 
    public TelaFornecedores(GUIScreen gs) {
        super("Cadastros");
        this.guitelaFornecedores=gs;
        init();
    }

    private void init() {
      setBorder(new Border.Standard());
        painel01 = new Panel(Panel.Orientation.VERTICAL);
        botaoIncluir = new Button("Incluir Fornecedor", new Action() {
            @Override
            public void doAction() {
              guitelaFornecedores.showWindow(new TelaIncluirFornecedor(guitelaFornecedores));
            }
        });
        painel01.addComponent(botaoIncluir);
           botaoAlteraExclui = new Button("Alterar e excluir Fornecedor", new Action() {
            @Override
            public void doAction() {
              guitelaFornecedores.showWindow(new TelaAlteraExcluiFornecedor(guitelaFornecedores));
            }
        });
        painel01.addComponent(botaoAlteraExclui);     
            botaoListagem = new Button("Listar Fornecedores", new Action() {
            @Override
            public void doAction() {
              guitelaFornecedores.showWindow(new TelaListagemFornecedores(guitelaFornecedores));
            }
        });
        painel01.addComponent(botaoListagem);     

        botaoSair = new Button("Retornar", new Action() {
        @Override
            public void doAction() {
                close();
            }
        });      
        painel01.addComponent(botaoSair);
        
        addComponent(painel01);
    }
    
}
