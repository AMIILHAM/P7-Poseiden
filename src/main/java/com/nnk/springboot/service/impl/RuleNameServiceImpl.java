package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.service.RuleNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RuleNameServiceImpl implements RuleNameService {

    private final RuleNameRepository ruleNameRepository;

    @Override
    public Optional<RuleName> findById(Integer ruleNameId) {
        return this.ruleNameRepository.findById(ruleNameId);
    }

    @Override
    public Page<RuleName> getPage(Pageable pageable) {
        return this.ruleNameRepository.findAll(pageable);
    }

    @Override
    public RuleName save(RuleName ruleName) {
        return this.ruleNameRepository.save(ruleName);
    }

    @Override
    public RuleName update(RuleName ruleName) {
        return this.save(ruleName);
    }

    @Override
    public void delete(Integer ruleNameId) {
        this.findById(ruleNameId).ifPresent(ruleName -> this.ruleNameRepository.deleteById(ruleName.getId()));
    }
}
