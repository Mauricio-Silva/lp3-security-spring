package br.com.ifms.tads5.lp3securityspring.service.interfaces;

import java.util.List;

import br.com.ifms.tads5.lp3securityspring.javabeans.Rule;

public interface RuleServiceInterface {
    
    Rule saveRule(Rule rula);

    void deleteRule(long id);

    Rule updateRule(Rule rule);

    Rule findRuleById(long id);

    List<Rule> listAllRules();
}
