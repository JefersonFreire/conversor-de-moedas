package br.com.jeferson;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("base_code")
    private String baseCurrency;
    @SerializedName("target_code")
    private String targetCurrency;
    @SerializedName("conversion_rate")
    private double conversionRate;
    @SerializedName("conversion_result")
    private double conversionResult;

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double getConversionResult() {
        return conversionResult;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "baseCurrency='" + baseCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", conversionRate=" + conversionRate +
                ", conversionResult=" + conversionResult +
                '}';
    }
}
