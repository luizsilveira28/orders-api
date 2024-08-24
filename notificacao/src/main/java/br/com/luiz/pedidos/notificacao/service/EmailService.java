package br.com.luiz.pedidos.notificacao.service;

import br.com.luiz.pedidos.api.entity.Pedido;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarEmail(Pedido pedido){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("loja-do-luiz@store.com");
        simpleMailMessage.setTo(pedido.getEmailNotificacao());
        simpleMailMessage.setSubject("Notificacao do Pedido");
        simpleMailMessage.setText(this.gerarMensagem(pedido));
        mailSender.send(simpleMailMessage);
    }

    private String gerarMensagem(Pedido pedido) {
        String pedidoId = String.valueOf(pedido.getId());
        String data = String.valueOf(pedido.getDataHora());
        String cliente = String.valueOf(pedido.getCliente());
        String valor = String.valueOf(pedido.getValorTotal());
        String status = String.valueOf(pedido.getStatus());

        return String.format("Olá %s,\n Seu pedido de número %s, foi realizado com sucesso!\n Compra realizada hoje às %s com o valor total de R$%s reais!\n Seu " +
                        "pedido se encontra no status '%s'.", cliente, pedidoId
        , data, valor, status);


    }
}
