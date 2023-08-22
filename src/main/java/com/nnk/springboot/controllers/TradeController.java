package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class TradeController {

    private final TradeService tradeService;

    @RequestMapping("/trade/list")
    public String page(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size )
    {
        Page<Trade> trades = this.tradeService.getPage(PageRequest.of(page,size));
        model.addAttribute("trades", trades);
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Model model) {
        model.addAttribute("trade", new Trade());
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        if(!result.hasErrors()){
            this.tradeService.save(trade);
            return page(model,0,10);
        }
        return "trade/add";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("trade", this.tradeService.findById(id).orElseThrow());
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@Valid Trade trade, BindingResult result, Model model) {
        if(!result.hasErrors()){
            this.tradeService.save(trade);
            return page(model,0,10);
        }
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id) {
        this.tradeService.delete(id);
        return "redirect:/trade/list";
    }
}
