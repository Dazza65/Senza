package me.darrenharris.senza;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.containsString;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.junit.*;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

import org.glassfish.grizzly.http.server.HttpServer;

/**
 * HeartbeatTest
 */
public class HeartbeatTest {

    private HttpServer server;
    private WebTarget target;

    @BeforeClass
    public static void init() throws Exception {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void testHeartbeat() {
        RestAssured.registerParser("text/plain", Parser.TEXT);
        get("Senza/rest/heartbeat").then()
            .body( containsString("Hello Jersey"));
    }
}