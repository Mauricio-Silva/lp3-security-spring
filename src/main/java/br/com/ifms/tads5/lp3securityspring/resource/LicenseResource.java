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
    

    @GetMapping(value = "/message")
    public String showMessage() {
        return "Free access to everybody!";
    }


    @GetMapping(value = "/listAll")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public List<License> listAll() {
        return licenseService.listAllLicenses();
    }
    
    
    @GetMapping(value = "/save")
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    public License saveLicense(@RequestBody License license) {
        return licenseService.saveLicense(license);
    }
    

    @GetMapping(value = "/")
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
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    @ResponseBody
    public String deleteLicenseById(@RequestParam long id) {
        licenseService.deleteLicense(id);
        return "This license has been deleted!";
    }


    @GetMapping(value = "/update")
    @PreAuthorize(value = "hasRole('ARTIST', 'ADMIN')")
    public License updateLicense(@RequestBody License license) {
        return licenseService.updateLicense(license);
    }
}
