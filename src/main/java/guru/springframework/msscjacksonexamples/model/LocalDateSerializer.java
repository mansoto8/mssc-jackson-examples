package guru.springframework.msscjacksonexamples.model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateSerializer extends JsonSerializer<LocalDate>
{
  @Override
  public void serialize(
      final LocalDate localDate, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider)
      throws IOException
  {
    jsonGenerator.writeObject(localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
  }
}
