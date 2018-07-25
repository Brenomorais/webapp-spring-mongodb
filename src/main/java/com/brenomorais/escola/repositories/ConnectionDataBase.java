package com.brenomorais.escola.repositories;

import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.stereotype.Component;

import com.brenomorais.escola.codec.AlunoCodec;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;

@Component	
public class ConnectionDataBase {
	
	private MongoClient mongoClient;
	private MongoDatabase mongoDataBase;
	
	private String local = "localhost:27017";
	private String dataBase = "test";
	
	public void CreateConnection() {		
		try 
		{
		  Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);

		  AlunoCodec alunoCodec = new AlunoCodec(codec);

		  //codec para codificar e decodificar
		  CodecRegistry registro = CodecRegistries.fromRegistries(
		      MongoClient.getDefaultCodecRegistry(), 
		      CodecRegistries.fromCodecs(alunoCodec));
		
		  MongoClientOptions options = MongoClientOptions.builder().codecRegistry(registro).build();

		  mongoClient = new MongoClient(local, options);
		  setMongoDataBase(mongoClient.getDatabase(dataBase));
		  
		}catch(Exception e) {
			System.out.println("Erro connection database mongodb!: " + e);
		}
		
	}

	public MongoDatabase getMongoDataBase() {
		return mongoDataBase;
	}

	public void setMongoDataBase(MongoDatabase mongoDataBase) {
		this.mongoDataBase = mongoDataBase;
	}

	public ConnectionDataBase(MongoClient mongoClient) {
		super();
		this.mongoClient = mongoClient;
	}
	
}
