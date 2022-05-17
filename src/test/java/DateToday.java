import java.time.LocalDate;

public class DateToday {

        int termBeforeDeparture = 30;

        LocalDate dateNow = LocalDate.now();
        LocalDate addDay = dateNow.plusDays(termBeforeDeparture);

        int monthNumber = addDay.getMonthValue();
        int year = addDay.getYear();
        String numberDayNow = String.valueOf(addDay.getDayOfMonth());
}
