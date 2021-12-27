package guru.springframework.msscbrewery.web.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {

    public BeerDto getBeerDto() {
        return BeerDto.builder().beerName("bName")
                .beerStyle("bStyle")
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastUpdatedDate(OffsetDateTime.now())
                .price(BigDecimal.valueOf(12.55))
                .upc(123123123L).myLocalDate(LocalDate.now())
                .build();
    }
}
