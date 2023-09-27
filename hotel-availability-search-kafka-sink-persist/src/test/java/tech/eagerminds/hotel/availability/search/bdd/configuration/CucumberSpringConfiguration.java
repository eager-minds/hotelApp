package tech.eagerminds.hotel.availability.search.bdd.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import tech.eagerminds.hotel.availability.search.HotelAvailabilitySearchKafkaSinkPersistApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = {HotelAvailabilitySearchKafkaSinkPersistApplication.class})
@Import({TestChannelBinderConfiguration.class})
public class CucumberSpringConfiguration {

}