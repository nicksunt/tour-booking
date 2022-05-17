import java.time.LocalDate;

public class DateToday {

        int x = 14;

        LocalDate dateNow = LocalDate.now();
        LocalDate addDay = dateNow.plusDays(x);

        String numberDayNow = String.valueOf(addDay.getDayOfMonth());
        boolean isMonthSame = dateNow.getMonth().equals(addDay.getMonth());
  }
