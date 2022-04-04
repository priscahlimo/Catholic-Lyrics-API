package dao;

import models.Songs;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class songsImplementationDao implements songsDao {

    private final Sql2o sql2o;
    public songsImplementationDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(Songs songs) {
        String sql = "INSERT INTO songs (song, album, choir, lyrics) VALUES (:song, :album, :choir, :lyrics)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(songs)
                    .executeUpdate()
                    .getKey();
            songs.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Songs findById(int id) {
        String sql = "SELECT * from songs WHERE id=:id;";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Songs.class);
        }
    }

    @Override
    public List<Songs> allSongs() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM songs")
                    .executeAndFetch(Songs.class);
        }
    }

//    @Override
//    public void updateSongsCount(Songs songs){
//
//    }

    @Override
    public void deleteSongsById(int id) {
        String sql = "DELETE from songs WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void deleteAll() {
        String sql = "DELETE from songs";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }






}
