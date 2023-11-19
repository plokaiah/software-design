package Controller;

import DisplaySystem.Thermostat;

public class ControllerThreadManager {

	public void calculateResultantTemp() throws Exception {
		TemperatureController tc = new TemperatureController();
		Thread tcThread = new Thread(tc);
		tcThread.start();
		System.out.println("===Thread TemperatureController Started===");
		HumidityController hc = new HumidityController();
		Thread hcThread = new Thread(hc);
		hcThread.start();
		System.out.println("===Thread HumidityController Started===");
		ModeController mc = new ModeController();
		Thread mcThread = new Thread(mc);
		mcThread.start();
		System.out.println("===Thread ModeController Started===");
		tcThread.join();
		System.out.println("===Thread TemperatureController Completed===");
		System.out.println("Ac Type: "+Thermostat.dtls.getAc_type());
		System.out.println("Fan Mode 1: "+Thermostat.dtls.getFanMode1());
		hcThread.join();
		System.out.println("===Thread HumidityController Completed===");
		System.out.println("Fan Mode 2: "+Thermostat.dtls.getFanMode2());
		mcThread.join();
		System.out.println("===Thread ModeController Completed===");
		System.out.println("Mode: "+Thermostat.dtls.getMode());
		AirController ac = new AirController();
		Thread acThread = new Thread(ac);
		acThread.start();
		System.out.println("===Thread AirController Started===");
		acThread.join();
		System.out.println("===Thread AirController Completed===");
		System.out.println("Result Fan Mode: "+Thermostat.dtls.getRes_fanMode());
		System.out.println("Result Temperature: "+Thermostat.dtls.getResult_temp());
	}
}
