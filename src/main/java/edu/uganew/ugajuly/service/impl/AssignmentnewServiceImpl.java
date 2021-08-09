package edu.uganew.ugajuly.service.impl;

import edu.uganew.ugajuly.entity.Advisor;
import edu.uganew.ugajuly.entity.Assignmentnew;
import edu.uganew.ugajuly.entity.Major;
import edu.uganew.ugajuly.repository.AssignmentnewRepository;
import edu.uganew.ugajuly.service.AssignmentnewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AssignmentnewServiceImpl implements AssignmentnewService {

    @Autowired
    private AssignmentnewRepository assignmentnewRepository;

    public AssignmentnewServiceImpl(AssignmentnewRepository assignmentnewRepository) {
        this.assignmentnewRepository = assignmentnewRepository;
    }

    @Override
    public List<Assignmentnew> getAllAssignments() {
        return assignmentnewRepository.findAll();
    }


    public Assignmentnew addAssignment(Assignmentnew assignmentnew) {
//        assignmentnew.setAdvisorCode(UUID.randomUUID().toString());
        return assignmentnewRepository.save(assignmentnew);
    }
    List<Assignmentnew> assignmentnewList = new ArrayList<>();
    public void addAlpha(String alpha1,String alpha2)
    {

//        System.out.println(alpha1+" "+alpha2);
//        new Assignmentnew(alpha1,alpha2,advisor,major).add(alpha1,alpha2);
        Advisor advisor = new Advisor();
        Major major = new Major();
        this.assignmentnewList.add(new Assignmentnew(alpha1,alpha2,advisor,major));
    }




//    @Override
//    public Assignmentnew saveAssignment(Assignmentnew assignmentnew) {
//
//        System.out.println("assignmentnew"+assignmentnew);
//        return assignmentnewRepository.save(assignmentnew);
//    }
}
