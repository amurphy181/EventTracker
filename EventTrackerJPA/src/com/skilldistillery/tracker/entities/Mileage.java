package com.skilldistillery.tracker.entities;

import javax.persistence.*;

@Entity
public class Mileage {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	private double distance;
	@Column(name = "gallons_used")
	private double gallonsUsed;
	private double mpg;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(gallonsUsed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(mpg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mileage other = (Mileage) obj;
		if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
			return false;
		if (Double.doubleToLongBits(gallonsUsed) != Double.doubleToLongBits(other.gallonsUsed))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(mpg) != Double.doubleToLongBits(other.mpg))
			return false;
		return true;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getGallonsUsed() {
		return gallonsUsed;
	}
	public void setGallonsUsed(double gallonsUsed) {
		this.gallonsUsed = gallonsUsed;
	}
	public double getMpg() {
		return mpg;
	}
	public void setMpg(double mpg) {
		this.mpg = mpg;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mileage [id=");
		builder.append(id);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", gallonsUsed=");
		builder.append(gallonsUsed);
		builder.append(", mpg=");
		builder.append(mpg);
		builder.append("]");
		return builder.toString();
	}

}
