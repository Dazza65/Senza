package me.darrenharris.senza.service;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.Block;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;

import org.bson.Document;

import me.darrenharris.senza.domain.Song;

/**
 * SongService
 */
public class SongService {
    
    SingleResultCallback<Void> callbackWhenFinished = new SingleResultCallback<Void>() {
        @Override
        public void onResult(final Void result, final Throwable t) {
            System.out.println("Operation Finished!");
        }
    };

    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            System.out.println(document.toJson());
        }
    };

    public List<Song> findStartsWith(String expString) {
        List<Song> results = new ArrayList<>();

        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("music");
        MongoCollection<Document> collection = database.getCollection("songs");

        collection.find(new Document()).
            forEach(printBlock, callbackWhenFinished);

        return results;
    }

    public SongService() {
    }
}