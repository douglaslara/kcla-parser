package com.sap.bradesco.kcla;

import java.util.StringTokenizer;

public class KclaBean {

    private String businessPartner;
    private String insuranceObject;
    private String column2;
    private String column6;
    private String column9;

    public KclaBean(String line) {
        String[] tokens = line.split(";");
        this.column2 = tokens[0];
        this.businessPartner = tokens[1];
        this.column6 = tokens[2];
        this.column9 = tokens[3];
        this.insuranceObject = tokens[4];
    }

    public String toString(){
        return column2 + ";" +  businessPartner + ";" + column6 + ";" + column9 + ";" + insuranceObject;
    }

    public String getBusinessPartner() {
        return businessPartner;
    }

    public void setBusinessPartner(String businessPartner) {
        this.businessPartner = businessPartner;
    }

    public String getInsuranceObject() {
        return insuranceObject;
    }

    public void setInsuranceObject(String insuranceObject) {
        this.insuranceObject = insuranceObject;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn6() {
        return column6;
    }

    public void setColumn6(String column6) {
        this.column6 = column6;
    }

    public String getColumn9() {
        return column9;
    }

    public void setColumn9(String column9) {
        this.column9 = column9;
    }

    @Override
    public int hashCode() {
        return businessPartner.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!KclaBean.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final KclaBean other = (KclaBean) obj;
        if ((this.businessPartner == null) ? (other.businessPartner != null) : !this.businessPartner.equals(other.businessPartner)) {
            return false;
        }

        return true;
    }

}
