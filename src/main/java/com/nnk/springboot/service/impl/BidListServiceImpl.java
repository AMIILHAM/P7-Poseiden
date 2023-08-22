package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.service.BidListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BidListServiceImpl implements BidListService {

    private final BidListRepository bidListRepository;

    @Override
    public Optional<BidList> findById(Integer id) {
        return this.bidListRepository.findById(id);
    }

    @Override
    public Page<BidList> getAllBidList(Pageable pageable) {
        return bidListRepository.findAll(pageable);
    }

    @Override
    public BidList save(BidList bidList) {
        return this.bidListRepository.save(bidList);
    }

    @Override
    public BidList update(BidList bidList) {
        return this.save(bidList);
    }

    @Override
    public void delete(Integer bidListId) {
        this.findById(bidListId).ifPresent(bidList -> this.bidListRepository.deleteById(bidList.getBidListId()));
    }
}
