import java.io.IOException;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/23/2016.
 */
public class JacksonGenericDataBinding {

    public static void main(String[] args) throws IOException {
        JacksonGenericDataBinding jacksonGenericDataBinding = new JacksonGenericDataBinding();
        jacksonGenericDataBinding.deserializeEvent();
    }

    public void deserializeEvent() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        Event event = objectMapper.readValue(getClass().getResourceAsStream("/event.json"), Event.class);
        System.out.println("Event ID ==>" + event.getDeviceID());
    }
}

class Event {

    private String deviceID;
    private String networkID;
    private OffsetDateTime eventTime;

    public Event() {
    }

    public Event(String deviceID, String networkID, OffsetDateTime eventTime) {
        this.deviceID = deviceID;
        this.networkID = networkID;
        this.eventTime = eventTime;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getNetworkID() {
        return networkID;
    }

    public void setNetworkID(String networkID) {
        this.networkID = networkID;
    }

    public OffsetDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(OffsetDateTime eventTime) {
        this.eventTime = eventTime;
    }
}