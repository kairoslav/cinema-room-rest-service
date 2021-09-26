package cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SeatsController {
    public Seats getAllSeats() {
        int total_rows = 9;
        int total_columns = 9;
        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= total_rows; row++) {
            for (int column = 1; column <= total_columns; column++) {
                seats.add(new Seat(row, column));
            }
        }
        return new Seats(total_rows, total_columns, seats);
    }

    @GetMapping("/seats")
    public Seats getSeats() {
        return getAllSeats();
    }
}
