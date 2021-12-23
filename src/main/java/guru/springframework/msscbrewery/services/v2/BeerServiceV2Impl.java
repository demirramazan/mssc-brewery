package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public BeerDto updateBeer(UUID beedId, BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName(beerDto.getBeerName()).beerStyle(beerDto.getBeerStyle()).build();
    }

    @Override
    public void deleteById(UUID uuid) {
        log.info("Delete beer id=" + uuid.toString());
    }
}
