package com.infy.bokbe6.beans;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class CoordinatesEntity {
    private long id;
    private double xCoordinate;
    private double yCoordinate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoordinatesEntity that = (CoordinatesEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.xCoordinate, xCoordinate) != 0) return false;
        if (Double.compare(that.yCoordinate, yCoordinate) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(xCoordinate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(yCoordinate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
