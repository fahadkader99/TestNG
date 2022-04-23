package test.java.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailed_Analyser implements IRetryAnalyzer {

    int count = 1;
    int retryCount = 1;         // number of times we are trying to re-execute the test.

    @Override
    public boolean retry(ITestResult iTestResult) {

        while (count<retryCount){
            count++;
            return true;
        }

        return false;
    }
}
