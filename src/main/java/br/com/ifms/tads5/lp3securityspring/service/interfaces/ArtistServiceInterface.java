package br.com.ifms.tads5.lp3securityspring.service.interfaces;

import java.util.List;

import br.com.ifms.tads5.lp3securityspring.javabeans.Artist;

public interface ArtistServiceInterface {
    
    Artist saveArtist(Artist artist);

    void deleteArtist(long id);

    Artist updateArtist(Artist artist);

    Artist findArtistById(long id);

    List<Artist> listAllArtists();
}
