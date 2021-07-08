package com.bug.free.invention.api.classes;

public class Job {
    int Job_ID;
    String Job_Title;
    String Job_Spec;
    int Band_ID;
    int Capability_ID;

    public Job(int job_ID, String job_Title, String job_Spec, int band_ID, int capability_ID) {
        Job_ID = job_ID;
        Job_Title = job_Title;
        Job_Spec = job_Spec;
        Band_ID = band_ID;
        Capability_ID = capability_ID;
    }

    public Job(int job_ID, String job_Title, int band_ID, int capability_ID) {
        Job_ID = job_ID;
        Job_Title = job_Title;
        Band_ID = band_ID;
        Capability_ID = capability_ID;
    }

    public int getJob_ID() {
        return Job_ID;
    }

    public void setJob_ID(int job_ID) {
        Job_ID = job_ID;
    }

    public String getJob_Title() {
        return Job_Title;
    }

    public void setJob_Title(String job_Title) {
        Job_Title = job_Title;
    }

    public String getJob_Spec() {
        return Job_Spec;
    }

    public void setJob_Spec(String job_Spec) {
        Job_Spec = job_Spec;
    }

    public int getBand_ID() {
        return Band_ID;
    }

    public void setBand_ID(int band_ID) {
        Band_ID = band_ID;
    }

    public int getCapability_ID() {
        return Capability_ID;
    }

    public void setCapability_ID(int capability_ID) {
        Capability_ID = capability_ID;
    }
}
