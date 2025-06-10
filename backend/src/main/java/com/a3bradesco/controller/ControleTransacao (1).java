package com.a3bradesco.controller;

import com.a3bradesco.model.Transacao;
import com.a3bradesco.service.TransacaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class ControleTransacao {

    @Autowired
    private TransacaoServico servico;

    @PostMapping("/simular")
    public ResponseEntity<Transacao> simularTransacao(@RequestBody Transacao transacao) {
        Transacao salva = servico.salvar(transacao);
        return ResponseEntity.ok(salva);
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listarTransacoes() {
        return ResponseEntity.ok(servico.listar());
    }
}