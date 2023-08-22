package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BidListService {

    Optional<BidList> findById(Integer id);
    Page<BidList> getAllBidList(Pageable pageable);

    BidList save(BidList bidList);

    BidList update(BidList bidList);

    void delete(Integer bidListId);
}
