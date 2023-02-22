package com.marketing.service.impl;

import com.marketing.entity.Market;
import com.marketing.payload.MarketDto;
import com.marketing.repository.MarketRepository;
import com.marketing.service.MarketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarketServiceImpl implements MarketService {

    private MarketRepository marketRepo;

    public MarketServiceImpl(MarketRepository marketRepo) {
        this.marketRepo = marketRepo;
    }

    @Override
    public MarketDto createMarket(MarketDto marketDto) {
        Market market = mapToEntity(marketDto);
        Market postMarket = marketRepo.save(market);

        MarketDto dto = mapToDto(postMarket);
        return dto;
    }

    @Override
    public List<MarketDto> getAllDetails(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Market> all = marketRepo.findAll(pageable);
        List<Market> content = all.getContent();
      return content.stream().map(market1-> mapToDto(market1)).collect(Collectors.toList());
    }

    @Override
    public MarketDto updateMarket(MarketDto marketDto, long id) {
        Optional<Market> byId = marketRepo.findById(id);
        Market market = byId.get();
        market.setBrand(marketDto.getBrand());
        market.setCategory(marketDto.getCategory());
        market.setTitle(marketDto.getTitle());
        market.setStock(marketDto.getStock());
        market.setPrice(marketDto.getPrice());

        Market newMarket = marketRepo.save(market);
        return mapToDto(newMarket);
    }

    @Override
    public void deleteMarket(long id) {
        Optional<Market> byId = marketRepo.findById(id);
        Market market = byId.get();
        marketRepo.deleteById(id);
    }

    public Market mapToEntity(MarketDto marketDto) {
        Market market = new Market();
        market.setId(marketDto.getId());
        market.setBrand(marketDto.getBrand());
        market.setCategory(marketDto.getCategory());
        market.setTitle(marketDto.getTitle());
        market.setStock(marketDto.getStock());
        market.setPrice(marketDto.getPrice());

        return market;
    }

    public MarketDto mapToDto(Market market){
        MarketDto dto= new MarketDto();
        dto.setId(market.getId());
        dto.setBrand(market.getBrand());
        dto.setCategory(market.getCategory());
        dto.setTitle(market.getTitle());
        dto.setStock(market.getStock());
        dto.setPrice(market.getPrice());
        dto.setPrice(market.getPrice());
        return dto;
    }
}
