package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.dto.CurvePointDto;
import com.nnk.springboot.service.CurvePointService;
import com.nnk.springboot.utils.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller @Slf4j
@RequiredArgsConstructor
public class CurveController {
    private final CurvePointService curvePointService;

    @RequestMapping("/curvePoint/list")
    public String page(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size)
    {
        Page<CurvePoint> curvePointPage = this.curvePointService.getPage(PageRequest.of(page, size));
        model.addAttribute("curvePoints", curvePointPage);
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addCurvePointForm(Model model) {
        model.addAttribute("curvePoint",new CurvePoint());
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePointDto curvePointDto, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            this.curvePointService.save(curvePointDto);
            return this.page(model,0,10);
        }
        return "curvePoint/add";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        CurvePoint curvePoint = this.curvePointService.findById(id).orElseThrow(() -> new ServiceException(ErrorMessageConstants.CurvePointIdNotFound + " " + id));
        model.addAttribute("curvePoint", curvePoint);
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateCurvePoint(@Valid CurvePointDto curvePointDto, BindingResult result) {
        if(!result.hasErrors()){
            this.curvePointService.update(curvePointDto);
            return "redirect:/curvePoint/list";
        }
        return "/curvePoint/update";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteCurvePoint(@PathVariable("id") Integer id) {
        this.curvePointService.delete(id);
        return "redirect:/curvePoint/list";
    }
}
