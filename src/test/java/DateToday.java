import java.time.LocalDate;

public class DateToday {

        int termBeforeDeparture = 14;

        LocalDate dateNow = LocalDate.now();
        LocalDate addDay = dateNow.plusDays(termBeforeDeparture);

        String numberDayNow = String.valueOf(addDay.getDayOfMonth());
        boolean isMonthSame = dateNow.getMonth().equals(addDay.getMonth());
}
