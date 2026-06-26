import java.util.HashMap;
import java.util.Map;

public class TestResultsTracker {
    Map<String, String> testResults = new HashMap<String, String>();

    public TestResultsTracker()
    {
        testResults.put("Login","PASS");
        testResults.put("Registration","FAIL");
        testResults.put("Search","SKIP");
        testResults.put("Cart","PASS");
        testResults.put("Logout","PASS");
        testResults.put("Login", "FAIL");
        testResults.put("Payment", "FAIL");
    }
    public void printSummary()
    {
        int passCount = 0, failCount = 0, skipCount=0;
        try {
            for (String result : testResults.values()) {
                if (result.equals("PASS")) {
                    passCount++;
                } else if (result.equals("FAIL")) {
                    failCount++;
                } else if (result.equals("SKIP")) {
                    skipCount++;
                }
            }
        }
           catch (NullPointerException e) {
                System.out.println("ERROR: Test results map is null — " + e.getMessage());
        }
        System.out.println("Total Test case count:" + testResults.size());
        System.out.println("Total Passed Test case count:" + passCount);
        System.out.println("Total Failed Test case count:" + failCount);
        System.out.println("Total Skipped Test case count:" + skipCount);
    }


    public static void main (String [] args)
    {
        TestResultsTracker trac = new TestResultsTracker();
        trac.printSummary();
    }
}