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


    @GetMapping(value = "/list")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public List<Artwork> listAll() {
        return artworkService.listAllArtworks();
    }
    
    
    @GetMapping(value = "/save")
    @PreAuthorize(value = "hasRole('USER')")
    public Artwork saveArtwork(@RequestBody Artwork artwork) {
        return artworkService.saveArtwork(artwork);
    }
    

    @GetMapping(value = "/get")
    @PreAuthorize(value = "hasRole('ADMIN')")
    @ResponseBody
    public Artwork getArtistById(@RequestParam long id){ 
		return artworkService.findArtworkById(id);
	}


    @GetMapping(value = "/{name}")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public Artwork getArtistByName(@PathVariable String name){ 
        return artworkService.findArtworkByName(name);
    }
    

    @GetMapping(value = "/delete")
    @PreAuthorize(value = "hasRole('USER')")
    @ResponseBody
    public String deleteArtworkById(@RequestParam long id) {
        if (artworkService.findArtworkById(id) != null) {
            artworkService.deleteArtwork(id);
            return "This artwork has been deleted!";
        }
        else {
            return "There is no artwork with this id!";
        }
    }


    @GetMapping(value = "/update")
    @PreAuthorize(value = "hasRole('USER')")
    public Artwork updateArtwork(@RequestBody Artwork artwork) {
        return artworkService.updateArtwork(artwork);
    }
}
