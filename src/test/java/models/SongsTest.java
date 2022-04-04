package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SongsTest {

    private Songs newSong(){
        return new Songs("pokea sifa","zilipendwa","Sauti Tamu","Nitakwenda mimi mwenyewe",1);
    }

    @Test
    public void initializeCorrectly(){
        Songs songs = newSong();
        assertTrue(songs instanceof Songs);
    }

    @Test
    public void getMethodsWorkCorrectly(){
        Songs songs = newSong();
        assertEquals("pokea sifa",songs.getSong());
        assertEquals("zilipendwa",songs.getAlbum());
        assertEquals("Sauti Tamu",songs.getChoir());
        assertEquals("Nitakwenda mimi mwenyewe",songs.getLyrics());
        assertEquals(1,songs.getId());
    }
}