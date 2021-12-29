package com.example.demo;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyMapper {
    @Select("select * from company")
    @Results(id = "CompanyMap", value = {
            @Result(property = "employeeList", column = "id", many = @Many(select = "com.example.demo.EmployeeMapper.getByCompanyId"))
    })
    List<Company> getAll();

    @Insert("insert into company(name) values( #{company.name} )")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("company") Company company);

    @Select("select * from company where id=#{id}")
    @ResultMap("CompanyMap")
    Company getById(@Param("id") int id);
}
