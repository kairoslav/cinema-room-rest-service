package cinema;

import java.util.UUID;

public class OrderedSeat {
    private UUID token;
    private Seat ticket;

    public OrderedSeat() {
    }

    public OrderedSeat(UUID token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }
}
