package edu.uganew.ugajuly.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="majors")
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="majorid",nullable = false)
    private Integer majorid;
    @Column(name="majorname",nullable = false)
    private String majorname;

    @OneToMany(mappedBy = "major")
    private List<Assignmentnew> majorsList;

    public Major(){

    }

    public Major(Integer majorid, String majorname) {
        this.majorid = majorid;
        this.majorname = majorname;
    }
    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

}
