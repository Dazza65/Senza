package me.darrenharris.senza.service;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import me.darrenharris.senza.domain.Song;

/**
 * SongService
 */
public class SongService {

    public List<Song> findStartsWith(String expString) {
        List<Song> results = new ArrayList<>();
        Gson gson = new GsonBuilder().create();

        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("music");
        MongoCollection<Document> collection = database.getCollection("songs");

        Document doc = collection.find(eq("title", "Run a Mile")).first();

        Song song = gson.fromJson(doc.toJson(), Song.class);

        results.add(song);

        return results;
    }

    public SongService() {
    }
}