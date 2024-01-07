package com.crazylabs.crazy_meet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "meet_data")
public class MeetData {
    @Id
    private String meetId;
    private String calleeSDP;
    private String callerSDP;


    public String getMeetId() {
        return meetId;
    }

    public void setMeetId(String meetId) {
        this.meetId = meetId;
    }

    public String getCalleeSDP() {
        return calleeSDP;
    }

    public void setCalleeSDP(String calleeSDP) {
        this.calleeSDP = calleeSDP;
    }

    public String getCallerSDP() {
        return callerSDP;
    }

    public void setCallerSDP(String callerSDP) {
        this.callerSDP = callerSDP;
    }
}
