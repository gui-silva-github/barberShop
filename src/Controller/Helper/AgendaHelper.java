/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Servico.SendMail;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilh
 */
    public class AgendaHelper implements IHelper {
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
      
        DefaultTableModel tableModel = (DefaultTableModel) view.getTabelaAgendamentos().getModel();
        tableModel.setNumRows(0);
        
        for(Agendamento agendamento : agendamentos){
            
            tableModel.addRow(new Object[]{
               
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
                
            });
            
        }
        
    }

    public void preencherClientes(ArrayList<Cliente> clientes) {
            
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getJComboBoxCliente().getModel();
        
        for(Cliente cliente : clientes){
            
            comboBoxModel.addElement(cliente);
            
        }
        
    }
    
    public void preencherServicos(ArrayList<Servico> servicos){
        
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getJComboBoxServico().getModel();
        
        for(Servico servico : servicos){
            
            comboBoxModel.addElement(servico);
            
        }
        
    }
    
    public Cliente obterCliente() {
        
        return (Cliente) view.getJComboBoxCliente().getSelectedItem();
        
    }

    public Servico obterServico() {
        
        return (Servico) view.getJComboBoxServico().getSelectedItem();
        
    }

    public void setarValor(float valor) {
       
        view.getEtValor().setText(valor+"");
        
    }

    @Override
    public Agendamento obterModelo() {
        
        int id = Integer.parseInt(view.getEtId().getText());
        
        Cliente cliente = obterCliente();
        
        Servico servico = obterServico();
        
        String valorString = view.getEtValor().getText();
        float valor = Float.parseFloat(valorString);
        
        String data = view.getEtData().getText();
        
        String hora = view.getEtHora().getText();
        
        String observacao = view.getEtObservacao().getText();
        
        Agendamento agendamento = new Agendamento(id, cliente, servico, valor, data, hora, observacao);
        
        return agendamento;
        
    }

    @Override
    public void limparTela() {
        view.getEtId().setText("0");
        view.getEtData().setText("");
        view.getEtHora().setText("");
        view.getEtObservacao().setText("");
    }
    
}
