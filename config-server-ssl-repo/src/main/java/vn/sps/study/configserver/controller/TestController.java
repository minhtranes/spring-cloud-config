/*
 * Class: TestController
 *
 * Created on Dec 25, 2018
 *
 * (c) Copyright Swiss Post Solutions Ltd, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.sps.study.configserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.sps.study.configserver.config.TestProperties;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestProperties testProperties;

    @GetMapping("/properties")
    TestProperties properties() {
        return testProperties;
    }
}
