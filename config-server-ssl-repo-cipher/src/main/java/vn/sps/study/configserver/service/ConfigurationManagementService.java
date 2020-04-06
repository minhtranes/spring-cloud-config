/*
 * Class: ConfigurationManagementService
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
package vn.sps.study.configserver.service;

/**
 * The Interface ConfigurationManagementService.
 */
public interface ConfigurationManagementService {

    /**
     * Commit and push.
     *
     * @param application the application
     * @param profile the profile
     * @param label the label
     * @param message the commit message
     * @throws Exception the exception
     */
    void commitAndPush(String application, String profile, String label, String message) throws Exception;

}