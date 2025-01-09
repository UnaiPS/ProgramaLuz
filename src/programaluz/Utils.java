package programaluz;

import static java.lang.Math.floor;
import static java.lang.Math.round;

class Utils {
    private Utils() {
        throw new IllegalStateException("Utils class");
    }

    public static double calcularMes(int dias) {
        return (floor((dias / Constants.MEDIA_MES) * Constants.CIEN) / Constants.CIEN);
    }

    public static double roundAndDivideByHundred(double valor) {
        return round(valor)/Constants.CIEN;
    }
}
