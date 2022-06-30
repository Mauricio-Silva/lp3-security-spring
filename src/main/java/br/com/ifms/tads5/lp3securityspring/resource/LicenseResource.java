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

import br.com.ifms.tads5.lp3securityspring.javabeans.License;
import br.com.ifms.tads5.lp3securityspring.service.LicenseService;

@RestController
@RequestMapping(value = "/api/license")
public class LicenseResource {
    
    @Autowired
    LicenseService licenseService;


    @GetMapping(value = "/list")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public List<License> listAll() {
        return licenseService.listAllLicenses();
    }
    
    
    @GetMapping(value = "/save")
    @PreAuthorize(value = "hasRole('USER')")
    public License saveLicense(@RequestBody License license) {
        return licenseService.saveLicense(license);
    }
    

    @GetMapping(value = "/get")
    @PreAuthorize(value = "hasRole('ADMIN')")
    @ResponseBody
    public License getLicenseById(@RequestParam long id){ 
		return licenseService.findLicenseById(id);
	}


    @GetMapping(value = "/{ownername}")
    public License getLicenseByOwnerName(@PathVariable String ownername){ 
        return licenseService.findLicenseByOwnerName(ownername);
    }
    

    @GetMapping(value = "/delete")
    @PreAuthorize(value = "hasRole('USER')")
    @ResponseBody
    public String deleteLicenseById(@RequestParam long id) {
        if (licenseService.findLicenseById(id) != null) {
            licenseService.deleteLicense(id);
            return "This license has been deleted!";
        }
        else {
            return "There is no license with this id!";
        }
    }


    @GetMapping(value = "/update")
    @PreAuthorize(value = "hasRole('USER')")
    public License updateLicense(@RequestBody License license) {
        return licenseService.updateLicense(license);
    }
}
