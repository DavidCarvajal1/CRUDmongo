package org.example.DAL;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

public class CRUD {
    private static MongoDatabase database;
    public static void abrirConexion(){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://dcarvajal:sexo@cluster0.x9qmrab.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();

        MongoClient mongoClient = MongoClients.create(settings);
         database = mongoClient.getDatabase("Prueba");
    }
    public static void insertarAlumno(String nombre, String apellido){
        database.getCollection("Alumnos").insertOne(new Document().append("nombre",nombre).append("apellidos",apellido));
    }
    public static void modificar(String antes, String despues){
        Document query=new Document().append("nombre",antes);
        Bson updates= Updates.combine(
                Updates.set("nombre",despues),
                Updates.currentTimestamp("lastUpdate")
        )
    }
}
