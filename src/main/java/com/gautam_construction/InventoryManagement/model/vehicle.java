package com.gautam_construction.InventoryManagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class vehicle {
	
	@Id
    private Integer id;
	private String vehicle_no;
	private String driver_lisence_no;
	private String tyre_no;
	private String battery_no;
	private String pollution_from_date;
	private String pollution_expiry_date;
	private String fitness_from_date;
	private String fitness_end_date;
	private String insurance_from_date;
	private String insurance_end_date;
	private String last_servicing_date;
	public vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public vehicle(Integer id, String vehicle_no, String driver_lisence_no, String tyre_no, String battery_no,
			String pollution_from_date, String pollution_expiry_date, String fitness_from_date, String fitness_end_date,
			String insurance_from_date, String insurance_end_date, String last_servicing_date) {
		super();
		this.id = id;
		this.vehicle_no = vehicle_no;
		this.driver_lisence_no = driver_lisence_no;
		this.tyre_no = tyre_no;
		this.battery_no = battery_no;
		this.pollution_from_date = pollution_from_date;
		this.pollution_expiry_date = pollution_expiry_date;
		this.fitness_from_date = fitness_from_date;
		this.fitness_end_date = fitness_end_date;
		this.insurance_from_date = insurance_from_date;
		this.insurance_end_date = insurance_end_date;
		this.last_servicing_date = last_servicing_date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getDriver_lisence_no() {
		return driver_lisence_no;
	}
	public void setDriver_lisence_no(String driver_lisence_no) {
		this.driver_lisence_no = driver_lisence_no;
	}
	public String getTyre_no() {
		return tyre_no;
	}
	public void setTyre_no(String tyre_no) {
		this.tyre_no = tyre_no;
	}
	public String getBattery_no() {
		return battery_no;
	}
	public void setBattery_no(String battery_no) {
		this.battery_no = battery_no;
	}
	public String getPollution_from_date() {
		return pollution_from_date;
	}
	public void setPollution_from_date(String pollution_from_date) {
		this.pollution_from_date = pollution_from_date;
	}
	public String getPollution_expiry_date() {
		return pollution_expiry_date;
	}
	public void setPollution_expiry_date(String pollution_expiry_date) {
		this.pollution_expiry_date = pollution_expiry_date;
	}
	public String getFitness_from_date() {
		return fitness_from_date;
	}
	public void setFitness_from_date(String fitness_from_date) {
		this.fitness_from_date = fitness_from_date;
	}
	public String getFitness_end_date() {
		return fitness_end_date;
	}
	public void setFitness_end_date(String fitness_end_date) {
		this.fitness_end_date = fitness_end_date;
	}
	public String getInsurance_from_date() {
		return insurance_from_date;
	}
	public void setInsurance_from_date(String insurance_from_date) {
		this.insurance_from_date = insurance_from_date;
	}
	public String getInsurance_end_date() {
		return insurance_end_date;
	}
	public void setInsurance_end_date(String insurance_end_date) {
		this.insurance_end_date = insurance_end_date;
	}
	public String getLast_servicing_date() {
		return last_servicing_date;
	}
	public void setLast_servicing_date(String last_servicing_date) {
		this.last_servicing_date = last_servicing_date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(battery_no, driver_lisence_no, fitness_end_date, fitness_from_date, id, insurance_end_date,
				insurance_from_date, last_servicing_date, pollution_expiry_date, pollution_from_date, tyre_no,
				vehicle_no);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		vehicle other = (vehicle) obj;
		return Objects.equals(battery_no, other.battery_no)
				&& Objects.equals(driver_lisence_no, other.driver_lisence_no)
				&& Objects.equals(fitness_end_date, other.fitness_end_date)
				&& Objects.equals(fitness_from_date, other.fitness_from_date) && Objects.equals(id, other.id)
				&& Objects.equals(insurance_end_date, other.insurance_end_date)
				&& Objects.equals(insurance_from_date, other.insurance_from_date)
				&& Objects.equals(last_servicing_date, other.last_servicing_date)
				&& Objects.equals(pollution_expiry_date, other.pollution_expiry_date)
				&& Objects.equals(pollution_from_date, other.pollution_from_date)
				&& Objects.equals(tyre_no, other.tyre_no) && Objects.equals(vehicle_no, other.vehicle_no);
	}
	@Override
	public String toString() {
		return "vehicle [id=" + id + ", vehicle_no=" + vehicle_no + ", driver_lisence_no=" + driver_lisence_no
				+ ", tyre_no=" + tyre_no + ", battery_no=" + battery_no + ", pollution_from_date=" + pollution_from_date
				+ ", pollution_expiry_date=" + pollution_expiry_date + ", fitness_from_date=" + fitness_from_date
				+ ", fitness_end_date=" + fitness_end_date + ", insurance_from_date=" + insurance_from_date
				+ ", insurance_end_date=" + insurance_end_date + ", last_servicing_date=" + last_servicing_date + "]";
	}
	
	
	
}
