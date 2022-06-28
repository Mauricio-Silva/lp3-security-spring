package br.com.ifms.tads5.lp3securityspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.tads5.lp3securityspring.javabeans.Rule;

public interface RuleRepository extends JpaRepository<Rule, Long> {
    
    Rule findById(long id);
}
