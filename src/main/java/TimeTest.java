import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class TimeTest {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println(zonedDateTimeNow.toOffsetDateTime().truncatedTo(ChronoUnit.SECONDS).toString());
    }
}
