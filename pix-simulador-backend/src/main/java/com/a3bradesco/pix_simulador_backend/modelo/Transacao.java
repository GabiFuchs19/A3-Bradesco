package com.a3bradesco.pix_simulador_backend.modelo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "transacoes")
public class Transacao {
    @Id
    private String id;
    private String chaveDestino;
    private Double valor;
    private String status;
    private LocalDateTime dataHora;
    private String hashBlockchain;
}
