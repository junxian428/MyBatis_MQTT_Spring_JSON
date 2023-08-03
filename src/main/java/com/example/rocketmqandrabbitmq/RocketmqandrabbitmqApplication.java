package com.example.rocketmqandrabbitmq;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.rocketmqandrabbitmq.Entity.MessageData;
import com.example.rocketmqandrabbitmq.Mapper.DeviceMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


@EnableRabbit
@SpringBootApplication
public class RocketmqandrabbitmqApplication {

    private static final String BROKER_URL = "tcp://";


    public static void main(String[] args) {
        String[] topics = {"Topic1", "Topic2", "Topic3", "Topic4", "Topic5","Hello"};

        for (String topic : topics) {
            try {
                MQTTSubscriber subscriber = new MQTTSubscriber(topic);
                subscriber.start();
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }

		SpringApplication.run(RocketmqandrabbitmqApplication.class, args);
	}

}

class MqttPublisher {

    private String brokerUrl="tcp://192.168.10.48:1883";
    private String clientId = "1";
    private IMqttClient mqttClient;

    public MqttPublisher(){
        
    }

    public MqttPublisher(String brokerUrl, String clientId) {
        this.brokerUrl = brokerUrl;
        this.clientId = clientId;
    }

    public void connect() throws MqttException {
        mqttClient = new MqttClient(brokerUrl, clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        mqttClient.connect(options);
    }

    public void publish(String topic, String payload) throws MqttException {
        MqttMessage message = new MqttMessage(payload.getBytes());
        mqttClient.publish(topic, message);
    }

    public void disconnect() throws MqttException {
        mqttClient.disconnect();
    }
}

class MQTTSubscriber {
    private static final String BROKER_URL = "tcp://192.168.10.48:1883";
    private String topic;
    private DeviceMapper deviceMapper;

    public MQTTSubscriber(String topic) {
        this.topic = topic;
        
    }

    public void start() throws MqttException {
        MqttClient client = new MqttClient(BROKER_URL, MqttClient.generateClientId());
        System.out.println("MQTT Subscriber started for topic: " + topic);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);

        client.connect(options);

        //client.subscribe(topic);
		//client.subscribe(topic);
		client.subscribeWithResponse(topic,(IMqttMessageListener) new IMqttMessageListener() {
            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println("Received message for topic " + topic + ": " + message.toString());
                // You can add your own logic here to process the received data
                if(topic.equals("Topic1")){
                    System.out.println("SQL Topic 1 will be runn");
                } 
                

                if(topic.equals("Hello")){
                    System.out.println("Hello");
                    try{
                            // Create the SqlSessionFactory (assuming mybatis-config.xml is in the classpath)
                            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));

                            // Open a new SqlSession
                            SqlSession session = sessionFactory.openSession();
                                // Get an instance of DeviceMapper
                                DeviceMapper deviceMapper = session.getMapper(DeviceMapper.class);
                                
                                // Use the DeviceMapper to insert device data
                                deviceMapper.insertDeviceData(message.toString());
                                // Convert the message object to a JSON string
                                // Commit the transaction (if needed)
                                  // Convert JSON string to Java object
                                ObjectMapper objectMapper = new ObjectMapper();
                                    // Create a Gson object
                                //Gson gson = new Gson();
                                //System.out.println(message.toString());
                        // Parse the JSON string into a JSON object
                                JsonObject jsonObject = new Gson().fromJson(message.toString(), JsonObject.class);

                                // Extract the values of Temp, pressure, amp, and status
                                double temp = jsonObject.get("Temp").getAsDouble();
                                double pressure = jsonObject.get("pressure").getAsDouble();
                                double amp = jsonObject.get("amp").getAsDouble();
                                String status = jsonObject.get("status").getAsString();

                                // Print the extracted values
                                System.out.println("Temp: " + temp);
                                System.out.println("Pressure: " + pressure);
                                System.out.println("Amp: " + amp);
                                System.out.println("Status: " + status);

                                  // Parse the JSON string into a MessageData object
                                MessageData data = new Gson().fromJson(message.toString(), MessageData.class);

                                // Insert the data into the database
                                // Get your mapper instance (e.g., using MyBatis).
                                deviceMapper.insertDeviceData2(data);
                                // Convert the message object to a JSON string
                                //String jsonString = gson.toJson(message.toString());

                                //System.out.println(jsonString);
                                //System.out.println(jsonString);
                                //MessageData messageData = objectMapper.readValue(jsonString, MessageData.class);
                               //System.out.println(messageData.toString());

                        // Now you have the Java object
                             //   System.out.println("Temp: " + messageData.getTemp());
                              //  System.out.println("Pressure: " + messageData.getPressure());
                              //  System.out.println("Amp: " + messageData.getAmp());
                              //  System.out.println("Status: " + messageData.getStatus());



                                session.commit();
                                //MqttPublisher mqttPublisher = new MqttPublisher();
                                //mqttPublisher.connect();
                                //mqttPublisher.publish("GetHello", "Replies : " + message.toString());
                               // mqttPublisher.disconnect();
                      
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
        });
    }
}







