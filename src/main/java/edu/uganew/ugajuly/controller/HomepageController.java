package edu.uganew.ugajuly.controller;

import edu.uganew.ugajuly.entity.Advisor;
import edu.uganew.ugajuly.entity.Assignmentnew;
import edu.uganew.ugajuly.entity.Major;
import edu.uganew.ugajuly.service.AdvisorService;
import edu.uganew.ugajuly.service.AssignmentnewService;
import edu.uganew.ugajuly.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomepageController {

    @Autowired
    private AdvisorService advisorService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private AssignmentnewService assignmentnewService;

    @GetMapping("/home")
    public String viewHomePage(Model model)
    {
       List<Major> majors = majorService.getAllMajors();
       model.addAttribute("majors",majors);
       return "index";
    }

    @GetMapping("/findByStuLastName/{stuName}/{majorname}")
    public String findByStuLastName (@RequestParam(value="majorname") String majorname, @RequestParam(value="stuName") String stuName, Model model) {

        List<Advisor> advisors = advisorService.findByStuLastName(stuName,majorname);
         model.addAttribute("majors",majorService.getAllMajors());
        model.addAttribute("advisorsl",advisors);
        model.addAttribute("assignmentnew",new Assignmentnew());
        return "index";
    }


}
