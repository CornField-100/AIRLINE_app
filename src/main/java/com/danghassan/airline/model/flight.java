package com.danghassan.airline.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
public class flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int numberOfSeats;

    @ManyToOne
    private airport departureAirport;

    @ManyToOne
    private airport arrivalAirport;

    @ManyToOne
    private com.danghassan.airline.model.plane plane;

    public flight() {
    }

    public Long getId() {
        return this.id;
    }

    public String getDepartureCity() {
        return this.departureCity;
    }

    public String getArrivalCity() {
        return this.arrivalCity;
    }

    public LocalDateTime getDepartureTime() {
        return this.departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return this.arrivalTime;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }

    public airport getDepartureAirport() {
        return this.departureAirport;
    }

    public airport getArrivalAirport() {
        return this.arrivalAirport;
    }

    public plane getPlane() {
        return this.plane;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setDepartureAirport(airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArrivalAirport(airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setPlane(plane plane) {
        this.plane = plane;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof flight)) return false;
        final flight other = (flight) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$departureCity = this.getDepartureCity();
        final Object other$departureCity = other.getDepartureCity();
        if (this$departureCity == null ? other$departureCity != null : !this$departureCity.equals(other$departureCity))
            return false;
        final Object this$arrivalCity = this.getArrivalCity();
        final Object other$arrivalCity = other.getArrivalCity();
        if (this$arrivalCity == null ? other$arrivalCity != null : !this$arrivalCity.equals(other$arrivalCity))
            return false;
        final Object this$departureTime = this.getDepartureTime();
        final Object other$departureTime = other.getDepartureTime();
        if (this$departureTime == null ? other$departureTime != null : !this$departureTime.equals(other$departureTime))
            return false;
        final Object this$arrivalTime = this.getArrivalTime();
        final Object other$arrivalTime = other.getArrivalTime();
        if (this$arrivalTime == null ? other$arrivalTime != null : !this$arrivalTime.equals(other$arrivalTime))
            return false;
        if (this.getNumberOfSeats() != other.getNumberOfSeats()) return false;
        final Object this$departureAirport = this.getDepartureAirport();
        final Object other$departureAirport = other.getDepartureAirport();
        if (this$departureAirport == null ? other$departureAirport != null : !this$departureAirport.equals(other$departureAirport))
            return false;
        final Object this$arrivalAirport = this.getArrivalAirport();
        final Object other$arrivalAirport = other.getArrivalAirport();
        if (this$arrivalAirport == null ? other$arrivalAirport != null : !this$arrivalAirport.equals(other$arrivalAirport))
            return false;
        final Object this$plane = this.getPlane();
        final Object other$plane = other.getPlane();
        if (this$plane == null ? other$plane != null : !this$plane.equals(other$plane)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof flight;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $departureCity = this.getDepartureCity();
        result = result * PRIME + ($departureCity == null ? 43 : $departureCity.hashCode());
        final Object $arrivalCity = this.getArrivalCity();
        result = result * PRIME + ($arrivalCity == null ? 43 : $arrivalCity.hashCode());
        final Object $departureTime = this.getDepartureTime();
        result = result * PRIME + ($departureTime == null ? 43 : $departureTime.hashCode());
        final Object $arrivalTime = this.getArrivalTime();
        result = result * PRIME + ($arrivalTime == null ? 43 : $arrivalTime.hashCode());
        result = result * PRIME + this.getNumberOfSeats();
        final Object $departureAirport = this.getDepartureAirport();
        result = result * PRIME + ($departureAirport == null ? 43 : $departureAirport.hashCode());
        final Object $arrivalAirport = this.getArrivalAirport();
        result = result * PRIME + ($arrivalAirport == null ? 43 : $arrivalAirport.hashCode());
        final Object $plane = this.getPlane();
        result = result * PRIME + ($plane == null ? 43 : $plane.hashCode());
        return result;
    }

    public String toString() {
        return "flight(id=" + this.getId() + ", departureCity=" + this.getDepartureCity() + ", arrivalCity=" + this.getArrivalCity() + ", departureTime=" + this.getDepartureTime() + ", arrivalTime=" + this.getArrivalTime() + ", numberOfSeats=" + this.getNumberOfSeats() + ", departureAirport=" + this.getDepartureAirport() + ", arrivalAirport=" + this.getArrivalAirport() + ", plane=" + this.getPlane() + ")";
    }
}
