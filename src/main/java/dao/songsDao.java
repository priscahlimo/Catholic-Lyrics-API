package dao;

import models.Songs;

import java.util.List;

public interface songsDao {
    //implement CRUD

    //create

    void add(Songs songs);

    //read

    Songs findById(int id);
    List<Songs> allSongs();

    //update

//    void updateSongsCount(Songs songs);

    //delete
    void deleteSongsById(int id);
    void deleteAll();
}
