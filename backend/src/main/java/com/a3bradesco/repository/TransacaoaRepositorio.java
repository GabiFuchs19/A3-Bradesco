package com.a3bradesco.repository;

import com.a3bradesco.model.Transacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface TransacaoaRepositorio extends MongoRepository<Transacao, String> {
    Optional<Transacao> findByHashBlockchain(String hashBlockchain);
    }




