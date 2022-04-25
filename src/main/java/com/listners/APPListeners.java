package com.listners;

import com.fileUtils.FileUtils;
import com.genericmethods.GenericMethods;
import org.testng.*;

public class APPListeners implements ITestListener, IInvokedMethodListener {

        FileUtils fileUtils=new FileUtils();
        GenericMethods genericMethods=new GenericMethods();
    public void onStart(ITestContext context){
        System.out.println("onstart method started");
        fileUtils.loadApplicationProperties();
        genericMethods.browserlaunch(fileUtils.getApplicationProperties("Browser_Execute"),fileUtils.getApplicationProperties("QA_APP_URL"));

    }
    public void onFinish(ITestContext context){
        System.out.println("onFinish method started");
        genericMethods.closeBrowser();
    }
    public void onTestStart(ITestResult result){
        System.out.println("New test started" +result.getName());
    }
    public void onTestSuccess(ITestResult result){
        System.out.println("onTestSuccess Method " +result.getName());
    }
    public void onTestFailure(ITestResult result){
        System.out.println("onTestFailure Method "+result.getName());
    }
    public void onTestSkipped(ITestResult result){
        System.out.println("onTestSkipped Method started"+result.getName());
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
        System.out.println("onTestfailedButWithinSuccessPercentage"+result.getName());
    }
    public void beforeInvocation(IInvokedMethod method,ITestResult testResult){
        System.out.println("Before Method"+ method.getTestMethod().getMethodName());
    }
    public void afterInvocation(IInvokedMethod method,ITestResult testResult){
        System.out.println("After Method"+ method.getTestMethod().getMethodName());
    }

}
