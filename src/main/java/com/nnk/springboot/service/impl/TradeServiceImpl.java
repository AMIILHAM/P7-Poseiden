package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TradeServiceImpl implements TradeService {

    private final TradeRepository tradeRepository;

    @Override
    public Optional<Trade> findById(Integer tradeId) {
        return this.tradeRepository.findById(tradeId);
    }

    @Override
    public Page<Trade> getPage(Pageable pageable) {
        return this.tradeRepository.findAll(pageable);
    }

    @Override
    public Trade save(Trade trade) {
        return this.tradeRepository.save(trade);
    }

    @Override
    public void delete(Integer tradeId) {
        this.findById(tradeId).ifPresent(trade -> this.tradeRepository.deleteById(trade.getTradeId()));
    }
}
