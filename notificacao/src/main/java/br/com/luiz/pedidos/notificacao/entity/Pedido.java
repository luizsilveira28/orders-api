package br.com.luiz.pedidos.notificacao.entity;

import br.com.luiz.pedidos.api.entity.ItemPedido;
import br.com.luiz.pedidos.api.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pedido {
    private UUID id = UUID.randomUUID();
    @NonNull
    private String cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private double valorTotal;
    private String emailNotificacao;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHora = LocalDateTime.now();
    private Status status;

}
