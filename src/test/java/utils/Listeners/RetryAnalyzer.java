package utils.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


/**
 * @RetryAnalyzer is used to retry the failed tests.
 * Set the retry limit for the number of iteration you want.
 */
public class RetryAnalyzer implements IRetryAnalyzer {
    int counter = 0;
    int retryLimit = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(counter < retryLimit)
        {
            counter++;
            return true;
        }
        return false;
    }
}
