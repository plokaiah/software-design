package Controller;

import Controller.EnumClass.FanMode;
import Controller.EnumClass.Mode;

public class ACDetails {
	
	Mode mode;
    String ac_type;
    FanMode fanMode1;
    FanMode fanMode2;
    FanMode res_fanMode = FanMode.OFF;
    double cur_temp;
    double cur_hum;  
    double result_temp;
	double desired_temp;
    double sensor_temp_1;
    double sensor_temp_2;
    double sensor_hum_1;
    double sensor_hum_2;
    
    public double getCur_hum() {
		return cur_hum;
	}
	public void setCur_hum(double cur_hum) {
		this.cur_hum = cur_hum;
	}
	public double getSensor_temp_1() {
		return sensor_temp_1;
	}
	public void setSensor_temp_1(double sensor_temp_1) {
		this.sensor_temp_1 = sensor_temp_1;
	}
	public double getSensor_temp_2() {
		return sensor_temp_2;
	}
	public void setSensor_temp_2(double sensor_temp_2) {
		this.sensor_temp_2 = sensor_temp_2;
	}
	public double getSensor_hum_1() {
		return sensor_hum_1;
	}
	public void setSensor_hum_1(double sensor_hum_1) {
		this.sensor_hum_1 = sensor_hum_1;
	}
	public double getSensor_hum_2() {
		return sensor_hum_2;
	}
	public void setSensor_hum_2(double sensor_hum_2) {
		this.sensor_hum_2 = sensor_hum_2;
	}
	public double getDesired_temp() {
		return desired_temp;
	}
	public void setDesired_temp(double desired_temp) {
		this.desired_temp = desired_temp;
	}
	public double getCur_temp() {
		return cur_temp;
	}
	public void setCur_temp(double cur_temp) {
		this.cur_temp = cur_temp;
	}
	public double getResult_temp() {
		return result_temp;
	}
	public void setResult_temp(double result_temp) {
		this.result_temp = result_temp;
	}
	public Mode getMode() {
		return mode;
	}
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	public String getAc_type() {
		return ac_type;
	}
	public void setAc_type(String ac_type) {
		this.ac_type = ac_type;
	}
	public FanMode getFanMode1() {
		return fanMode1;
	}
	public void setFanMode1(FanMode fanMode1) {
		this.fanMode1 = fanMode1;
	}
	public FanMode getFanMode2() {
		return fanMode2;
	}
	public void setFanMode2(FanMode fanMode2) {
		this.fanMode2 = fanMode2;
	}
	public FanMode getRes_fanMode() {
		return res_fanMode;
	}
	public void setRes_fanMode(FanMode res_fanMode) {
		this.res_fanMode = res_fanMode;
	}
	
	public FanMode resultFanMode()
	{
		if(fanMode1.equals(FanMode.ON) || fanMode2.equals(FanMode.ON))
			return FanMode.ON;
		return fanMode1.OFF;
	}
}
