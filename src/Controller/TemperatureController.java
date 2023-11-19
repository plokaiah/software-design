package Controller;
import Controller.EnumClass.FanMode;
import DisplaySystem.Thermostat;

public class TemperatureController implements Runnable {
	
	
	
	public void get_TempControls(double des_temp, double cur_temp)
	{
		if(des_temp>cur_temp)
		{
			Thermostat.dtls.ac_type = "Heat";
			Thermostat.dtls.fanMode1 = FanMode.ON;
		}
		else if(des_temp<cur_temp)
		{
			Thermostat.dtls.ac_type = "Cool";
			Thermostat.dtls.fanMode1 = FanMode.ON;
		}
		else
		{
			Thermostat.dtls.ac_type = "OFF";
			Thermostat.dtls.fanMode1 = FanMode.OFF;
		}
		
		
	}

	@Override
	public void run() {
		get_TempControls(Thermostat.dtls.getDesired_temp(), Thermostat.dtls.getCur_temp());
	}

}
