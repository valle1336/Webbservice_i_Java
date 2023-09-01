package com.alex.dag1.models.SMHI;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Date;

public class TimeSeries {

    public Date validTime;
    public ArrayList<Parameter> parameters;

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }
}
