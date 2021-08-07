package edu.uganew.ugajuly.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.uganew.ugajuly.entity.Advisor;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name="assignment")
public class Assignmentnew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="assignmentid")
    private Integer assignmentid;
    @Column(name="alpha1")
    private String Alpha1;
    @Column(name="alpha2")
    private String Alpha2;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "advisor_id",nullable = false)
    private Advisor advisor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "major_id",nullable = false)
    private Major major;

    public Assignmentnew()
    {}

    public Assignmentnew(Integer assignmentid, String alpha1, String alpha2) {
        this.assignmentid = assignmentid;
        Alpha1 = alpha1;
        Alpha2 = alpha2;
    }

    public Integer getAssignmentid() {
        return assignmentid;
    }

    public void setAssignmentid(Integer assignmentid) {
        this.assignmentid = assignmentid;
    }

    public String getAlpha1() {
        return Alpha1;
    }

    public void setAlpha1(String alpha1) {
        Alpha1 = alpha1;
    }

    public String getAlpha2() {
        return Alpha2;
    }

    public void setAlpha2(String alpha2) {
        Alpha2 = alpha2;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }


}
