package br.com.ifms.tads5.lp3securityspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifms.tads5.lp3securityspring.javabeans.Artwork;
import br.com.ifms.tads5.lp3securityspring.repository.ArtworkRepository;
import br.com.ifms.tads5.lp3securityspring.service.interfaces.ArtworkServiceInterface;

@Service
public class ArtworkService implements ArtworkServiceInterface {
    
    @Autowired
    ArtworkRepository artworkRepository;


    @Override
    public Artwork saveArtwork(Artwork artwork) {
        return artworkRepository.save(artwork);
    }


    @Override
    public void deleteArtwork(long id) {
        artworkRepository.deleteById(id);
    }


    @Override
    public Artwork updateArtwork(Artwork artwork) {
        return artworkRepository.save(artwork);
    }


    @Override
    public Artwork findArtworkById(long id) {
        return artworkRepository.findById(id);
    }


    @Override
    public Artwork findArtworkByName(String name) {
        return artworkRepository.findByName(name);
    }


    @Override
    public List<Artwork> listAllArtworks() {
        return artworkRepository.findAll();
    }
}
