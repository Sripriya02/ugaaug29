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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private AssignmentnewRepository assignmentnewRepository;

    @Autowired
    private AdvisorRepository advisorRepository;

    @Autowired
    private MajorRepository majorRepository;

    @GetMapping("/assignments")
    public String listAssignment(Model model)
    {
        model.addAttribute("assignments", assignmentnewRepository.findAll());
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
    public String saveAssignment(Assignmentnew assignmentnew)
    {
        assignmentnewRepository.save(assignmentnew);
        return "redirect:/assignments";
    }

//    @GetMapping("/findByStuName/{stuName}/{majorname}")
//    public ResponseEntity<List<Advisor>> findByStuLastName (@PathVariable("majorname") String majorid, @PathVariable("stuName") String stuName) {
//        List<Advisor> advisors = advisorService.findByStuLastName(majorid, stuName);
//        return new ResponseEntity<>(advisors, HttpStatus.OK);
//    }

//    @PostMapping("/assignments/add")
//    public ResponseEntity<Assignmentnew> addAssignment(@RequestBody Assignmentnew assignmentnew) {
//        Assignmentnew newAssignment = assignmentnewService.addAssignment(assignmentnew);
//        return new ResponseEntity<>(newAssignment, HttpStatus.CREATED);
//    }


}
