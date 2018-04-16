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
import com.googlecode.lanterna.gui.component.Panel;


/**
 *
 * @author boemo
 */
class TelaCadastros extends Window {
 private Panel painel01;
 private Button botaoClientes;
 private Button botaoFornecedores;
 private Button botaoFuncionarios;
 private Button botaoVacinas;
 private Button botaoSair;
 
 
 private static GUIScreen guitelaCadastros;
 
    public TelaCadastros(GUIScreen gs) {
        super("Cadastros");
        this.guitelaCadastros=gs;
        init();
    }

    private void init() {
        
        setBorder(new Border.Standard());
        painel01 = new Panel(Panel.Orientation.VERTICAL);
        botaoClientes = new Button("Clientes", new Action() {
            @Override
            public void doAction() {
              //guitelaprincipal.showWindow(new TelaCadastros(guitelaprincipal));
            }
            
        });
        painel01.addComponent(botaoClientes);
        botaoFornecedores = new Button("Fornecedor", new Action() {
            @Override
            public void doAction() {
            guitelaCadastros.showWindow(new TelaFornecedores(guitelaCadastros));
            }
            
        });
        painel01.addComponent(botaoFornecedores);
         botaoFuncionarios = new Button("Funcionários", new Action() {
            @Override
            public void doAction() {
             // guitelaprincipal.showWindow(new TelaCadastros(guitelaprincipal));
            }
            
        });
        painel01.addComponent(botaoFuncionarios);       
         botaoVacinas = new Button("Vacinas", new Action() {
            @Override
            public void doAction() {
              //guitelaprincipal.showWindow(new TelaCadastros(guitelaprincipal));
            }
            
        });
        painel01.addComponent(botaoVacinas); 
        
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
