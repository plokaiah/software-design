package Sensors;

import DisplaySystem.Thermostat;

public class Humidity_Sensor implements Runnable {
	double cur_humidity;

	public void calculateHum(double hum1, double hum2)
	{
		cur_humidity   = (hum1+hum2)/2;
		Thermostat.dtls.setCur_hum(cur_humidity);
		
	}

	@Override
	public void run() {
		calculateHum(Thermostat.dtls.getSensor_hum_1(),Thermostat.dtls.getSensor_hum_2());
	}

}
