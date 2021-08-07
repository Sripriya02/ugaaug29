package edu.uganew.ugajuly.controller;

import edu.uganew.ugajuly.entity.Advisor;
import edu.uganew.ugajuly.entity.Major;
import edu.uganew.ugajuly.service.AdvisorService;
import edu.uganew.ugajuly.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdvisorController {



    private Major major;

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
    @Autowired
    private AdvisorService advisorService;
    @Autowired
    private MajorService majorService;
    public AdvisorController(AdvisorService advisorService,MajorService majorService) {
        this.advisorService = advisorService;
        this.majorService = majorService;
    }




    @GetMapping("/advisors")
    public String listAdvisors(Model model)
    {
        model.addAttribute("advisors",advisorService.getAllAdvisors());
        return "advisors";
    }
    @GetMapping("/advisors/new")
    public String addadvisor(Model model)
    {
        Advisor advisor = new Advisor();
        model.addAttribute("advisor",advisor);
        return "create_advisor";
    }

    @PostMapping("/advisors")
    public String saveAdvisor(@ModelAttribute("advisor") Advisor advisor)
    {
        advisorService.saveAdvisor(advisor);
        return "redirect:/advisors";
    }

    @GetMapping("/advisors/edit/{id}")
    public String editAdvisorForm(@PathVariable Long id,Model model)
    {
    model.addAttribute("advisor",advisorService.getAdvisorById(id));
    return "edit_advisor";
    }

    @PostMapping("/advisors/{id}")
    public String updateAdvisor(@PathVariable Long id, @ModelAttribute("advisor") Advisor advisor)
    {
        //get advisor from database by id
        Advisor existingAdvisor = advisorService.getAdvisorById(id);
        existingAdvisor.setId(advisor.getId());
        existingAdvisor.setFirstName(advisor.getFirstName());
        existingAdvisor.setLastName(advisor.getLastName());
        existingAdvisor.setEmail(advisor.getEmail());
        existingAdvisor.setTitle(advisor.getTitle());
        existingAdvisor.setOffice(advisor.getOffice());
        existingAdvisor.setPhone(advisor.getPhone());

        //save update advisor object
        advisorService.updateAdvisor(existingAdvisor);
        return "redirect:/advisors";
    }
    //handler method to handle delete advisor
    @GetMapping("/advisors/{id}")
    public String deleteAdvisor(@PathVariable Long id)
    {
        advisorService.deleteAdvisorById(id);
        return "redirect:/advisors";
    }
//    @GetMapping("/advisors/assignments/{id}")
//    public String advisorAssignmentForm(@PathVariable Long id,Model model)
//    {
//      model.addAttribute("advisor",advisorService.getAdvisorById(id));
//       return "assignment_advisor";
//    }
}
