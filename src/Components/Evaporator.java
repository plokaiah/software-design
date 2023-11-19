package Components;

public class Evaporator {
    private double heatTransferCoefficient;
    private double refrigerantFlowRate;

    public Evaporator(double heatTransferCoefficient, double refrigerantFlowRate) {
        this.heatTransferCoefficient = heatTransferCoefficient;
        this.refrigerantFlowRate = refrigerantFlowRate;
    }

    public double getTemperatureDifference(double temperature) {
        double refrigerantTemperature = temperature - 20; // assume refrigerant temperature is 10 degrees lower than room temperature
        double heatTransfer = heatTransferCoefficient * refrigerantFlowRate * (refrigerantTemperature);
        double temperatureDifference = heatTransfer / (1000 * 4.18); // assume air has a heat capacity of 4.18 J/g-K
        return temperatureDifference;
    }
}
