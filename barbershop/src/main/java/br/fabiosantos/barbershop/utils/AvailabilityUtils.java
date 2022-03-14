package br.fabiosantos.barbershop.utils;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import java.time.LocalTime;
import java.util.List;

import br.fabiosantos.barbershop.domain.Availability;

public class AvailabilityUtils {

    public static Availability createAvailability() {
        var expectedDaysOfWeek = List.of(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY);
        var expectedOpenTime = LocalTime.of(10, 0);
        var expectedCloseTime = LocalTime.of(19, 0);
        var expectedDuration = LocalTime.of(1, 0);
        return Availability.of(expectedDaysOfWeek, expectedOpenTime, expectedCloseTime, expectedDuration);
    }
}
