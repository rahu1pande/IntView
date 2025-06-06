package com.intView.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intView.model.InterviewSession;

public interface InterviewSesssionRepo extends JpaRepository<InterviewSession, Long> {

}
