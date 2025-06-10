package com.a3bradesco.controller;

import com.a3bradesco.model.Transacao;
import com.a3bradesco.service.TransacaoServico;
import com.a3bradesco.service.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/transacoes")
public class ControleTransacao {

    @Autowired
    private TransacaoServico servico;

    @Autowired
    private BlockchainService blockchainService;

    // POST /api/transacoes/simular
    @PostMapping("/simular")
    public ResponseEntity<?> simularTransacao(@RequestBody Transacao transacao) {
        try {
            Transacao salva = servico.salvar(transacao);
            return ResponseEntity.ok(salva);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno no servidor.");
        }
    }

    // GET /api/transacoes
    @GetMapping
    public ResponseEntity<List<Transacao>> listarTransacoes() {
        return ResponseEntity.ok(servico.listar());
    }

    // GET /api/transacoes/verificar/{hash}
    @GetMapping("/verificar/{hash}")
    public ResponseEntity<String> verificarHash(@PathVariable String hash) {
        boolean existe = blockchainService.hashExiste(hash);
        if (existe) {
            return ResponseEntity.ok("✅ Hash encontrado na blockchain.");
        } else {
            return ResponseEntity.status(404).body("❌ Hash não encontrado.");
        }
    }
}




