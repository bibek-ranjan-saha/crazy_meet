package com.crazylabs.crazy_meet.repository;

import com.crazylabs.crazy_meet.model.MeetData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MeetRepository extends JpaRepository<MeetData,String> {
}
