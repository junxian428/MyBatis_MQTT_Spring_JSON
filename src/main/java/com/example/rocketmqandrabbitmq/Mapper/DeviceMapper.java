package com.example.rocketmqandrabbitmq.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.rocketmqandrabbitmq.Entity.MessageData;
import com.example.rocketmqandrabbitmq.Entity.Valve;

@Mapper
public interface DeviceMapper {
    



    @Insert("INSERT INTO mqtt_data (temp, pressure, amp, status) VALUES (#{data.Temp}, #{data.pressure}, #{data.amp}, #{data.status})")
    void insertDeviceData2(@Param("data") MessageData data);

    @Insert("INSERT INTO iot_valve (device, Temp, pressure, amp, status, valve1, valve1_status, valve2, valve2_status, valve3, valve3_status, timer1, timer2) " +
    "VALUES (#{data.device}, #{data.Temp}, #{data.pressure}, #{data.amp}, #{data.status}, #{data.valve1}, #{data.valve1_status}, #{data.valve2}, " +
    "#{data.valve2_status}, #{data.valve3}, #{data.valve3_status}, #{data.timer1}, #{data.timer2})")
    void insertDeviceData3(@Param("data") Valve data);

}
