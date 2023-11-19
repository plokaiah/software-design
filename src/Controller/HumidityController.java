package Controller;

import Controller.EnumClass.FanMode;
import DisplaySystem.Thermostat;

public class HumidityController implements Runnable {
	
	public void checkHumidity(double curHumidity)
	{
		if(curHumidity>60)
		{
			Thermostat.dtls.fanMode2 = FanMode.ON;
			return;
		}
		
		Thermostat.dtls.fanMode2 = FanMode.OFF;
	}

	@Override
	public void run() {
		checkHumidity(Thermostat.dtls.getCur_hum());
	}
}
