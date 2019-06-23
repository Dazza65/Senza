package me.darrenharris.senza;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.*;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

/**
 * HeartbeatTest
 */
public class HeartbeatTest {

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