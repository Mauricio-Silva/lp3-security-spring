package br.com.ifms.tads5.lp3securityspring.service.interfaces;

import java.util.List;

import br.com.ifms.tads5.lp3securityspring.javabeans.License;

public interface LicenseServiceInterface {
    
    License saveLicense(License license);

    void deleteLicense(long id);

    License updateLicense(License license);

    License findLicenseById(long id);

    License findLicenseByOwnerName(String ownername);

    List<License> listAllLicenses();
}
