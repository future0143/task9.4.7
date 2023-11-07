package runners;

import config.ConfigSetup;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"}, // Путь к директории с feature-файлами
        glue = {"stepDefinitions", "hooks"},// Пакет, где находятся реализации шагов (step definitions)
        tags = "@all",
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class RunnerTest implements ConfigSetup {
}