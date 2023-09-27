package tech.eagerminds.hotel.availability.search.bdd.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import tech.eagerminds.hotel.availability.search.HotelAvailabilitySearchMongodbApiApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = {HotelAvailabilitySearchMongodbApiApplication.class},
    webEnvironment = WebEnvironment.RANDOM_PORT)
public class CucumberSpringConfiguration {

}