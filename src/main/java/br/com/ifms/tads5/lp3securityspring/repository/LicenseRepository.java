package br.com.ifms.tads5.lp3securityspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.tads5.lp3securityspring.javabeans.License;

public interface LicenseRepository extends JpaRepository<License, Long> {
    
    License findById(long id);

    License findByOwnername(String ownername);
}
