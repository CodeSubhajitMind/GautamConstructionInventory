package com.gautam_construction.InventoryManagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fuel_exit")
public class fuel_exit {
	@Id
    private Integer id;
	private String exit_type;
	private String fuel_type;
	private String vehicle_no;
	private String opening_reading;
	private String mileage;
	private String fuel_issue;
	private String issue_date;
	private String vehicle_type;
	public fuel_exit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public fuel_exit(Integer id, String exit_type, String fuel_type, String vehicle_no, String opening_reading,
			String mileage, String fuel_issue, String issue_date, String vehicle_type) {
		super();
		this.id = id;
		this.exit_type = exit_type;
		this.fuel_type = fuel_type;
		this.vehicle_no = vehicle_no;
		this.opening_reading = opening_reading;
		this.mileage = mileage;
		this.fuel_issue = fuel_issue;
		this.issue_date = issue_date;
		this.vehicle_type = vehicle_type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getExit_type() {
		return exit_type;
	}
	public void setExit_type(String exit_type) {
		this.exit_type = exit_type;
	}
	public String getFuel_type() {
		return fuel_type;
	}
	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getOpening_reading() {
		return opening_reading;
	}
	public void setOpening_reading(String opening_reading) {
		this.opening_reading = opening_reading;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getFuel_issue() {
		return fuel_issue;
	}
	public void setFuel_issue(String fuel_issue) {
		this.fuel_issue = fuel_issue;
	}
	public String getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	@Override
	public int hashCode() {
		return Objects.hash(exit_type, fuel_issue, fuel_type, id, issue_date, mileage, opening_reading, vehicle_no,
				vehicle_type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		fuel_exit other = (fuel_exit) obj;
		return Objects.equals(exit_type, other.exit_type) && Objects.equals(fuel_issue, other.fuel_issue)
				&& Objects.equals(fuel_type, other.fuel_type) && Objects.equals(id, other.id)
				&& Objects.equals(issue_date, other.issue_date) && Objects.equals(mileage, other.mileage)
				&& Objects.equals(opening_reading, other.opening_reading)
				&& Objects.equals(vehicle_no, other.vehicle_no) && Objects.equals(vehicle_type, other.vehicle_type);
	}
	@Override
	public String toString() {
		return "fuel_exit [id=" + id + ", exit_type=" + exit_type + ", fuel_type=" + fuel_type + ", vehicle_no="
				+ vehicle_no + ", opening_reading=" + opening_reading + ", mileage=" + mileage + ", fuel_issue="
				+ fuel_issue + ", issue_date=" + issue_date + ", vehicle_type=" + vehicle_type + "]";
	}
	
	
	
	
}
