package me.darrenharris.senza;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.darrenharris.senza.domain.Song;
import me.darrenharris.senza.service.SongService;

/**
 * SongRest
 */
@Path("/song")
public class SongRest {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "Hello Jersey";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        SongService service = new SongService();

        List<Song> results = service.findStartsWith("Run");

        StringBuffer resultStrBuf = new StringBuffer();

        resultStrBuf.append("<html><body><h1>Songs</h1><table><th>Title</th><th>Artist</th>");

        for (Song song : results) {
            resultStrBuf.append("<tr>");
            resultStrBuf.append("<td>" + song.getTitle() + "</td><td>" + song.getArtist() + "</td>");
            resultStrBuf.append("</tr>");
        }

        return("</table></body></html>");
    }

}