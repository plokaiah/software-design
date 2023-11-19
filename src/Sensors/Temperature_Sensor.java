package Sensors;

import DisplaySystem.Thermostat;

public class Temperature_Sensor implements Runnable {

	double curr_temp;
	
	public void calculateTemp(double temp1, double temp2)
	{
		curr_temp = (temp1+temp2)/2;
		Thermostat.dtls.setCur_temp(curr_temp);
	}

	@Override
	public void run() {
		calculateTemp(Thermostat.dtls.getSensor_temp_1(),Thermostat.dtls.getSensor_temp_2());
	}

}
