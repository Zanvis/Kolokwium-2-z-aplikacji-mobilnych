package vistula.ap.l11_piwowarski_62024_kol2;

public class ConverterToolsap {
    public static double convertTemperatureap(double valueap, String fromap, String toap) {
        if (fromap.equals(toap)) {
            return valueap;
        }

        double celsiusValueap;
        switch (fromap) {
            case "FAHRENHEIT":
                celsiusValueap = (valueap - 32) * 5 / 9;
                break;
            case "KELVIN":
                celsiusValueap = valueap - 273.15;
                break;
            default:
                celsiusValueap = valueap;
        }

        switch (toap) {
            case "FAHRENHEIT":
                return (celsiusValueap * 9 / 5) + 32;
            case "KELVIN":
                return celsiusValueap + 273.15;
            default:
                return celsiusValueap;
        }
    }
}
