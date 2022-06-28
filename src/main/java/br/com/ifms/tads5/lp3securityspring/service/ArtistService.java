package br.com.ifms.tads5.lp3securityspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifms.tads5.lp3securityspring.javabeans.Artist;
import br.com.ifms.tads5.lp3securityspring.repository.ArtistRepository;
import br.com.ifms.tads5.lp3securityspring.service.interfaces.ArtistServiceInterface;

@Service
public class ArtistService implements ArtistServiceInterface {
    
    @Autowired
    ArtistRepository artistRepository;


    @Override
    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }


    @Override
    public void deleteArtist(long id) {
        artistRepository.deleteById(id);
    }


    @Override
    public Artist updateArtist(Artist artist) {
        return artistRepository.save(artist);
    }


    @Override
    public Artist findArtistById(long id) {
        return artistRepository.findById(id);
    }


    @Override
    public List<Artist> listAllArtists() {
        return artistRepository.findAll();
    }
}
