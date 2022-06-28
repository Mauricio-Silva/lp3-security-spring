package br.com.ifms.tads5.lp3securityspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifms.tads5.lp3securityspring.javabeans.Rule;
import br.com.ifms.tads5.lp3securityspring.repository.RuleRepository;
import br.com.ifms.tads5.lp3securityspring.service.interfaces.RuleServiceInterface;

@Service
public class RuleService implements RuleServiceInterface {
    
    @Autowired
    RuleRepository ruleRepository;


    @Override
    public Rule saveRule(Rule rule) {
        return ruleRepository.save(rule);
    }


    @Override
    public void deleteRule(long id) {
        ruleRepository.deleteById(id);;
    }


    @Override
    public Rule updateRule(Rule rule) {
        return ruleRepository.save(rule);
    }


    @Override
    public Rule findRuleById(long id) {
        return ruleRepository.findById(id);
    }


    @Override
    public List<Rule> listAllRules() {
        return ruleRepository.findAll();
    }
}
