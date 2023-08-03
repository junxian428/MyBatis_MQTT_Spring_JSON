# MQTT_MyBatis_MySQL_Spring

Unit Testing

mosquitto_pub -t Hello -m "testing"


Requirement:

Temp, pressure, amp, valve open/close status

{"Temp": 28.0,"pressure": 50.0,"amp" : 10.0,"status": "Open"}

mosquitto_pub -t Hello -m "{\"Temp\": 28.0, \"pressure\": 50.0, \"amp\": 10.0, \"status\": \"Open\"}"

mosquitto_pub -t Hello -m '{\"Temp\": 18.0, \"pressure\": 20.0, \"amp\": 50.0, \"status\": \"Close\"}'

CREATE TABLE mqtt_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    temp DOUBLE NOT NULL,
    pressure DOUBLE NOT NULL,
    amp DOUBLE NOT NULL,
    status VARCHAR(50) NOT NULL
);


