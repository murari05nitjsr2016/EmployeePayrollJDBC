package com.jdbc.emppayrollservice;

import java.util.List;

public class EmployeeService {

    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO,REST_IO}

    private List<EmployeePayrollData> employeePayrollDataList;
    private EmployeeService employeeService;
    public EmployeeService() {

    }

    public List<EmployeePayrollData> readEmployeePayrollData(IOService ioService) {
        if(ioService.equals(IOService.DB_IO))
            this.employeePayrollDataList = new EmployeePayRollService().readData();
        return this.employeePayrollDataList;
    }
}
