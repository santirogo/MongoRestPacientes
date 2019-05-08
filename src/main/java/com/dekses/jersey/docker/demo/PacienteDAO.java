/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dekses.jersey.docker.demo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author white
 */
public class PacienteDAO {
 
    public static Paciente addPaciente(Paciente pac) {
        try{
            MongoCredential credential = MongoCredential.createCredential("administrator", "admin", "mypassword".toCharArray());
            
            MongoClient mongoClient = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credential));
            
            DB db = mongoClient.getDB("admin");
            
            DBCollection coll = db.getCollection("pacientes");
            
            DBObject doc = new BasicDBObject("id", pac.getId()).append("nombre", pac.getNombre()).append("apellido", pac.getApellido()).append("fechaNac", pac.getFechaNac()).append("direccion", pac.getDireccion()).append("tel", pac.getTel()).append("medNum", pac.getMedNum()).append("estado", pac.getEstado());
            
            coll.insert(doc);
            

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
        return pac;
    }
 
    public static Paciente updatePaciente(Paciente pac) {
        try {
            
            MongoCredential credential = MongoCredential.createCredential("administrator", "admin", "mypassword".toCharArray());

            MongoClient mongoClient = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credential));

            DB db = mongoClient.getDB("admin");

            DBCollection coll = db.getCollection("pacientes");
            BasicDBObject newDocument = new BasicDBObject();
            
            newDocument.put("id",pac.getId());
            newDocument.put("nombre",pac.getNombre());
            newDocument.put("apellido",pac.getApellido());
            newDocument.put("fechaNac",pac.getFechaNac());
            newDocument.put("direccion",pac.getDireccion());
            newDocument.put("tel",pac.getTel());
            newDocument.put("medNum",pac.getMedNum());
            newDocument.put("estado",pac.getEstado());
            
            DBObject searchQuery = new BasicDBObject().append("id", pac.getId());
            coll.update(searchQuery, newDocument);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
        return pac;
    }
 
    public static void deletePaciente(String pNo) {
        try {
            System.out.println("delete!");
            MongoCredential credential = MongoCredential.createCredential("administrator", "admin", "mypassword".toCharArray());

            MongoClient mongoClient = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credential));

            DB db = mongoClient.getDB("admin");
            DBCollection coll = db.getCollection("pacientes");
            DBObject doc = new BasicDBObject();
            doc.put("id", pNo);
            System.out.println("doc: "+doc);
            coll.remove(doc);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
    }
 
    public static List<Paciente> getAllPacientes() {
        List<Paciente> list = new ArrayList<Paciente>();
        
        try {
            
            MongoCredential credential = MongoCredential.createCredential("administrator","admin", "mypassword".toCharArray());

            MongoClient mongoClient = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credential));

            DB db = mongoClient.getDB("admin");

            DBCollection coll = db.getCollection("pacientes");

            DBCursor cursor = coll.find();
            try {
                while (cursor.hasNext()) {
                    DBObject object = cursor.next();
                    String id = object.get("id").toString();
                    String nombre = object.get("nombre").toString();
                    String apellido = object.get("apellido").toString();
                    String fechaNac = object.get("fechaNac").toString();
                    String direccion = object.get("direccion").toString();
                    String tel = object.get("tel").toString();
                    String medNum = object.get("medNum").toString();
                    String estado = object.get("estado").toString();
                    Paciente p = new Paciente(id, nombre, apellido, fechaNac, direccion, tel, medNum, estado);
                    list.add(p);
                    System.out.println(object);
                }
            } finally {
                cursor.close();
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
        
        return list;
    }
     
    List<Paciente> list;
}
