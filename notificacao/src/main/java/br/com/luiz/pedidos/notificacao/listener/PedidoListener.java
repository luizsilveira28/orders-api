package br.com.luiz.pedidos.notificacao.listener;

import br.com.luiz.pedidos.api.entity.Pedido;
import br.com.luiz.pedidos.api.service.PedidoService;
import br.com.luiz.pedidos.notificacao.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    @Autowired
    private EmailService emailService;

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    @RabbitListener(queues = "pedidos.vi.pedido-criado.gerar-notificacao")
    public void enviarNotificacao(Pedido pedido) {
        emailService.enviarEmail(pedido);
        logger.info("Enviando notificacao... Pedido: {}", pedido.toString());
    }

}
