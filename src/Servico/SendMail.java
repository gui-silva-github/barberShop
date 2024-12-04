/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servico;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class SendMail {
    
    public void sendEmail(String email, String msg){
       
        String host = "exemplo.com.br";
        
        String port = "587"; 
        String username = "aulajava@exemplo.com.br"; 
        String password = "@1234"; 

        // Configurações para iniciar a sessão
        
        Properties props = new Properties();
        
        props.put("mail.smtp.ssl.trust", "exemplo.com.br");
        //props.put("mail.smtp.auth.mechanisms", "XOAUTH2");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
       

        // Criando uma sessão com autenticação
        
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Criando uma mensagem de e-mail
            Message message;
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Barbearia GuiBarber");
            
            message.setText(msg);
            // Enviando o e-mail
            Transport.send(message);

            JOptionPane.showMessageDialog(null, "E-mail enviado com sucesso!");
        
        } catch (MessagingException e) {
           JOptionPane.showMessageDialog(null, "Erro ao enviar e-mail! " + e.getMessage());
        }
   }
    
}
