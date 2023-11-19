package Controller;

import Components.*;
import Controller.EnumClass.FanMode;
import Controller.EnumClass.Mode;
import DisplaySystem.Thermostat;

public class AirController implements Runnable {

	public void calculateUpdateTemp() {
		
		if(Thermostat.dtls.fanMode1.equals(FanMode.ON) || Thermostat.dtls.fanMode2.equals(FanMode.ON))
			Thermostat.dtls.setRes_fanMode(FanMode.ON);
		else
			Thermostat.dtls.setRes_fanMode(FanMode.OFF);
		double heatTransferCoefficient = 100; // in W/m^2-K
		double refrigerantFlowRate = 0.1; // in kg/s
        int count =0;
		Evaporator evaporator = new Evaporator(heatTransferCoefficient, refrigerantFlowRate);
		Condenser condenser = new Condenser(heatTransferCoefficient, refrigerantFlowRate);
		double currentTemperature = Thermostat.dtls.getCur_temp();
		double temperatureDifference;
		double resultantTemperature = 0;
		if(Thermostat.dtls.getMode().equals(Mode.HIGH))
			count=3;
		else if (Thermostat.dtls.getMode().equals(Mode.MEDIUM))
			count =2;
		else
			count=1;
		if (Thermostat.dtls.ac_type.equals("Cool")) {
			while(count>0)
			{
			temperatureDifference = condenser.getTemperatureDifference(currentTemperature)
					- evaporator.getTemperatureDifference(currentTemperature);
			resultantTemperature = currentTemperature - temperatureDifference;
			count--;
			}
		}
		else if(Thermostat.dtls.ac_type.equals("Heat"))
		{
			while(count>0)
			{
			temperatureDifference = condenser.getTemperatureDifference(currentTemperature) -evaporator.getTemperatureDifference(currentTemperature);
			resultantTemperature = currentTemperature + temperatureDifference;
			count--;
			}
		}
		else
			resultantTemperature = currentTemperature;
		Thermostat.dtls.setResult_temp(resultantTemperature);
	}

	@Override
	public void run() {
		calculateUpdateTemp();
	}
	
	
}
