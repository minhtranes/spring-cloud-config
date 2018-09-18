/*
 * Class: ConfigurationManagementController
 *
 * Created on Sep 18, 2018
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.sps.study.configserver.model.CommitRequestInfo;
import vn.sps.study.configserver.service.ConfigurationManagementService;

@RestController
@RequestMapping("/configuration")
public class ConfigurationManagementController {

    @Autowired
    private ConfigurationManagementService configurationManagementService;

    @PostMapping("/push")
    public void push(@RequestBody final CommitRequestInfo info)
            throws Exception {
        this.configurationManagementService.commitAndPush(
            info.getApplication(),
            info.getProfile(),
            info.getLabel(),
            info.getMessage());
    }
}
