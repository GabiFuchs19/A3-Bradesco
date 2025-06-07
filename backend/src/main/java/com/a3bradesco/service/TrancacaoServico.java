package com.a3bradesco.service;
import com.a3bradesco.model.Transacao;
import com.a3bradesco.repository.TransacaoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.HexFormat;
import java.util.Optional;
@Service
public class TrancacaoServico {

    @Autowired
    private TransacaoaRepositorio repository;

    public Transacao criarTransacao(Transacao transacao) {
        transacao.setStatus("Concluída");
        transacao.setDataHora(LocalDateTime.now());

        String hash = gerarHash(transacao.getChaveDestino(), transacao.getValor(), transacao.getDataHora().toString());
        transacao.setHashBlockchain(hash);

        return repository.save(transacao);
    }

    public Optional<Transacao> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Optional<Transacao> buscarPorHash(String hash) {
        return repository.findByHashBlockchain(hash);
    }

    private String gerarHash(String chave, Double valor, String data) {
        try {
            String texto = chave + valor + data;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(texto.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash", e);
        }
    }
}
