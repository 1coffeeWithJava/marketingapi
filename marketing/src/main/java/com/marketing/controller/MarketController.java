package com.marketing.controller;

import com.marketing.payload.MarketDto;
import com.marketing.service.MarketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dummyjson/products")
public class MarketController {

    private MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostMapping
    public ResponseEntity<MarketDto> createMarket(@RequestBody MarketDto marketDto){
        MarketDto marketDto1 = marketService.createMarket(marketDto);
        return new ResponseEntity<>(marketDto1, HttpStatus.CREATED);
    }

    @GetMapping
    public List<MarketDto> getAllMarketDetails(
            @RequestParam(value = "pageNo", defaultValue = "0",required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ){
        List<MarketDto> allDetails = marketService.getAllDetails(pageNo,pageSize);
        return allDetails;
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarketDto> updateMarket(@RequestBody MarketDto marketDto, @PathVariable("id") long id){
        MarketDto dto = marketService.updateMarket(marketDto, id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMarket(@PathVariable("id") long id){
        marketService.deleteMarket(id);
        return new ResponseEntity<>("Record deleted successfully", HttpStatus.OK);
    }
}
