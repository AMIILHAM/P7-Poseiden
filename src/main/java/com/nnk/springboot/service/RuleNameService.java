package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RuleNameService {
    Optional<RuleName> findById(Integer ruleNameId);
    Page<RuleName> getPage(Pageable pageable);

    RuleName save(RuleName ruleName);
    RuleName update(RuleName ruleName);
    void delete(Integer ruleNameId);
}
