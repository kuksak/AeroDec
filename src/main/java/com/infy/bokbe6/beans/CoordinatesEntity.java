package com.infy.bokbe6.beans;

import java.math.BigDecimal;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class CoordinatesEntity {
    private long id;
    private long nacaId;
    private BigDecimal xCoordinate;
    private BigDecimal yCoordinate;

    public long getNacaId() {
        return nacaId;
    }

    public void setNacaId(long nacaId) {
        this.nacaId = nacaId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(BigDecimal xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public BigDecimal getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(BigDecimal yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoordinatesEntity that = (CoordinatesEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        return result;
    }
}
