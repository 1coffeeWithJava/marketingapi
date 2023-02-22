package com.marketing.service;

import com.marketing.payload.MarketDto;

import java.util.List;

public interface MarketService {
    MarketDto createMarket(MarketDto marketDto);

    List<MarketDto> getAllDetails(int pageNo, int pageSize);

    MarketDto updateMarket(MarketDto marketDto, long id);

    void deleteMarket(long id);
}
