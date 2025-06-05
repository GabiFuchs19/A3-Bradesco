package com.a3bradesco.pix_simulador_backend.repositorio;

import com.a3bradesco.pix_simulador_backend.modelo.Transacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface TransacaoaRepositorio extends MongoRepository<Transacao, String> {
    Optional<Transacao> findByHashBlockchain(String hashBlockchain);
    }




