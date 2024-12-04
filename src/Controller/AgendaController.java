/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import Servico.SendMail;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela(){
        
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();  
        
        helper.preencherTabela(agendamentos);
        
    }
    
    public void atualizaCliente(){
        
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        
        helper.preencherClientes(clientes);
        
    }
    
    
    public void atualizaServico(){
        
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        helper.preencherServicos(servicos);
        
    }
    
    public void atualizaValor(){
        
        Servico servico = helper.obterServico();
        
        helper.setarValor(servico.getValor());
        
    }
    
    public void agendar(){
        
        Agendamento agendamento = helper.obterModelo();
        
        new AgendamentoDAO().insert(agendamento);
        
        atualizaTabela();
        
        SendMail sendEmailAgendamento = new SendMail(); 
        
        sendEmailAgendamento.sendEmail(agendamento.getCliente().getEmail(), 
                "Corte agendado para às " + agendamento.getHoraFormatada() + " do dia " + agendamento.getDataFormatada() + "!"
        );
        
        helper.limparTela();
        
    }
    
}
