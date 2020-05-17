package com.sysco.sample.api.tests;

import com.jayway.restassured.response.Response;
import com.sysco.sample.api.common.StatusCodes;
import com.sysco.sample.api.requests.functions.Project;
import com.sysco.sample.api.response.model.DataModel;
import com.sysco.sample.api.response.model.EmployeeStatus;

import com.sysco.sample.api.util.ResponseUtil;
import com.sysco.sample.api.util.TestBase;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {

    @BeforeClass
    public static void initiate(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test(description = "ID-001", alwaysRun = true)
    public static void testEmployee() throws JSONException {

        SoftAssert softAssert = new SoftAssert();
        Response employeeData = Project.employees();
       /*
       Get the value from one object
        */
        //String actualDescription = ResponseUtil.getDataValueInDataArray(projectList.asString(), 1, "description");

        EmployeeStatus employeeDataSet = (EmployeeStatus)ResponseUtil.getObject(employeeData.asString(), EmployeeStatus.class);
      /*
      Map the response to object
       */
        softAssert.assertEquals(employeeDataSet.status, "success", "Wrong Success message");
        softAssert.assertEquals(employeeDataSet.data.get(0).id, "1", "Wrong Id");
        softAssert.assertEquals(employeeDataSet.data.get(0).employeeName, "Tiger Nixon", "Wrong Employee Name");
        softAssert.assertEquals(employeeDataSet.data.get(0).employeeSalary, "320800", "Wrong Salary");
        softAssert.assertEquals(employeeDataSet.data.get(0).employeeAge, "61", "Wrong Age");
        softAssert.assertEquals(employeeDataSet.data.get(0).profileImage, "","Profile pic exists");
        softAssert.assertAll();;

        //com.sysco.sample.api.response.model.ProjectModel projectModel = (com.sysco.sample.api.response.model.ProjectModel) ResponseUtil.getDataObjectValueInDataArray(projectList.asString(), 1, com.sysco.sample.api.response.model.ProjectModel.class);


        //Assert.assertEquals(ResponseUtil.getStatus(projectList), StatusCodes.SUCCESS_200_CODE, "Status code should be 200");
        //Assert.assertEquals(projectModel.id, 166.0, "Should be equal");
        //Assert.assertEquals(actualDescription, "Bahamas Regression", "Description mismatches");

    }

}
