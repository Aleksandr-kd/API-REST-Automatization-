package api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    public void onStart(ITestContext context) {
        logger.info("Тест запущен");
    }

    public void onFinish(ITestContext context) {
        logger.info("Тест завершен");
    }

    public void onTestStart(ITestResult result) {
        logger.info("Запущен {}", result.getMethod().getMethodName());
        logger.info("Описание {}", result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Успешно {}", result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        logger.info("Пропущено {}", result.getMethod().getMethodName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.error("Провален {}", result.getMethod().getMethodName());
    }

}
