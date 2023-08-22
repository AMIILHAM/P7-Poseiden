package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.BidListService;
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
public class BidListController {

    private final BidListService bidListService;

    @RequestMapping("/bidList/list")
    public String page(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size)
    {
        Page<BidList> bidLists = this.bidListService.getAllBidList(PageRequest.of(page, size));
        model.addAttribute("bidLists",bidLists);
        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(Model model) {
        model.addAttribute("bidList", new BidList());
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bid, BindingResult result, Model model) {
        if(!result.hasErrors()){
            this.bidListService.save(bid);
            return this.page(model,0,10);
        }
        return "bidList/add";
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("bidList", this.bidListService.findById(id).orElseThrow());
        return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@Valid BidList bidList, BindingResult result, Model model) {
        if(!result.hasErrors()){
            this.bidListService.update(bidList);
            return this.page(model,0,10);
        }
        return "bidList/update";
    }

    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id) {
        this.bidListService.delete(id);
        return "redirect:/bidList/list";
    }
}
