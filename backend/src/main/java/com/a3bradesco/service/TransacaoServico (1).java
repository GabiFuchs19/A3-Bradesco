package com.a3bradesco.service;

import com.a3bradesco.model.Transacao;
import com.a3bradesco.repository.TransacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransacaoServico {

    @Autowired
    private TransacaoRepositorio repositorio;

    public Transacao salvar(Transacao transacao) {
        transacao.setScore(Math.random() * 100);
        transacao.setBlockchainHash(UUID.randomUUID().toString());
        return repositorio.save(transacao);
    }

    public List<Transacao> listar() {
        return repositorio.findAll();
    }
}