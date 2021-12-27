package guru.springframework.msscbrewery.web.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest extends BaseTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testKebabSerializeDto() throws JsonProcessingException {
        BeerDto dto = getBeerDto();
        String jsonDto = objectMapper.writeValueAsString(dto);
        System.out.println("jsonDto = " + jsonDto);
    }

//    @Test
//    public void testSnakeDeserializeDto() throws IOException {
//        String jsonDto = "{\"id\":\"a23c08a3-dc39-4b1b-a95a-3c9266054635\",\"beerName\":\"bName\",\"beerStyle\":\"bStyle\",\"upc\":123123123,\"createdDate\":\"2021-12-27T16:49:47.8390006+03:00\",\"lastUpdatedDate\":\"2021-12-27T16:49:47.8399645+03:00\"}";
//        BeerDto beerDto = objectMapper.readValue(jsonDto, BeerDto.class);
//        System.out.println(" " + beerDto);
//    }
}