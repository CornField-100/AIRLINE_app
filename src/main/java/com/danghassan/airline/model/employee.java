package com.danghassan.airline.model;

import jakarta.persistence.Entity;

@Entity
public class employee extends users {
    private String employeeNumber;

    public employee() {
    }

    public String getEmployeeNumber() {
        return this.employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof employee)) return false;
        final employee other = (employee) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$employeeNumber = this.getEmployeeNumber();
        final Object other$employeeNumber = other.getEmployeeNumber();
        if (this$employeeNumber == null ? other$employeeNumber != null : !this$employeeNumber.equals(other$employeeNumber))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof employee;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $employeeNumber = this.getEmployeeNumber();
        result = result * PRIME + ($employeeNumber == null ? 43 : $employeeNumber.hashCode());
        return result;
    }

    public String toString() {
        return "employee(employeeNumber=" + this.getEmployeeNumber() + ")";
    }
}
