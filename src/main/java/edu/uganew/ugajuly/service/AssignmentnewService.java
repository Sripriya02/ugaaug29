package edu.uganew.ugajuly.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.uganew.ugajuly.entity.Assignmentnew;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssignmentnewService {

    List<Assignmentnew> getAllAssignments();
    Assignmentnew addAssignment(Assignmentnew assignmentnew);


}
