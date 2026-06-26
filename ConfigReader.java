import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private final Properties properties;

    // Constructor loads the file once
    public ConfigReader(String filePath) {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
            System.out.println("Config loaded successfully");
        } catch (IOException e) {
            //System.out.println("ERROR loading config: " + e.getMessage());
            throw new RuntimeException("FATAL: Config file not found at path: "
                    + filePath + " — " + e.getMessage());
        }
    }

    // Getter methods for each config value
    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public String getEnvironment() {
        return properties.getProperty("environment");
    }

    public String getReportPath() {
        return properties.getProperty("reportPath");
    }

    public int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }
}
/*
public class FrameworkSetup
{
    public static void main(String[] args) {
        ConfigReader config = new ConfigReader("config.properties");
        System.out.println("======= Framework Configuration =======");
        System.out.println("Browser  : " + config.getBrowser());
        System.out.println("Base URL : " + config.getBaseUrl());
        System.out.println("Environment : " + config.getEnvironment());
        System.out.println("Timeout  : " + config.getTimeout() + " seconds");
        System.out.println("ReportPath : " + config.getReportPath());
        System.out.println("==========================================");
    }
}

 */