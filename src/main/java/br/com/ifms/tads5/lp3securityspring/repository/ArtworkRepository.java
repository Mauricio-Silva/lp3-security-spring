package br.com.ifms.tads5.lp3securityspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.tads5.lp3securityspring.javabeans.Artwork;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
    
    Artwork findById(long id);

    Artwork findByName(String name);
}
