package com.a3bradesco.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.a3bradesco.model.Transacao;

public interface TransacaoRepositorio extends MongoRepository<Transacao, String> {
}
