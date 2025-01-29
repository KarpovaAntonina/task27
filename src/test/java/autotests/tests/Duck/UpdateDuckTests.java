package autotests.tests.Duck;

import autotests.clients.DuckActionsClient;
import autotests.payloads.Duck;
import autotests.payloads.WingsState;
import com.consol.citrus.TestCaseRunner;
import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

@Epic("Тесты на duck-controller")
@Feature("Эндпоинт /api/duck/update")
public class UpdateDuckTests extends DuckActionsClient {

    @Test(description = "Обновление цвета и высоты утки")
    @CitrusTest
    public void successfulColorHeightUpdate(@Optional @CitrusResource TestCaseRunner runner) {
        String color = "yellow";
        double height = 0.01;
        String material = "rubber";
        String sound = "quack";
        WingsState wingsState = WingsState.FIXED;
        String newColor = "red";
        double newHeight = 0.02;
        Duck duck = new Duck()
                .color(color)
                .height(height)
                .material(material)
                .sound(sound)
                .wingsState(wingsState);

        createDuck(runner, duck);
        extractDuckId(runner);

        updateDuck(runner, newColor, newHeight, material, sound, wingsState);
        validateResponse(runner, HttpStatus.OK, "duckTest/successfulUpdate.json");
    }

    @Test(description = "Обновление цвета и звука утки")
    @CitrusTest
    public void successfulColorSoundUpdate(@Optional @CitrusResource TestCaseRunner runner) {
        String color = "yellow";
        double height = 0.01;
        String material = "rubber";
        String sound = "quack";
        WingsState wingsState = WingsState.FIXED;
        String newColor = "red";
        String newSound = "ogo";
        Duck duck = new Duck()
                .color(color)
                .height(height)
                .material(material)
                .sound(sound)
                .wingsState(wingsState);

        createDuck(runner, duck);
        extractDuckId(runner);

        updateDuck(runner, newColor, height, material, newSound, wingsState);
        validateResponse(runner, HttpStatus.OK, "duckTest/successfulUpdate.json");
    }
}
