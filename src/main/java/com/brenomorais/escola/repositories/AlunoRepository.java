package com.brenomorais.escola.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brenomorais.escola.models.Aluno;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

@Repository
public class AlunoRepository {

	@Autowired
	private ConnectionDataBase conexao;

	public void salvar(Aluno aluno) {
		conexao.CreateConnection();
		MongoCollection<Aluno> alunos = this.conexao.getMongoDataBase().getCollection("alunos", Aluno.class);
		
		if(aluno.getId() == null) {
			alunos.insertOne(aluno);
		}else {
			alunos.updateOne(Filters.eq("_id", aluno.getId()), new Document("$set", aluno));
		}
		
		conexao.getMongoClient().close();
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
	
	public Aluno obterAlunoPor(String id) {

		conexao.CreateConnection();

		MongoCollection<Aluno> alunos = this.conexao.getMongoDataBase().getCollection("alunos", Aluno.class);
		Aluno aluno = alunos.find(Filters.eq("_id", new ObjectId(id))).first();
		
		return aluno;
	}
}
