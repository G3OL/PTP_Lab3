package gr.upatras.rest.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class Controller {
    private static final Logger log = LoggerFactory.getLogger(Controller.class);

    @RequestMapping(value = "/temp", produces = { "application/json;charset=utf-8" }, consumes = {"application/json;charset=utf-8" }, method = RequestMethod.POST)
    public ResponseEntity<Data> createProduct(@RequestBody Data temp) {
    	double myData = temp.getData();
        log.info( "Sending data: " + Double.toString(myData));
        SimpleMqttClient mqttClient = new SimpleMqttClient("gr/upatras/Ex_3/up1066523/");
        mqttClient.runClient(myData);

        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
}