package me.darrenharris.senza;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import me.darrenharris.senza.domain.Song;
import me.darrenharris.senza.service.SongService;

/**
 * SongRest
 */
@Path("/song")
public class SongRest {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPlainSongs(@QueryParam("startTitle") String startTitle) {
        SongService service = new SongService();

        List<Song> results = service.findTitleStartsWith(startTitle);

        StringBuffer resultStrBuf = new StringBuffer();
        Gson gson = new GsonBuilder().create();

        resultStrBuf.append("[");

        for (Song song : results) {
            resultStrBuf.append(gson.toJson(song, Song.class) + ",");
        }

        resultStrBuf.deleteCharAt(resultStrBuf.length()-1);

        resultStrBuf.append("]");

        return resultStrBuf.toString();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtmlSongs(@QueryParam("startTitle") String startTitle) {
        SongService service = new SongService();

        List<Song> results = service.findTitleStartsWith(startTitle);

        StringBuffer resultStrBuf = new StringBuffer();

        resultStrBuf.append("<html><body><h2>Songs</h2><table><th>Title</th><th>Artist</th>");

        for (Song song : results) {
            resultStrBuf.append("<tr>");
            resultStrBuf.append("<td>" + song.getTitle() + "</td><td>" + song.getArtist() + "</td>");
            resultStrBuf.append("</tr>");
        }

        resultStrBuf.append("</table></body></html>");

        return resultStrBuf.toString();
    }

}