package com.a3bradesco.service;

import com.a3bradesco.model.Block;
import com.a3bradesco.model.Transacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockchainService {
    private final List<Block> blockchain = new ArrayList<>();

    public BlockchainService() {
        blockchain.add(criarGenesis());
    }

    private Block criarGenesis() {
        return new Block(0, new Transacao(), "0");
    }

    public Block adicionarTransacaoNaBlockchain(Transacao transacao) {
        Block ultimoBloco = blockchain.get(blockchain.size() - 1);
        Block novoBloco = new Block(blockchain.size(), transacao, ultimoBloco.getHash());
        blockchain.add(novoBloco);

        System.out.println("✅ Novo bloco adicionado: " + novoBloco.getHash());
        System.out.println("🔗 Hash da transação recebido: " + transacao.getBlockchainHash());

        return novoBloco;
    }

    public List<Block> listarBlockchain() {
        return blockchain;
    }

    public boolean validarBlockchain() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block atual = blockchain.get(i);
            Block anterior = blockchain.get(i - 1);
            if (!atual.getHash().equals(atual.calcularHash())) return false;
            if (!atual.getPreviousHash().equals(anterior.getHash())) return false;
        }
        return true;
    }

    public boolean hashExiste(String hash) {
        return blockchain.stream().anyMatch(bloco -> {
            Transacao transacao = bloco.getTransacao();
            return transacao.getBlockchainHash() != null && transacao.getBlockchainHash().equals(hash);
        });
    }

    public void imprimirBlockchain() {
        System.out.println("📦 Blockchain atual:");
        for (Block bloco : blockchain) {
            System.out.println("- Índice: " + bloco.getIndex());
            System.out.println("  Hash do bloco: " + bloco.getHash());
            System.out.println("  Hash anterior: " + bloco.getPreviousHash());
            Transacao t = bloco.getTransacao();
            System.out.println("  Hash da transação: " + (t != null ? t.getBlockchainHash() : "null"));
            System.out.println("  --------------------------");
        }
    }
}


