package com.crazylabs.crazy_meet.controller;

import com.crazylabs.crazy_meet.model.CreateMeetingRequest;
import com.crazylabs.crazy_meet.model.JoinMeetingRequest;
import com.crazylabs.crazy_meet.model.MeetData;
import com.crazylabs.crazy_meet.repository.MeetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CrazyMeetController {

    @Autowired
    MeetRepository repository;

    @GetMapping("/get-meeting-by-id/{id}")
    public MeetData getMeetingById(@PathVariable("id") String  id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/create-meeting")
    public MeetData createMeeting(@RequestBody CreateMeetingRequest request) {
        MeetData meetData = new MeetData();
        meetData.setCallerSDP(request.sdp);
        String meetId = generateMeetId();
        meetData.setMeetId(meetId);
        repository.save(meetData);
        return meetData;
    }

    @PostMapping("/join-meeting")
    public MeetData joinMeeting(@RequestBody JoinMeetingRequest request) {
        MeetData meetData = repository.findById(request.id).orElse(null);
        assert meetData != null;
        meetData.setCalleeSDP(request.calleeSDP);
        repository.save(meetData);
        return meetData;
    }

    String generateMeetId() {
        return UUID.randomUUID().toString();
    }
}
