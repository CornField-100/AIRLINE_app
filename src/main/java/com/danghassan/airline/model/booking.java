package com.danghassan.airline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private com.danghassan.airline.model.flight flight;

    @ManyToOne
    private clients client;

    public booking() {
    }

    public Long getId() {
        return this.id;
    }

    public flight getFlight() {
        return this.flight;
    }

    public clients getClient() {
        return this.client;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFlight(flight flight) {
        this.flight = flight;
    }

    public void setClient(clients client) {
        this.client = client;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof booking)) return false;
        final booking other = (booking) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$flight = this.getFlight();
        final Object other$flight = other.getFlight();
        if (this$flight == null ? other$flight != null : !this$flight.equals(other$flight)) return false;
        final Object this$client = this.getClient();
        final Object other$client = other.getClient();
        if (this$client == null ? other$client != null : !this$client.equals(other$client)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof booking;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $flight = this.getFlight();
        result = result * PRIME + ($flight == null ? 43 : $flight.hashCode());
        final Object $client = this.getClient();
        result = result * PRIME + ($client == null ? 43 : $client.hashCode());
        return result;
    }

    public String toString() {
        return "booking(id=" + this.getId() + ", flight=" + this.getFlight() + ", client=" + this.getClient() + ")";
    }
}
