import com.google.gson.Gson;
import dao.DB;
import dao.songsImplementationDao;
import models.Songs;
import org.sql2o.Connection;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

    public static void main(String[] args){

        port(getHerokuAssignedPort());


        songsImplementationDao songsDao;
        Gson gson = new Gson();
        Connection conn;

        songsDao = new songsImplementationDao(DB.sql2o);


        get("/", (request, response) -> {

            Map<String, Object> models = new HashMap<>();
            models.put("View all songs", "/songs");
            return gson.toJson(models);
        });


        post("/songs/new", "application/json", (request, response) -> {
            Songs songs = gson.fromJson(request.body(), Songs.class);
            songsDao.add(songs);
            response.status(201);
            return gson.toJson(songs);
        });

        //READ

        get("/songs", "application/json", (request, response) -> gson.toJson(songsDao.allSongs()));

   //UPDATE

        get("/songs/:id", "application/json", (req, res) -> {
            int songsId = Integer.parseInt(req.params("id"));
            return gson.toJson(songsDao.findById(songsId));
        });

        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });

    }

}
