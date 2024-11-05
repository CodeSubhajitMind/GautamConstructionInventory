package com.gautam_construction.InventoryManagement.DTO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class vehicle_list_dto {
	private Integer id;
	private String vehicle_no;
	private String driver_lisence_no;
	private String tyre_no;
	private String battery_no;
	private String pollution_from_date;
	private LocalDate pollution_expiry_date;
	private String fitness_from_date;
	private LocalDate fitness_end_date;
	private String insurance_from_date;
	private LocalDate insurance_end_date;
	private String last_servicing_date;
	private String vehicle_type;
	public vehicle_list_dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public vehicle_list_dto(Integer id, String vehicle_no, String driver_lisence_no, String tyre_no, String battery_no,
			String pollution_from_date, LocalDate pollution_expiry_date, String fitness_from_date,
			LocalDate fitness_end_date, String insurance_from_date, LocalDate insurance_end_date,
			String last_servicing_date, String vehicle_type) {
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
		this.vehicle_type = vehicle_type;
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
	public LocalDate getPollution_expiry_date() {
		return pollution_expiry_date;
	}
	public void setPollution_expiry_date(LocalDate pollution_expiry_date) {
		this.pollution_expiry_date = pollution_expiry_date;
	}
	public String getFitness_from_date() {
		return fitness_from_date;
	}
	public void setFitness_from_date(String fitness_from_date) {
		this.fitness_from_date = fitness_from_date;
	}
	public LocalDate getFitness_end_date() {
		return fitness_end_date;
	}
	public void setFitness_end_date(LocalDate fitness_end_date) {
		this.fitness_end_date = fitness_end_date;
	}
	public String getInsurance_from_date() {
		return insurance_from_date;
	}
	public void setInsurance_from_date(String insurance_from_date) {
		this.insurance_from_date = insurance_from_date;
	}
	public LocalDate getInsurance_end_date() {
		return insurance_end_date;
	}
	public void setInsurance_end_date(LocalDate insurance_end_date) {
		this.insurance_end_date = insurance_end_date;
	}
	public String getLast_servicing_date() {
		return last_servicing_date;
	}
	public void setLast_servicing_date(String last_servicing_date) {
		this.last_servicing_date = last_servicing_date;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	
    // Method to check if the date is within the next week
    public boolean isPollutionExpiringInNextWeek() {
        if (this.pollution_expiry_date == null) {
            return false;
        }
        LocalDate now = LocalDate.now();
        LocalDate oneWeekFromNow = now.plus(1, ChronoUnit.WEEKS);
        return !this.pollution_expiry_date.isBefore(now) && !this.pollution_expiry_date.isAfter(oneWeekFromNow);
    }
    
    public boolean isFitnessExpiringInNextWeek() {
        if (this.fitness_end_date == null) {
            return false;
        }
        LocalDate now = LocalDate.now();
        LocalDate oneWeekFromNow = now.plus(1, ChronoUnit.WEEKS);
        return !this.fitness_end_date.isBefore(now) && !this.fitness_end_date.isAfter(oneWeekFromNow);
    }
    
    public boolean isInsuranceExpiringInNextWeek() {
        if (this.insurance_end_date == null) {
            return false;
        }
        LocalDate now = LocalDate.now();
        LocalDate oneWeekFromNow = now.plus(1, ChronoUnit.WEEKS);
        return !this.insurance_end_date.isBefore(now) && !this.insurance_end_date.isAfter(oneWeekFromNow);
    }
	
	
}
