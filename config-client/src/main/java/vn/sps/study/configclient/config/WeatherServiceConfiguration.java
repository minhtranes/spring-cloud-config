/*
 * Class: WeatherServiceConfiguration
 *
 * Created on May 16, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.sps.study.configclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherServiceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "service.weather")
    WeatherServiceProperties weatherServiceProperties() {
        return new WeatherServiceProperties();
    }
}
