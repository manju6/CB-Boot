package com.team.curingmachine.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="dashBoardData")
public class Parms 
{
	
	@Id
	private Date id;
	
	@Field(value = "timeStamp")
	private Date  timeStamp;

	@Field(value = "machineno")
	private int  machineNo;
	
	@Field(value = "machine")
	private String machineName;
	
	@Field(value = "productioncount")
	private String productionCount;
	
	@Field(value = "presscondition")
	private String pressCondition;
	
	@Field(value = "highpressure")
	private String highPressure;
	
	@Field(value = "drain")
	private String drain;
	
	@Field(value = "mode")
	private String mode;
	
	@Field(value = "vaccum")
	private String vaccum;
	
	@Field(value = "coldwater")
	private String coldWater;
	
	@Field(value = "hotwater")
	private String hotWater;
	
	@Field(value = "coldwaterreturn")
	private String coldWaterReturn;
	
	@Field(value = "hotwaterreturn")
	private String hotWaterReturn;
	
	@Field(value = "internalpressure")
	private String internalPressure;
	
	@Field(value = "rightsidetemperatureactual")
	private String rightSideTemperatureActual;
	
	@Field(value = "rightsidetemperatureset")
	private String rightSideTemperatureSet;
	
	@Field(value = "leftsidetemperatureactual")
	private String leftSideTemperatureActual;
	
	@Field(value = "leftsidetemperatureset")
	private String leftSideTemperatureSet;
	
	@Field(value = "step1actual")
	private String step1Actual;
	
    @Field(value = "step1set")
	private String step1Set;
    
    @Field(value = "step2actual")
	private String step2Actual;
	
    @Field(value = "step2set")
	private String step2Set;
    
    @Field(value = "step3actual")
	private String step3Actual;
	
    @Field(value = "step3set")
	private String step3Set;
    
    @Field(value = "step4actual")
	private String step4Actual;
	
    @Field(value = "step4set")
	private String step4Set;
    
    @Field(value = "step5actual")
	private String step5Actual;
	
    @Field(value = "step5set")
	private String step5Set;
    
    @Field(value = "step6actual")
	private String step6Actual;
	
    @Field(value = "step6set")
	private String step6Set;
	
    @Field(value = "settimer")
	private String setTimer;
    
    @Field(value = "actualtimer")
	private String actualTimer;
    

	
	public Date getId() {
		return id;
	}

	public void setId(Date id) {
		this.id = id;
	}

	public int getMachineNo() {
		return machineNo;
	}

	public void setMachineNo(int machineNo) {
		this.machineNo = machineNo;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	
	public String getInternalPressure() {
		return internalPressure;
	}

	public void setInternalPressure(String internalPressure) {
		this.internalPressure = internalPressure;
	}

	public String getProductionCount() {
		return productionCount;
	}

	public void setProductionCount(String productionCount) {
		this.productionCount = productionCount;
	}

	public String getPressCondition() {
		return pressCondition;
	}

	public void setPressCondition(String pressCondition) {
		this.pressCondition = pressCondition;
	}

	public String getHighPressure() {
		return highPressure;
	}

	public void setHighPressure(String highPressure) {
		this.highPressure = highPressure;
	}

	public String getDrain() {
		return drain;
	}

	public void setDrain(String drain) {
		this.drain = drain;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getVaccum() {
		return vaccum;
	}

	public void setVaccum(String vaccum) {
		this.vaccum = vaccum;
	}

	public String getColdWater() {
		return coldWater;
	}

	public void setColdWater(String coldWater) {
		this.coldWater = coldWater;
	}

	public String getHotWater() {
		return hotWater;
	}

	public void setHotWater(String hotWater) {
		this.hotWater = hotWater;
	}

	public String getColdWaterReturn() {
		return coldWaterReturn;
	}

	public void setColdWaterReturn(String coldWaterReturn) {
		this.coldWaterReturn = coldWaterReturn;
	}

	public String getHotWaterReturn() {
		return hotWaterReturn;
	}

	public void setHotWaterReturn(String hotWaterReturn) {
		this.hotWaterReturn = hotWaterReturn;
	}

	public String getRightSideTemperatureActual() {
		return rightSideTemperatureActual;
	}

	public void setRightSideTemperatureActual(String rightSideTemperatureActual) {
		this.rightSideTemperatureActual = rightSideTemperatureActual;
	}

	public String getRightSideTemperatureSet() {
		return rightSideTemperatureSet;
	}

	public void setRightSideTemperatureSet(String rightSideTemperatureSet) {
		this.rightSideTemperatureSet = rightSideTemperatureSet;
	}

	public String getLeftSideTemperatureActual() {
		return leftSideTemperatureActual;
	}

	public void setLeftSideTemperatureActual(String leftSideTemperatureActual) {
		this.leftSideTemperatureActual = leftSideTemperatureActual;
	}

	public String getLeftSideTemperatureSet() {
		return leftSideTemperatureSet;
	}

	public void setLeftSideTemperatureSet(String leftSideTemperatureSet) {
		this.leftSideTemperatureSet = leftSideTemperatureSet;
	}

	public String getStep1Actual() {
		return step1Actual;
	}

	public void setStep1Actual(String step1Actual) {
		this.step1Actual = step1Actual;
	}

	public String getStep1Set() {
		return step1Set;
	}

	public void setStep1Set(String step1Set) {
		this.step1Set = step1Set;
	}

	public String getStep2Actual() {
		return step2Actual;
	}

	public void setStep2Actual(String step2Actual) {
		this.step2Actual = step2Actual;
	}

	public String getStep2Set() {
		return step2Set;
	}

	public void setStep2Set(String step2Set) {
		this.step2Set = step2Set;
	}

	public String getStep3Actual() {
		return step3Actual;
	}

	public void setStep3Actual(String step3Actual) {
		this.step3Actual = step3Actual;
	}

	public String getStep3Set() {
		return step3Set;
	}

	public void setStep3Set(String step3Set) {
		this.step3Set = step3Set;
	}

	public String getStep4Actual() {
		return step4Actual;
	}

	public void setStep4Actual(String step4Actual) {
		this.step4Actual = step4Actual;
	}

	public String getStep4Set() {
		return step4Set;
	}

	public void setStep4Set(String step4Set) {
		this.step4Set = step4Set;
	}

	public String getStep5Actual() {
		return step5Actual;
	}

	public void setStep5Actual(String step5Actual) {
		this.step5Actual = step5Actual;
	}

	public String getStep5Set() {
		return step5Set;
	}

	public void setStep5Set(String step5Set) {
		this.step5Set = step5Set;
	}

	public String getStep6Actual() {
		return step6Actual;
	}

	public void setStep6Actual(String step6Actual) {
		this.step6Actual = step6Actual;
	}

	public String getStep6Set() {
		return step6Set;
	}

	public void setStep6Set(String step6Set) {
		this.step6Set = step6Set;
	}

	public String getSetTimer() {
		return setTimer;
	}

	public void setSetTimer(String setTimer) {
		this.setTimer = setTimer;
	}

	public String getActualTimer() {
		return actualTimer;
	}

	public void setActualTimer(String actualTimer) {
		this.actualTimer = actualTimer;
	}
    
	
	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "Customer [id=" + machineNo + ", name=" + machineName+ "]";
	}
}

