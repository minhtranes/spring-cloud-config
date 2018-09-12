/*
 * Class: WeatherServiceController
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
package vn.sps.study.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.sps.study.configclient.config.WeatherServiceProperties;

@RestController
public class WeatherServiceController {

    @Autowired
    private WeatherServiceProperties weatherServiceProperties;

    @GetMapping("/properties")
    public WeatherServiceProperties getServiceProperties() {
        return weatherServiceProperties;
    }
}
