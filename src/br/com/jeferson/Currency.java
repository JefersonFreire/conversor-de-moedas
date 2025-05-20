package br.com.jeferson;

import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("base_code")
    private String baseCurrency;
    @SerializedName("target_code")
    private String targetCurrency;
    @SerializedName("conversion_rate")
    private double conversionRate;

    public double converterAmount(double amount) {
        return this.conversionRate * amount;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public double getConversionRate() {
        return conversionRate;
    }
}
