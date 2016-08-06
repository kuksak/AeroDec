package com.infy.bokbe6.beans;

import javax.persistence.*;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
@Entity
@Table(name = "AEROFOILS", schema = "SAKSH", catalog = "")
public class AerofoilsEntity {
    private long id;
    private String aerofoilName;
    private String aerofoilDescription;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AEROFOIL_NAME")
    public String getAerofoilName() {
        return aerofoilName;
    }

    public void setAerofoilName(String aerofoilName) {
        this.aerofoilName = aerofoilName;
    }

    @Basic
    @Column(name = "AEROFOIL_DESCRIPTION")
    public String getAerofoilDescription() {
        return aerofoilDescription;
    }

    public void setAerofoilDescription(String aerofoilDescription) {
        this.aerofoilDescription = aerofoilDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AerofoilsEntity that = (AerofoilsEntity) o;

        if (id != that.id) return false;
        if (aerofoilName != null ? !aerofoilName.equals(that.aerofoilName) : that.aerofoilName != null) return false;
        if (aerofoilDescription != null ? !aerofoilDescription.equals(that.aerofoilDescription) : that.aerofoilDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (aerofoilName != null ? aerofoilName.hashCode() : 0);
        result = 31 * result + (aerofoilDescription != null ? aerofoilDescription.hashCode() : 0);
        return result;
    }
}
