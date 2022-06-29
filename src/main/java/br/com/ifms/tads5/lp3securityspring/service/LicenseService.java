package br.com.ifms.tads5.lp3securityspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifms.tads5.lp3securityspring.javabeans.License;
import br.com.ifms.tads5.lp3securityspring.repository.LicenseRepository;
import br.com.ifms.tads5.lp3securityspring.service.interfaces.LicenseServiceInterface;

@Service
public class LicenseService implements LicenseServiceInterface {
    
    @Autowired
    LicenseRepository licenseRepository;


    @Override
    public License saveLicense(License license) {
        return licenseRepository.save(license);
    }


    @Override
    public void deleteLicense(long id) {
        licenseRepository.deleteById(id);
    }


    @Override
    public License updateLicense(License license) {
        return licenseRepository.save(license);
    }


    @Override
    public License findLicenseById(long id) {
        return licenseRepository.findById(id);
    }


    @Override
    public License findLicenseByOwnerName(String ownerName) {
        return licenseRepository.findByOwnerName(ownerName);
    }


    @Override
    public List<License> listAllLicenses() {
        return licenseRepository.findAll();
    }
}
