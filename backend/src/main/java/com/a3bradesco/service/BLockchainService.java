package com.a3bradesco.service;
import com.a3bradesco.model.Block;
import com.a3bradesco.model.Transacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BLockchainService {
    public class BlockchainService {
        private List<Block> blockchain = new ArrayList<>();

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
    }
}
