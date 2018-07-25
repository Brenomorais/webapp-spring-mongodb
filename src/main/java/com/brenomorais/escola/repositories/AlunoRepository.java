package com.brenomorais.escola.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brenomorais.escola.models.Aluno;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

@Repository
public class AlunoRepository {

	@Autowired
	private ConnectionDataBase conexao;

	public void salvar(Aluno aluno) {
		conexao.CreateConnection();
		MongoCollection<Aluno> alunos = this.conexao.getMongoDataBase().getCollection("alunos", Aluno.class);
		alunos.insertOne(aluno);
	}

	public List<Aluno> obterTodosAlunos() {

		conexao.CreateConnection();
		MongoCollection<Aluno> alunos = this.conexao.getMongoDataBase().getCollection("alunos", Aluno.class);

		MongoCursor<Aluno> resultado = alunos.find().iterator();

		List<Aluno> alunosEncontrados = new ArrayList<>();
		
		while (resultado.hasNext()) {
			
			Aluno aluno = resultado.next();
			alunosEncontrados.add(aluno);
		}

		return alunosEncontrados;
	}
}
