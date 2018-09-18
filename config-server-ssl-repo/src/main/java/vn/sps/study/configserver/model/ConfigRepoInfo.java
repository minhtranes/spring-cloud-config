/*
 * Class: ConfigRepoInfo
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
package vn.sps.study.configserver.model;

public class ConfigRepoInfo {
    private String application;

    private String label;

    private String profile;

    public String getApplication() {
        return this.application;
    }

    public String getLabel() {
        return this.label;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setApplication(final String application) {
        this.application = application;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public void setProfile(final String profile) {
        this.profile = profile;
    }

}
