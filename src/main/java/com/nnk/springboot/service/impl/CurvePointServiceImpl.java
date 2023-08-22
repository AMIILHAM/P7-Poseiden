package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.dto.CurvePointDto;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.service.CurvePointService;
import com.nnk.springboot.utils.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurvePointServiceImpl implements CurvePointService {

    private final CurvePointRepository curvePointRepository;

    @Override
    public Optional<CurvePoint> findById(Integer id) {
        return this.curvePointRepository.findById(id);
    }

    @Override
    public Page<CurvePoint> getPage(Pageable pageable) {
        return this.curvePointRepository.findAll(pageable);
    }

    @Override
    public CurvePoint save(CurvePointDto curvePointDto) {

        CurvePoint curvePoint = new CurvePoint();
        curvePoint.setTerm(curvePointDto.getTerm());
        curvePoint.setValue(curvePointDto.getValue());
        curvePoint.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        curvePoint.setAsOfDate(Timestamp.valueOf(LocalDateTime.now()));

        return this.curvePointRepository.save(curvePoint);
    }

    @Override
    public CurvePoint update(CurvePointDto curvePointDto) {
        CurvePoint curvePoint = this.findById(curvePointDto.getId()).orElseThrow(() -> new ServiceException(ErrorMessageConstants.CurvePointIdNotFound));
        curvePoint.setTerm(curvePointDto.getTerm());
        curvePoint.setValue(curvePointDto.getValue());
        return this.curvePointRepository.save(curvePoint);
    }

    @Override
    public void delete(Integer curvePointId) {
        this.findById(curvePointId).ifPresent(curvePoint -> this.curvePointRepository.deleteById(curvePoint.getId()));
    }
}
