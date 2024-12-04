/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.MenuPrincipal;
import View.Sign;

/**
 *
 * @author guilh
 */
public class LoginController {

    private final Sign view;
    private LoginHelper helper;

    public LoginController(Sign view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarNoSistema(){
        
        Usuario usuario = helper.obterModelo();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        
        if(usuarioAutenticado != null){
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        } else {
            view.exibeMensagem("Usuario e/ou senha inválidos");
        }
        
    }
    
    public void fizTarefa(){
        this.view.exibeMensagem("Executei o fizTarefa");
    }
    
}
