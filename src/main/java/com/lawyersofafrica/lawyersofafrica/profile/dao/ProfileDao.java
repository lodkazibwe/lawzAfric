package com.lawyersofafrica.lawyersofafrica.profile.dao;

import com.lawyersofafrica.lawyersofafrica.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileDao extends JpaRepository<Profile, Integer> {

}
