package com.danghassan.airline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "planes")
public class plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private int manufacturingYear;

    public plane() {
    }

    public Long getId() {
        return this.id;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getManufacturingYear() {
        return this.manufacturingYear;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof plane)) return false;
        final plane other = (plane) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$brand = this.getBrand();
        final Object other$brand = other.getBrand();
        if (this$brand == null ? other$brand != null : !this$brand.equals(other$brand)) return false;
        final Object this$model = this.getModel();
        final Object other$model = other.getModel();
        if (this$model == null ? other$model != null : !this$model.equals(other$model)) return false;
        if (this.getManufacturingYear() != other.getManufacturingYear()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof plane;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $brand = this.getBrand();
        result = result * PRIME + ($brand == null ? 43 : $brand.hashCode());
        final Object $model = this.getModel();
        result = result * PRIME + ($model == null ? 43 : $model.hashCode());
        result = result * PRIME + this.getManufacturingYear();
        return result;
    }

    public String toString() {
        return "plane(id=" + this.getId() + ", brand=" + this.getBrand() + ", model=" + this.getModel() + ", manufacturingYear=" + this.getManufacturingYear() + ")";
    }
}
