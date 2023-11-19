package Sensors;

import DisplaySystem.Thermostat;

public class SensorThreadManager {

	public void getSensorValue() throws Exception {
		Temperature_Sensor ts = new Temperature_Sensor();
		Thread tsThread = new Thread(ts);
		tsThread.start();

		Humidity_Sensor hs = new Humidity_Sensor();
		Thread hsThread = new Thread(hs);
		hsThread.start();

		tsThread.join();

		hsThread.join();
	}

}
