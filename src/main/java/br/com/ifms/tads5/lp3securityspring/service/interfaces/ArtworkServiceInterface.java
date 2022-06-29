package br.com.ifms.tads5.lp3securityspring.service.interfaces;

import java.util.List;

import br.com.ifms.tads5.lp3securityspring.javabeans.Artwork;

public interface ArtworkServiceInterface {
    
    Artwork saveArtwork(Artwork artwork);

    void deleteArtwork(long id);

    Artwork updateArtwork(Artwork artwork);

    Artwork findArtworkById(long id);

    Artwork findArtworkByName(String name);

    List<Artwork> listAllArtworks();
}
