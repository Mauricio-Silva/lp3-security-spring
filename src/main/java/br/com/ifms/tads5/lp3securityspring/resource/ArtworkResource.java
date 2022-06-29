package br.com.ifms.tads5.lp3securityspring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifms.tads5.lp3securityspring.javabeans.Artwork;
import br.com.ifms.tads5.lp3securityspring.service.ArtworkService;

@RestController
@RequestMapping(value = "/api/artwork")
public class ArtworkResource {
    
    @Autowired
    ArtworkService artworkService;


    @GetMapping(value = "/message")
    public String showMessage() {
        return "Free access to everybody!";
    }


    @GetMapping(value = "/listAll")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public List<Artwork> listAll() {
        return artworkService.listAllArtworks();
    }
    
    
    @GetMapping(value = "/save")
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    public Artwork saveArtwork(@RequestBody Artwork artwork) {
        return artworkService.saveArtwork(artwork);
    }
    

    @GetMapping(value = "/")
    @PreAuthorize(value = "hasRole('ADMIN')")
    @ResponseBody
    public Artwork getArtistById(@RequestParam long id){ 
		return artworkService.findArtworkById(id);
	}


    @GetMapping(value = "/{name}")
    public Artwork getArtistByName(@PathVariable String name){ 
        return artworkService.findArtworkByName(name);
    }
    

    @GetMapping(value = "/delete")
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    @ResponseBody
    public String deleteArtworkById(@RequestParam long id) {
        artworkService.deleteArtwork(id);
        return "This artwork has been deleted!";
    }


    @GetMapping(value = "/update")
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    public Artwork updateArtwork(@RequestBody Artwork artwork) {
        return artworkService.updateArtwork(artwork);
    }
}
