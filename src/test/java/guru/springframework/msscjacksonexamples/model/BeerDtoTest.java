package guru.springframework.msscjacksonexamples.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
class BeerDtoTest extends BaseTest
{
  @Autowired
  ObjectMapper objectMapper;

  @Test
  void testSerializeDto() throws JsonProcessingException {
    BeerDto beerDto = getDto();

    String jsonString = objectMapper.writeValueAsString(beerDto);

    System.out.println(jsonString);
  }

  @Test
  void testDeserialize() throws IOException {
    String json =
        "{\"id\":\"e46de59b-f016-49d3-a5e9-fcfaf003a7b8\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":1234123342,\"price\":12.99,\"createdDate\":\"2021-05-02T23:16:53.068831-05:00\",\"lastUpdatedDate\":\"2021-05-02T23:16:53.068899-05:00\"}";

    BeerDto dto = objectMapper.readValue(json, BeerDto.class);

    System.out.println(dto);
  }
}