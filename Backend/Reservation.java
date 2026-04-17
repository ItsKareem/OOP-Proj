package Backend;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {

    public enum ReservationStatus{
        PENDING, CONFIRMED, CANCELLED, COMPLETED
    }

    private int roomReference;
    private int guestReference;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private ReservationStatus reservationStatus;
    private Invoice invoice;

    public Reservation(LocalDate checkInDate, LocalDate checkOutDate, int guestReference, int roomReference, String reservationStatus) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guestReference = guestReference;
        this.roomReference = roomReference;
        this.reservationStatus = ReservationStatus.valueOf(reservationStatus.toUpperCase());

        long daysBetween = ChronoUnit.DAYS.between(this.getCheckInDate(), this.getCheckOutDate());
        double total = Database.getRoom(roomReference).getRoomType().getPricePerNight() * daysBetween;

        this.invoice = new Invoice(total);

        Database.addReservation(this);
    }

    public ReservationStatus getReservationStatus() {
        return this.reservationStatus;
    }

    public void setReservationStatus(final ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public LocalDate getCheckInDate(){
        return this.checkInDate;

    }

    public void setCheckInDate( LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return this.checkOutDate;
    }

    public void setCheckOutDate( LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getGuestReference() {
        return this.guestReference;
    }

    public void setGuestReference( int guestRefrence) {
        this.guestReference = guestRefrence;
    }

    public int getRoomReference() {
        return this.roomReference;
    }

    public void setRoomRefrence( int roomRefrence) {
        this.roomReference = roomRefrence;

    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void showReservationDetails() {
        System.out.println("======= Reservation Details =======");
        System.out.println("Guest Reference: " + guestReference);
        System.out.println("Room Reference:  " + roomReference);
        System.out.println("Check-in Date:   " + checkInDate);
        System.out.println("Check-out Date:  " + checkOutDate);
        System.out.println("Status:          " + reservationStatus);
    }
}
