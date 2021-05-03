package com.employeepayrolltest;

import com.jdbc.emppayrollservice.EmployeePayrollData;
import com.jdbc.emppayrollservice.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeePayrollTest {
    @Test
    public void givenEmployeePayrollInDataWhenRetrived_ShouldMatchEmployeeCount() {
        EmployeeService employeeService = new EmployeeService();
        List<EmployeePayrollData> employeePayrollList = employeeService.readEmployeePayrollData(EmployeeService.IOService.DB_IO);
        Assertions.assertEquals(2, employeePayrollList.size());
    }
    @Test
    public void givenEmployeePayrollInDataWhenRetrived_ShouldMatchEmployeeCount2() {
        EmployeeService employeeService = new EmployeeService();
        List<EmployeePayrollData> employeePayrollList = employeeService.readEmployeePayrollData(EmployeeService.IOService.DB_IO);
        Assertions.assertNotEquals(2, employeePayrollList.size());
    }


}
