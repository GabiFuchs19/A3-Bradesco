package com.a3bradesco.pix_simulador_backend.controle;
import com.a3bradesco.pix_simulador_backend.modelo.Transacao;
import com.a3bradesco.pix_simulador_backend.servico.TrancacaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/transacoes")
public class ControleTransacao {
    @Autowired
    private TrancacaoServico service;

    @PostMapping
    public Transacao criarTransacao(@RequestBody Transacao transacao) {
        return service.criarTransacao(transacao);
    }

    @GetMapping("/{id}")
    public Optional<Transacao> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/verificar/{hash}")
    public Optional<Transacao> verificarPorHash(@PathVariable String hash) {
        return service.buscarPorHash(hash);
    }
}

