package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private CompanyServiceImplement companyService;

    @Autowired
    public CompanyController(CompanyServiceImplement CompanyService) {
        this.companyService = CompanyService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @PostMapping("/post")
    public Company post(@RequestBody Company company) throws Exception {
//        companyService.insert(company);
        companyService.add(company);
        return company;
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable("id") int id) {
        return companyService.getById(id);
    }
}
