package br.com.ifms.tads5.lp3securityspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.tads5.lp3securityspring.javabeans.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    
    Artist findById(long id);
}
