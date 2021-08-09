package edu.uganew.ugajuly.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.uganew.ugajuly.entity.Advisor;
import edu.uganew.ugajuly.entity.Assignmentnew;
import edu.uganew.ugajuly.entity.Major;
import edu.uganew.ugajuly.repository.AdvisorRepository;
import edu.uganew.ugajuly.repository.AssignmentnewRepository;
import edu.uganew.ugajuly.repository.MajorRepository;
import edu.uganew.ugajuly.service.AdvisorService;
import edu.uganew.ugajuly.service.AssignmentnewService;
import edu.uganew.ugajuly.service.MajorService;
import edu.uganew.ugajuly.service.impl.AssignmentnewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AssignmentnewController {
//    @Autowired
//    private AssignmentnewService assignmentnewService;
//    @Autowired
//    private AdvisorService advisorService;
//
//    public AssignmentnewController(AssignmentnewService assignmentnewService) {
//        this.assignmentnewService = assignmentnewService;
//        this.advisorService = advisorService;
//    }
//
    @Autowired
    private AdvisorService advisorService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private AssignmentnewServiceImpl assignmentnewService;

    @Autowired
    private AssignmentnewRepository assignmentnewRepository;

    @Autowired
    private AdvisorRepository advisorRepository;

    @Autowired
    private MajorRepository majorRepository;

    @GetMapping("/assignments")
    public String listAssignment(Model model,String keyword)
    {
        if(keyword != null)
        {
            model.addAttribute("assignments",assignmentnewRepository.findByKeyword(keyword));
        }
        else
        {
            model.addAttribute("assignments", assignmentnewRepository.findAll());
        }
        return "assignmentslist";
    }

    @GetMapping("/assignments/new")
    public String addassignment(Model model)
    {
//        Assignmentnew assignmentnew = new Assignmentnew();
        List<Advisor> advisorslist=advisorRepository.findAll();
        List<Major> majorList=majorRepository.findAll();
        model.addAttribute("assignmentnew",new Assignmentnew());
        model.addAttribute("advisorslist",advisorslist);
        model.addAttribute("majorslist",majorList);
        return "create_assignment";
    }

    @PostMapping("/assignments/save")
    public String saveAssignment(Assignmentnew assignmentnew, HttpServletRequest request)
    {
        String[] alpha1 = request.getParameterValues("alpha1");
        String[] alpha2 = request.getParameterValues("alpha2");
        for(int i=0;i< alpha1.length;i++)
        {
//            System.out.println(alpha1.length);
//            assignmentnew.add(alpha1[i],alpha2[i]);
            assignmentnewService.addAlpha(alpha1[i],alpha2[i]);
        }
        assignmentnewRepository.save(assignmentnew);
        return "redirect:/assignments";
    }
    @GetMapping("/assignments/edit/{assignmentid}")
    public String editAssignmentForm(@PathVariable Integer assignmentid,Model model)
    {
        Assignmentnew assignmentnew = assignmentnewRepository.findById(assignmentid).get();
        model.addAttribute("assignmentnew",assignmentnew);
        List<Advisor> advisorslist=advisorRepository.findAll();
        List<Major> majorList=majorRepository.findAll();
        model.addAttribute("advisorslist",advisorslist);
        model.addAttribute("majorslist",majorList);
        return "assignment_advisor";
    }

    @PostMapping("/assignments/{assignmentid}")
    public String updateAssignment(@PathVariable Integer assignmentid, @ModelAttribute("assignmentnew") Assignmentnew assignmentnew)
    {
        //get assignment from database by id
        Assignmentnew existingAssignment = assignmentnewRepository.findById(assignmentid).get();
        existingAssignment.setAssignmentid(assignmentnew.getAssignmentid());
        existingAssignment.setMajor(assignmentnew.getMajor());
        existingAssignment.setAdvisor(assignmentnew.getAdvisor());
        existingAssignment.setAlpha1(assignmentnew.getAlpha1());
        existingAssignment.setAlpha2(assignmentnew.getAlpha2());
        //save update advisor object
        assignmentnewRepository.save(existingAssignment);
        System.out.println("Record Updated");
        return "redirect:/assignments";
    }
    //handler method to handle delete advisor
    @GetMapping("/assignments/{assignmentid}")
    public String deleteAssignment(@PathVariable Integer assignmentid)
    {
        assignmentnewRepository.deleteById(assignmentid);
        return "redirect:/assignments";
    }


}
