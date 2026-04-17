import java.time.LocalDate;
import java.util.*;

public class Receptionist extends Staff {

    public Receptionist(String name, String password, LocalDate birthDate, int weeklyHours) {
        super(name, password, birthDate, Role.RECEPTIONIST, weeklyHours);
    }

    public static void login() {
        login(Database.getReceptionists());
    }

    public void processCheckIn(int targetResId) {
        Database.getReservation(targetResId).setReservationStatus(Reservation.ReservationStatus.CONFIRMED);
        int roomref = Database.getReservation(targetResId).getRoomReference();
        Database.getRoom(roomref).setAvailable(false);

    }

    public void processCheckOut(int targetResId, Payable bill) {

        if (bill.isPaid()) {
            Database.getReservation(targetResId).setReservationStatus(Reservation.ReservationStatus.COMPLETED);
            int roomref = Database.getReservation(targetResId).getRoomReference();
            Database.getRoom(roomref).setAvailable(true);
        }
    }
}
