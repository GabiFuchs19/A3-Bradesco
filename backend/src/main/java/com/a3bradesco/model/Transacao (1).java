package com.a3bradesco.model;

public class Transacao {
    private String id;
    private String chavePix;
    private Double valor;
    private String nome;
    private Double score;
    private String blockchainHash;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getChavePix() { return chavePix; }
    public void setChavePix(String chavePix) { this.chavePix = chavePix; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public String getBlockchainHash() { return blockchainHash; }
    public void setBlockchainHash(String blockchainHash) { this.blockchainHash = blockchainHash; }
}