package br.fabiosantos.barbershop.domain;

import static br.fabiosantos.barbershop.utils.AvailabilityUtils.createAvailability;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;


public class BarbershopTest {

    @Test
    void whenBarbershopIsGivenThenItShouldBeCreated() {
        var expectedName = "Barbearia do fabio";
        var expectedAddress = "Tamboril";
        var expectedCity = "Tamboril";

        var barbershop = new Barbershop.Builder(expectedName)
                .address(expectedAddress)
                .city(expectedCity)
                .availability(createAvailability())
                .build();

        assertThat(barbershop.getName(), equalTo(expectedName));
        assertThat(barbershop.getAddress(), equalTo(expectedAddress));
        assertThat(barbershop.getCity(), equalTo(expectedCity));
        assertThat(barbershop.getAvailability().getDaysOfWeek(), equalTo(createAvailability().getDaysOfWeek()));
    }

	/*
	 * @Test void whenReservationIsGivenThenItShouldBeAdded() { Barbershop
	 * barbershop = createBarbershop();
	 * 
	 * Reservation reservation = Reservation.of(ReservationUtils.customer,
	 * ReservationUtils.date, ReservationUtils.dayOfWeek, ReservationUtils.time); //
	 * reservation.builder().customer(ReservationBuilder.builder().customer).
	 * dayOfWeek(ReservationBuilder.builder().dayOfWeek).date(ReservationBuilder.
	 * builder().date).time(ReservationBuilder.builder().time).build();
	 * 
	 * barbershop.add(reservation);
	 * 
	 * assertTrue(barbershop.getReservations().contains(reservation)); }
	 */

	/*
	 * @Test void whenAlreadyReservedTimeIsGivenThenAnExceptionShouldBeThrown() {
	 * Barbershop barbershop = createBarbershop();
	 * 
	 * Reservation reservation = ReservationBuilder.builder() .build();
	 * 
	 * barbershop.add(reservation); Reservation alreadyReservedTime =
	 * ReservationBuilder.builder() .build();
	 * 
	 * assertThrows(ScheduleAlreadyReservedException.class, () ->
	 * barbershop.add(alreadyReservedTime)); }
	 */

	/*
	 * @Test void whenOvertimeForReservationIsGivenThenAnExceptionShouldBeThrown() {
	 * Barbershop barbershop = createBarbershop();
	 * 
	 * Reservation reservation = ReservationBuilder.builder() .time(LocalTime.of(22,
	 * 0)) .build(); assertThrows(TimeNotAvailableException.class, () ->
	 * barbershop.add(reservation)); }
	 */

/*
 * @Test void
 * whenEarlierTimeForReservationIsGivenThenAnExceptionShouldBeThrown() {
 * Barbershop barbershop = createBarbershop();
 * 
 * Reservation reservation = ReservationBuilder.builder() .time(LocalTime.of(8,
 * 0)) .build(); assertThrows(TimeNotAvailableException.class, () ->
 * barbershop.add(reservation)); } }
 */
}
