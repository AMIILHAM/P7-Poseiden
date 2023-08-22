package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TradeService {
    Optional<Trade> findById(Integer tradeId);
    Page<Trade> getPage(Pageable pageable);

    Trade save(Trade trade);

    void delete(Integer tradeId);
}
