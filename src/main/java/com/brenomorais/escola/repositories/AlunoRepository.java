package com.brenomorais.escola.repositories;

import org.springframework.stereotype.Repository;

import com.brenomorais.escola.models.Aluno;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class AlunoRepository {
	
	public void salvar(Aluno aluno) {
		
		MongoClient cliente = new MongoClient();
		MongoDatabase bancoDeDados = cliente.getDatabase("test");
		MongoCollection<Aluno> alunos = bancoDeDados.getCollection("alunos", Aluno.class);
		
		alunos.insertOne(aluno);
		
	}

}
