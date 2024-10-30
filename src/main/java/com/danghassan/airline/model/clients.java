package com.danghassan.airline.model;

import jakarta.persistence.Entity;

@Entity
public class clients extends users {
    private String passportNumber;

    public clients() {
    }

    public String getPassportNumber() {
        return this.passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof clients)) return false;
        final clients other = (clients) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$passportNumber = this.getPassportNumber();
        final Object other$passportNumber = other.getPassportNumber();
        if (this$passportNumber == null ? other$passportNumber != null : !this$passportNumber.equals(other$passportNumber))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof clients;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $passportNumber = this.getPassportNumber();
        result = result * PRIME + ($passportNumber == null ? 43 : $passportNumber.hashCode());
        return result;
    }

    public String toString() {
        return "clients(passportNumber=" + this.getPassportNumber() + ")";
    }
}
