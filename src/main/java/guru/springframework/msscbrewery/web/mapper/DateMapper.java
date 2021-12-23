package guru.springframework.msscbrewery.web.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class DateMapper {
    public OffsetDateTime asOffserDateTime(Timestamp timestamp) {
        if (timestamp != null) {
            return OffsetDateTime.of(timestamp.toLocalDateTime().getYear(), timestamp.toLocalDateTime().getMonthValue(),
                    timestamp.toLocalDateTime().getDayOfMonth(), timestamp.toLocalDateTime().getHour(),
                    timestamp.toLocalDateTime().getMinute(), timestamp.toLocalDateTime().getSecond(),
                    timestamp.toLocalDateTime().getNano(), ZoneOffset.UTC);
        }
        return null;
    }

    public Timestamp asTimestamp(OffsetDateTime dateTime) {
        if (dateTime != null) {
            return Timestamp.valueOf(dateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        }
        return null;
    }
}
