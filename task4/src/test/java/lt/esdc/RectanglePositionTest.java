package lt.esdc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RectanglePosition Enum Tests")
public class RectanglePositionTest {

    @ParameterizedTest(name = "{0} should have description: \"{1}\"")
    @CsvSource({
            "INSIDE, Point is inside the rectangle",
            "OUTSIDE, Point is outside the rectangle",
            "HORIZONTAL_BORDER, Point is on the horizontal border",
            "VERTICAL_BORDER, Point is on the vertical border",
            "CORNER, Point is at a rectangle corner"
    })
    void shouldReturnCorrectDescription(RectanglePosition position, String expectedDescription) {
        assertThat(position.getDescription()).isEqualTo(expectedDescription);
    }

    @ParameterizedTest
    @CsvSource({
            "INSIDE",
            "OUTSIDE",
            "HORIZONTAL_BORDER",
            "VERTICAL_BORDER",
            "CORNER"
    })
    void shouldResolveEnumValueFromString(String name) {
        assertThat(RectanglePosition.valueOf(name).name()).isEqualTo(name);
    }
}
