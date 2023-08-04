package com.example.rocketmqandrabbitmq.Entity;

public class Valve {
    private String device;
    private double Temp;
    private double pressure;
    private double amp;
    private String status;
    private String valve1;
    private String valve1_status;
    private String valve2;
    private String valve2_status;
    private String valve3;
    private String valve3_status;
    private String timer1;
    private String timer2;
    public Valve(String device, double temp, double pressure, double amp, String status, String valve1,
            String valve1_status, String valve2, String valve2_status, String valve3, String valve3_status,
            String timer1, String timer2) {
        this.device = device;
        Temp = temp;
        this.pressure = pressure;
        this.amp = amp;
        this.status = status;
        this.valve1 = valve1;
        this.valve1_status = valve1_status;
        this.valve2 = valve2;
        this.valve2_status = valve2_status;
        this.valve3 = valve3;
        this.valve3_status = valve3_status;
        this.timer1 = timer1;
        this.timer2 = timer2;
    }
    public String getDevice() {
        return device;
    }
    public void setDevice(String device) {
        this.device = device;
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
    public String getValve1() {
        return valve1;
    }
    public void setValve1(String valve1) {
        this.valve1 = valve1;
    }
    public String getValve1_status() {
        return valve1_status;
    }
    public void setValve1_status(String valve1_status) {
        this.valve1_status = valve1_status;
    }
    public String getValve2() {
        return valve2;
    }
    public void setValve2(String valve2) {
        this.valve2 = valve2;
    }
    public String getValve2_status() {
        return valve2_status;
    }
    public void setValve2_status(String valve2_status) {
        this.valve2_status = valve2_status;
    }
    public String getValve3() {
        return valve3;
    }
    public void setValve3(String valve3) {
        this.valve3 = valve3;
    }
    public String getValve3_status() {
        return valve3_status;
    }
    public void setValve3_status(String valve3_status) {
        this.valve3_status = valve3_status;
    }
    public String getTimer1() {
        return timer1;
    }
    public void setTimer1(String timer1) {
        this.timer1 = timer1;
    }
    public String getTimer2() {
        return timer2;
    }
    public void setTimer2(String timer2) {
        this.timer2 = timer2;
    }
}
