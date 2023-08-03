package com.example.rocketmqandrabbitmq.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.rocketmqandrabbitmq.Entity.MessageData;

@Mapper
public interface DeviceMapper {
    
    @Insert("INSERT INTO  mqtt_hello (message) VALUES (#{message})")
    void insertDeviceData(@Param("message") String message);


    @Insert("INSERT INTO mqtt_data (temp, pressure, amp, status) VALUES (#{data.Temp}, #{data.pressure}, #{data.amp}, #{data.status})")
    void insertDeviceData2(@Param("data") MessageData data);

}
