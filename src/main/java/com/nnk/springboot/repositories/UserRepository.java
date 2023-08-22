package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer>, JpaSpecificationExecutor<AppUser> {

    AppUser findByUsername(String username);

    @Query("select count(u.id) from AppUser u where LOWER(TRIM(u.username))=LOWER(TRIM(?1)) and (u.id is null or u.id!=?2)")
    int countByUsername(String username, Integer id);

}
