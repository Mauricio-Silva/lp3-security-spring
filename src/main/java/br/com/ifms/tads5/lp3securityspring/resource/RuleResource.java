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

import br.com.ifms.tads5.lp3securityspring.javabeans.Rule;
import br.com.ifms.tads5.lp3securityspring.service.RuleService;

@RestController
@RequestMapping(value = "/api/rule")
public class RuleResource {
    
    @Autowired
    RuleService ruleService;


    @GetMapping(value = "/listAll")
    @PreAuthorize(value = "hasRole('USER')")
    public List<Rule> listAllRules() {
        return ruleService.listAllRules();
    }
    
    
    @GetMapping(value = "/save")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public Rule saveRule(@RequestBody Rule rule) {
        return ruleService.saveRule(rule);
    }
    
    
    @GetMapping(value = "/delete")
    @PreAuthorize(value = "hasRole('ADMIN')")
    @ResponseBody
    public String deleteRule(@RequestParam long id) {
        ruleService.deleteRule(id);
        return "This Rule was successfully deleted.";
    }
}
