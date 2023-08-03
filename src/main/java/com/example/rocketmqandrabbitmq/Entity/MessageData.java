package com.example.rocketmqandrabbitmq.Entity;

public class MessageData {

    private double Temp;
    private double pressure;
    private double amp;
    private String status;
    public MessageData(){
        
    }
    public MessageData(double temp, double pressure, double amp, String status) {
        Temp = temp;
        this.pressure = pressure;
        this.amp = amp;
        this.status = status;
    }
    public double getTemp() {
        return Temp;
    }
    public void setTemp(double temp) {
        Temp = temp;
    }
    public double getPressure() {
        return pressure;
    }
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
    public double getAmp() {
        return amp;
    }
    public void setAmp(double amp) {
        this.amp = amp;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
