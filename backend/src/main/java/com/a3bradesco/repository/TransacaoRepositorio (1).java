package com.a3bradesco.repository;

import com.a3bradesco.model.Transacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepositorio extends MongoRepository<Transacao, String> {}