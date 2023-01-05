package enums;

import java.math.BigDecimal;

public enum TaxiType {
    STANDART(50,100),
    COMFORT(60,200),
    BUSINESS(80,300);

    private BigDecimal pricePerKm;

    private BigDecimal priceForLanding;

    TaxiType(BigDecimal pricePerKm, BigDecimal priceForLanding) {
        this.pricePerKm = pricePerKm;
        this.priceForLanding = priceForLanding;
    }

    TaxiType(int i, int i1) {
    }

    public BigDecimal getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(BigDecimal pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public BigDecimal getPriceForLanding() {
        return priceForLanding;
    }

    public void setPriceForLanding(BigDecimal priceForLanding) {
        this.priceForLanding = priceForLanding;
    }

    @Override
    public String toString() {
        return "TaxiType{" +
                "pricePerKm=" + pricePerKm +
                ", priceForLanding=" + priceForLanding +
                '}';
    }
}
