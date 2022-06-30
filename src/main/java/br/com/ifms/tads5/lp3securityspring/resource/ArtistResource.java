package br.com.ifms.tads5.lp3securityspring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifms.tads5.lp3securityspring.javabeans.Artist;
import br.com.ifms.tads5.lp3securityspring.service.ArtistService;

@RestController
@RequestMapping(value = "/api/artist")
public class ArtistResource {

    @Autowired
    ArtistService artistService;
    

    @GetMapping(value = "/list")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public List<Artist> listAll() {
        return artistService.listAllArtists();
    }


    @GetMapping(value = "/save")
    @PreAuthorize(value = "hasRole('USER')")
    public Artist saveArtist(@RequestBody Artist artist) {
        return artistService.saveArtist(artist);
    }

    
    @GetMapping(value = "/get")
    @PreAuthorize(value = "hasRole('ADMIN')")
    @ResponseBody
    public Artist getArtistById(@RequestParam long id){ 
		return artistService.findArtistById(id);
	}


    @GetMapping(value = "/delete")
    @PreAuthorize(value = "hasRole('USER')")
    @ResponseBody
    public String deleteArtistById(@RequestParam long id) {
        if (artistService.findArtistById(id) != null) {
            artistService.deleteArtist(id);
            return "This artist has been deleted!";
        }
        else {
            return "There is no artist with this id!";
        }
    }


    @GetMapping(value ="/update")
    @PreAuthorize(value = "hasRole('USER')")
    public Artist updateArtist(@RequestBody Artist artist) {
        return artistService.updateArtist(artist);
    }
}
