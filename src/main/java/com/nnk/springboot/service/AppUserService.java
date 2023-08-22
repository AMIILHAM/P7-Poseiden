package com.nnk.springboot.service;

import com.nnk.springboot.domain.AppUser;
import com.nnk.springboot.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AppUserService {
    Page<AppUser> appUserPage(Pageable pageable);

    AppUser save(AppUser user) throws ServiceException;

    AppUser update(AppUser user) throws ServiceException;

    void deleteUser(Integer userId);

    Optional<AppUser> findById(Integer userId);
}
