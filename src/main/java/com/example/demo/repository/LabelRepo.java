package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Label;

public interface LabelRepo extends JpaRepository<Label, Integer> {

}
