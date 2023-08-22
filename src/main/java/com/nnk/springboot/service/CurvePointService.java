package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.dto.CurvePointDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CurvePointService {
    Optional<CurvePoint> findById(Integer id);
    Page<CurvePoint> getPage(Pageable pageable);
    CurvePoint save(CurvePointDto curvePointDto);

    CurvePoint update(CurvePointDto curvePointDto);

    void delete(Integer curvePointId);
}
