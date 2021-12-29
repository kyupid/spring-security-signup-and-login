package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImplement implements CompanyService {

    private final CompanyMapper companyMapper;
    private final EmployeeMapper employeeMapper;

    public CompanyServiceImplement(CompanyMapper companyMapper, EmployeeMapper employeeMapper) {
        this.companyMapper = companyMapper;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Company> getAll() {
        List<Company> companyList = companyMapper.getAll();
        return companyList;
    }

    @Override
    public int insert(Company company) {
        return companyMapper.insert(company);
    }

    @Override
    public Company getById(int id) {
        return companyMapper.getById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Company add(Company company) throws Exception {
        companyMapper.insert(company);
        // add company into legacy system
        if (true) {
            throw new Exception("Legacy Exception");
        }
        return company;
    }
}
