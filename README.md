# MQTT_MyBatis_MySQL_Spring

Unit Testing

mosquitto_pub -t Hello -m "testing"


Requirement:

Temp, pressure, amp, valve open/close status

{"Temp": 28.0,"pressure": 50.0,"amp" : 10.0,"status": "Open"}

mosquitto_pub -t Hello -m "{\"Temp\": 28.0, \"pressure\": 50.0, \"amp\": 10.0, \"status\": \"Open\"}"

mosquitto_pub -t Hello -m '{\"Temp\": 18.0, \"pressure\": 20.0, \"amp\": 50.0, \"status\": \"Close\"}'

Development Environment

 mosquitto_pub -t Hello -m '{\"device\": \"DeviceName\",\"Temp\": 25.5,\"pressure\": 1013.25,\"amp\": 3.14,\"status\": \"Status\",\"valve1\": \"Valve1Name\",\"valve1_status\": \"Valve1Status\",\"valve2\": \"Valve2Name\",\"valve2_status\": \"Valve2Status\",\"valve3\": \"Valve3Name\",\"valve3_status\": \"Valve3Status\",\"timer1\": \"Timer1Value\",\"timer2\": \"Timer2Value\"}'
 

Production Environment

  mosquitto_pub -h X.X.X.X -p 1883 -t Hello -m '{\"device\": \"NX Series\",\"Temp\": 25.5,\"pressure\": 1013.25,\"amp\": 3.14,\"status\": \"Ok\",\"valve1\": \"OMRON\",\"valve1_status\": \"OMRON\",\"valve2\": \"OMRON\",\"valve2_status\": \"Siemen\",\"valve3\": \"OMRON\",\"valve3_status\": \"OMRON\",\"timer1\": \"OMRON\",\"timer2\": \"OMRON\"}'

{
  \"device\": \"DeviceName\",
  \"Temp\": 25.5,
  \"pressure\": 1013.25,
  \"amp\": 3.14,
  \"status\": \"Status\",
  \"valve1\": \"Valve1Name\",
  \"valve1_status\": \"Valve1Status\",
  \"valve2\": \"Valve2Name\",
  \"valve2_status\": \"Valve2Status\",
  \"valve3\": \"Valve3Name\",
  \"valve3_status": \"Valve3Status\",
  \"timer1\": \"Timer1Value\",
  \"timer2\": \"Timer2Value\"

}

'{\"device\": \"DeviceName\",\"Temp\": 25.5,\"pressure\": 1013.25,\"amp\": 3.14,\"status\": \"Status\",\"valve1\": \"Valve1Name\",\"valve1_status\": \"Valve1Status\",\"valve2\": \"Valve2Name\",\"valve2_status\": \"Valve2Status\",\"valve3\": \"Valve3Name\",\"valve3_status": \"Valve3Status\",\"timer1\": \"Timer1Value\",\"timer2\": \"Timer2Value\"}'

CREATE TABLE mqtt_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    temp DOUBLE NOT NULL,
    pressure DOUBLE NOT NULL,
    amp DOUBLE NOT NULL,
    status VARCHAR(50) NOT NULL
);



CREATE TABLE iot_valve (
    id INT PRIMARY KEY AUTO_INCREMENT,
    device VARCHAR(255),
    Temp DOUBLE,
    pressure DOUBLE,
    amp DOUBLE,
    status VARCHAR(50),
    valve1 VARCHAR(50),
    valve1_status VARCHAR(50),
    valve2 VARCHAR(50),
    valve2_status VARCHAR(50),
    valve3 VARCHAR(50),
    valve3_status VARCHAR(50),
    timer1 VARCHAR(50),
    timer2 VARCHAR(50)
);


INSERT INTO your_table_name (
    device,
    Temp,
    pressure,
    amp,
    status,
    valve1,
    valve1_status,
    valve2,
    valve2_status,
    valve3,
    valve3_status,
    timer1,
    timer2
) VALUES (
    'DeviceName',
    25.5,
    1013.25,
    3.14,
    'Status',
    'Valve1Name',
    'Valve1Status',
    'Valve2Name',
    'Valve2Status',
    'Valve3Name',
    'Valve3Status',
    'Timer1Value',
    'Timer2Value'
);


-- Retrieve all rows from the table
SELECT * FROM your_table_name;

-- Retrieve specific rows based on a condition (e.g., where the device name is 'DeviceName')
SELECT * FROM your_table_name WHERE device = 'DeviceName';

-- Retrieve specific columns (e.g., device and Temp) from the table
SELECT device, Temp FROM your_table_name;



-- Update a specific row based on the id (e.g., id = 1)
UPDATE your_table_name
SET Temp = 30.2,
    pressure = 1000.5,
    status = 'UpdatedStatus'
WHERE id = 1;

-- Delete a specific row based on the id (e.g., id = 1)
DELETE FROM your_table_name WHERE id = 1;



![image](https://github.com/junxian428/MyBatis_MQTT_Spring_JSON/assets/58724748/05650c7d-9c32-47ed-940c-413060aeca9d)


