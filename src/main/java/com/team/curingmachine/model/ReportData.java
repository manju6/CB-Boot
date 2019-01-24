package com.team.curingmachine.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="reportData")
public class ReportData {
	
	@Id
	private Date id;
	
	@Field(value = "mainlinecoldwaterpressure")
	private double  mainLineColdWaterPressure;
	
	@Field(value = "mainlinelowpressure")
	private double  mainLineLowPressure;
	
	@Field(value = "mainlinetemperature")
	private double  mainLineTemperature;
	
	@Field(value = "mainlinehighpressure")
	private double  mainLineHighPressure;
	

	public Date getId() {
		return id;
	}

	public void setId(Date id) {
		this.id = id;
	}

	public double getMainLineColdWaterPressure() {
		return mainLineColdWaterPressure;
	}

	public void setMainLineColdWaterPressure(double mainLineColdWaterPressure) {
		this.mainLineColdWaterPressure = mainLineColdWaterPressure;
	}

	public double getMainLineLowPressure() {
		return mainLineLowPressure;
	}

	public void setMainLineLowPressure(double mainLineLowPressure) {
		this.mainLineLowPressure = mainLineLowPressure;
	}

	public double getMainLineTemperature() {
		return mainLineTemperature;
	}

	public void setMainLineTemperature(double mainLineTemperature) {
		this.mainLineTemperature = mainLineTemperature;
	}

	public double getMainLineHighPressure() {
		return mainLineHighPressure;
	}

	public void setMainLineHighPressure(double mainLineHighPressure) {
		this.mainLineHighPressure = mainLineHighPressure;
	}
	
	
	
	
}
