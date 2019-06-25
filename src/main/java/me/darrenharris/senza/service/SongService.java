package me.darrenharris.senza.service;

import static com.mongodb.client.model.Filters.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import me.darrenharris.senza.domain.Song;

/**
 * SongService
 */
public class SongService {

    private static final Logger LOGGER = LogManager.getLogger(SongService.class.getName());
    private Song song;

    public List<Song> findTitleStartsWith(String expString) {
        List<Song> results = new ArrayList<>();
        Gson gson = new GsonBuilder().create();

        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("music");
        MongoCollection<Document> collection = database.getCollection("songs");

        String pattern = "^" + expString;

        LOGGER.debug("Performing find for title: " + pattern);
        collection.find(regex("title", pattern)).
            forEach( (Consumer<Document>) doc -> {
                this.song = gson.fromJson(doc.toJson(), Song.class);
                LOGGER.debug("Got result: " + this.song.getTitle());
                results.add(song);
            });

        LOGGER.debug("return results: " + results.size());
        return results;
    }

    public SongService() {
    }
}