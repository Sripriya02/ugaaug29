package edu.uganew.ugajuly.repository;

import edu.uganew.ugajuly.entity.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvisorRepository extends JpaRepository<Advisor,Long> {

    @Query("select ad from Advisor ad join Assignmentnew al ON ad.id = al.advisor.id where al.Alpha1 <= ?1 and al.Alpha2 >= ?1 and al.major.majorname = ?2")
    List<Advisor> findByStuLastName(String last2Char, String majorname);

}
