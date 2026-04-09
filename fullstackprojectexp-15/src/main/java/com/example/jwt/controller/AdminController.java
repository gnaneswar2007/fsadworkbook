package com.example.jwt.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

@PostMapping("/add")
public String addEmployee(){

    return "Employee Added";
}

@DeleteMapping("/delete")
public String deleteEmployee(){

    return "Employee Deleted";
}
}