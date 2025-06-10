package com.a3bradesco.service;

import com.a3bradesco.model.Block;
import com.a3bradesco.model.Transacao;
import com.a3bradesco.repository.TransacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.util.StringUtils;

@Service
public class TransacaoServico {

    @Autowired
    private TransacaoRepositorio repositorio;

    @Autowired
    private BlockchainService blockchainService;

    public Transacao salvar(Transacao transacao) {
        transacao.setScore(Math.random() * 100);

        String hashDoJson = transacao.getBlockchainHash();

        if (!StringUtils.hasText(hashDoJson)) {
            // Se o hash estiver vazio ou nulo, lança exceção para indicar erro
            throw new IllegalArgumentException("O campo 'blockchainHash' é obrigatório e deve ser informado.");
        }

        transacao.setBlockchainHash(hashDoJson);

        // Registra na blockchain para manter histórico
        blockchainService.adicionarTransacaoNaBlockchain(transacao);

        return repositorio.save(transacao);
    }

    public List<Transacao> listar() {
        return repositorio.findAll();
    }
}


