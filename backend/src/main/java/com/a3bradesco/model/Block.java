package com.a3bradesco.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
    private int index;
    private Transacao transacao;
    private String hash;
    private String previousHash;

    public Block(int index, Transacao transacao, String previousHash) {
        this.index = index;
        this.transacao = transacao;
        this.previousHash = previousHash;
        this.hash = calcularHash();
    }

    public String calcularHash() {
        String texto = index + transacao.toString() + previousHash;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(texto.getBytes());
            StringBuilder buffer = new StringBuilder();
            for (byte b : bytes) {
                buffer.append(String.format("%02x", b));
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public int getIndex() {
        return index;
    }

    public Transacao getTransacao() {
        return transacao;
    }
}

