package com.globomantics.globomantics.employee;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@ApiOperation(value = "Get schedule", notes = "add note here")
public class EmployeeService
{
    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String getSchedule()
    {
        return "Your schedule is M-F 9-5";
    }
}
