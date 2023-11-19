package Controller;

import Controller.EnumClass.Mode;
import DisplaySystem.Thermostat;

public class ModeController implements Runnable {
	
	
	public void modeCalculate(double des_temp, double curr_temp)
	{
		double diff = curr_temp-des_temp;
		Mode mode = null;
		if(Math.abs(diff)>10)
			mode = Mode.HIGH;
		else if(Math.abs(diff)>5)
			mode = Mode.MEDIUM;
		else if(Math.abs(diff)>0)
			mode = Mode.LOW;
		else
			mode = Mode.NTG;
		Thermostat.dtls.setMode(mode);
	}

	@Override
	public void run() {
		modeCalculate(Thermostat.dtls.getDesired_temp(), Thermostat.dtls.getCur_temp());
	}
}
