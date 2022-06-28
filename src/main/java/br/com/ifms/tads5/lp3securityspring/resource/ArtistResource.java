package br.com.ifms.tads5.lp3securityspring.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifms.tads5.lp3securityspring.javabeans.Artist;
import br.com.ifms.tads5.lp3securityspring.service.ArtistService;

@RestController
@RequestMapping(value = "/api/artist")
public class ArtistResource {

    @Autowired
    ArtistService artistService;


    @GetMapping(value = "/message")
    @PreAuthorize(value = "hasRole('USER')")
    public String show_message() {
        return "Hello, World!";
    }
    

    @GetMapping(value = "/save")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public Artist saveArtist(@RequestBody Artist artist) {
        return artistService.saveArtist(artist);
    }

    
    @GetMapping(value = "/{id}")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public Artist getArtistById(@PathVariable long id){ 
		return artistService.findArtistById(id);
	}
}
