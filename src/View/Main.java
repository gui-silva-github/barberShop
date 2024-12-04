/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author guilh
 */
public class Main {
    
    public static void main(String[] args) {
        
        Servico servico = new Servico(1, "Barba", 30);
        
        Cliente cliente = new Cliente(1, "Thiago", "Rua Teste", "987654543");
        
        Usuario usuario = new Usuario(1, "Barbeiro", "senha");
        
        System.out.println(cliente.getNome());
        
        Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "03/12/2024", "09:15", "Vai atrasar");
        System.out.println(agendamento.getCliente().getNome());
        
    }
    
}
