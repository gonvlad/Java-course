package by.gsu.pms;
import  java.math.BigDecimal;
import java.math.RoundingMode;

public class Converter {
    public static BigDecimal convert(double value, int divisor, int scale) {
        BigDecimal bigDecimalValue = new BigDecimal(value);
        BigDecimal bigDecimalDivisor = new BigDecimal(divisor);
        return bigDecimalValue.divide(bigDecimalDivisor, scale, RoundingMode.HALF_UP);
    }
}
