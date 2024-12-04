/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Usuario;
import View.Sign;

/**
 *
 * @author guilh
 */
public class LoginHelper implements IHelper {
    
    private final Sign view;
    
    public LoginHelper(Sign view){
        this.view = view;
    }
    
    @Override
    public Usuario obterModelo(){
        
        String nome = view.getEtUsuario().getText();
        String senha = view.getEtSenha().getText();
        
        Usuario modelo = new Usuario(0, nome, senha);
        
        return modelo;
        
    }
    
    public void setarModelo(Usuario modelo){
        
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getEtUsuario().setText(nome);
        view.getEtSenha().setText(senha);
        
    }
    
    @Override
    public void limparTela(){
        
        view.getEtUsuario().setText("");
        view.getEtSenha().setText("");
        
    }
    
}
