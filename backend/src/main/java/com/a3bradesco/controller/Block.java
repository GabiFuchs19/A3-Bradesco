package com.a3bradesco.model;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class Block {
    private int index;
    private String timestamp;
    private Transacao transacao;
    private String previousHash;
    private String hash;

    public Block(int index, Transacao transacao, String previousHash) {
        this.index = index;
        this.timestamp = LocalDateTime.now().toString();
        this.transacao = transacao;
        this.previousHash = previousHash;
        this.hash = calcularHash();
    }

    public String calcularHash() {
        String dados = index + timestamp + transacao.toString() + previousHash;
        return Integer.toHexString(dados.hashCode());
    }
}
