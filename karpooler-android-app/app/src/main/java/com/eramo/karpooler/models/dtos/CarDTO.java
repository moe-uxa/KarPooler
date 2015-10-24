package com.eramo.karpooler.models.dtos;

/**
 * Created by Mohamed.Gaber on 10/24/2015.
 */
public class CarDTO {

    private int brandId;
    private int modelId;
    private String modelYear;
    private int plateTypeId;
    private String plateNumbers;
    private String plateChars;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public int getPlateTypeId() {
        return plateTypeId;
    }

    public void setPlateTypeId(int plateTypeId) {
        this.plateTypeId = plateTypeId;
    }

    public String getPlateNumbers() {
        return plateNumbers;
    }

    public void setPlateNumbers(String plateNumbers) {
        this.plateNumbers = plateNumbers;
    }

    public String getPlateChars() {
        return plateChars;
    }

    public void setPlateChars(String plateChars) {
        this.plateChars = plateChars;
    }
}
