package DisplaySystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.Scanner;

import Controller.ACDetails;
import Controller.ControllerThreadManager;
import Sensors.SensorThreadManager;

public class Thermostat {

	static double cur_hum=0;
	static double cur_temp = 0;
	static double des_temp=0;
	static double res_temp=0;
	public static ACDetails dtls;
	public static int tempLineNumber;
	public static int humLineNumber;
	
	
	public void readTempFileObjects() throws FileNotFoundException
	{
		Scanner fileScanner;
		fileScanner = new Scanner(new File("TempSensor.txt"));
		 for (int i = 0; i < tempLineNumber; i++) {
             if (fileScanner.hasNextLine()) {
            	 fileScanner.nextLine();
             } else {
                 break;
             }
         }
		while (fileScanner.hasNextLine()) {
			tempLineNumber++;
			String line = fileScanner.nextLine();
			String[] parts = line.split(":");
			if(parts[0].equals("S1"))
			{
				dtls.setSensor_temp_1(Double.parseDouble(parts[1]));
			//	System.out.println("Sesnsor 1 Temperature == "+parts[1]);
			}
			if(parts[0].equals("S2"))
			{
				dtls.setSensor_temp_2(Double.parseDouble(parts[1]));
			//	System.out.println("Sesnsor 2 Temperature == "+parts[1]);
			    break;
			}
		}
	}
	
	public void readHumFileObjects() throws FileNotFoundException
	{
		Scanner fileScanner;
		fileScanner = new Scanner(new File("HumiditySensor.txt"));
		 for (int i = 0; i < humLineNumber; i++) {
             if (fileScanner.hasNextLine()) {
            	 fileScanner.nextLine();
             } else {
                 break;
             }
         }
		while (fileScanner.hasNextLine()) {
			humLineNumber++;
			String line = fileScanner.nextLine();
			 if (line.trim().isEmpty()) {
                 continue; // Skip empty line
             }
			String[] parts = line.split(":");
			if(parts[0].equals("H1"))
			{
				dtls.setSensor_hum_1(Double.parseDouble(parts[1]));
			//	System.out.println("Sensor 1 Humdidity == "+parts[1]);
			}
			if(parts[0].equals("H2"))
			{
				dtls.setSensor_hum_2(Double.parseDouble(parts[1]));
			//	System.out.println("Sensor 2 Humdidity == "+parts[1]);
				break;
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		dtls = new ACDetails();
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter desired temperature");
		des_temp = s.nextDouble();
		Thermostat ts =  new Thermostat();
		ts.readTempFileObjects();
		ts.readHumFileObjects();
		SensorThreadManager sm = new SensorThreadManager();
		sm.getSensorValue();
		cur_temp = dtls.getCur_temp();
		cur_hum = dtls.getCur_hum();
		dtls.setDesired_temp(des_temp);
		int round =1;
		
		while((cur_temp!=des_temp && res_temp != des_temp) || cur_hum>60)
		{
			System.out.println();
			System.out.println("Round: "+round);
			System.out.println("Current Temperature == "+Thermostat.dtls.getCur_temp());
			System.out.println("Current Humidity == "+Thermostat.dtls.getCur_hum());
			ControllerThreadManager ct = new ControllerThreadManager();
			ct.calculateResultantTemp();
			Thread.sleep(3000);
			ts.readTempFileObjects();
			ts.readHumFileObjects();
			sm = new SensorThreadManager();
			sm.getSensorValue();
			cur_temp = dtls.getCur_temp();
			res_temp = Math.ceil(dtls.getResult_temp());
			cur_hum = dtls.getCur_hum();
			round++;
		}
	}
	
}
