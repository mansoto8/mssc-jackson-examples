package guru.springframework.msscjacksonexamples.model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateDeserializer extends StdDeserializer<LocalDate>
{
  public LocalDateDeserializer() {
    super(LocalDate.class);
  }

  @Override
  public LocalDate deserialize(
      final JsonParser jsonParser, final DeserializationContext deserializationContext)
      throws IOException, JsonProcessingException
  {
    return LocalDate.parse(
        jsonParser.readValueAs(String.class),
        DateTimeFormatter.BASIC_ISO_DATE
    );
  }
}
