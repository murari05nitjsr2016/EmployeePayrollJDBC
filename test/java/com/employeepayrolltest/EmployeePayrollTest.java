package com.employeepayrolltest;

import com.jdbc.emppayrollservice.EmployeePayrollData;
import com.jdbc.emppayrollservice.EmployeePayrollService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeePayrollTest {
    List<EmployeePayrollData> employeePayrollList;
    @Test
    public void givenEmployeePayrollInDB_WhenRetrived_ShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollList = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        Assertions.assertEquals(2, employeePayrollList.size());
    }

    @Test
    public void givenEmployeePayrollInDB_WhenRetrived_ShouldNotMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollList = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        Assertions.assertNotEquals(3, employeePayrollList.size());
    }





}
