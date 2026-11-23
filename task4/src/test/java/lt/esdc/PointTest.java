package lt.esdc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Point Unit Tests")
public class PointTest {

    @Nested
    @DisplayName("Constructor and Getters")
    class ConstructorAndGettersTests {

        @ParameterizedTest(name = "Point({0}, {1}) should have x={0} and y={1}")
        @CsvSource({
                "0, 0",
                "3, 4",
                "-3, -4",
                "2147483647, -2147483648"
        })
        void shouldProperlyInitializeCoordinates(int x, int y) {
            Point point = new Point(x, y);

            assertThat(point.getX()).isEqualTo(x);
            assertThat(point.getY()).isEqualTo(y);
        }
    }

    @Nested
    @DisplayName("Equals and HashCode Contract")
    class EqualsAndHashCodeTests {

        @Test
        @DisplayName("Should be reflexive: point equals itself")
        void shouldBeReflexive() {
            Point point = new Point(1, 2);
            assertThat(point.equals(point)).isTrue();
        }

        @Test
        @DisplayName("Should be symmetric: p1.equals(p2) == p2.equals(p1)")
        void shouldBeSymmetric() {
            Point p1 = new Point(1, 2);
            Point p2 = new Point(1, 2);

            assertThat(p1.equals(p2)).isTrue();
            assertThat(p2.equals(p1)).isTrue();
            assertThat(p1.hashCode()).isEqualTo(p2.hashCode());
        }

        @Test
        @DisplayName("Should return false when compared to null")
        void shouldNotEqualNull() {
            Point point = new Point(1, 2);
            assertThat(point.equals(null)).isFalse();
        }

        @Test
        @DisplayName("Should return false when compared to an object of another type")
        void shouldNotEqualOtherType() {
            Point point = new Point(1, 2);
            assertThat(point.equals("1, 2")).isFalse();
        }

        @Test
        @DisplayName("Should return false when coordinates differ")
        void shouldNotEqualWhenCoordinatesDiffer() {
            Point base = new Point(1, 2);
            Point diffX = new Point(9, 2);
            Point diffY = new Point(1, 9);
            Point diffBoth = new Point(9, 9);

            assertThat(base.equals(diffX)).isFalse();
            assertThat(base.equals(diffY)).isFalse();
            assertThat(base.equals(diffBoth)).isFalse();
        }
    }

    @Nested
    @DisplayName("String Representation")
    class ToStringTests {

        @ParameterizedTest(name = "Point({0}, {1}) -> \"Point({0}, {1})\"")
        @CsvSource({
                "0, 0, 'Point(0, 0)'",
                "3, 4, 'Point(3, 4)'",
                "-3, -4, 'Point(-3, -4)'"
        })
        void shouldFormatStringCorrectly(int x, int y, String expected) {
            Point point = new Point(x, y);
            assertThat(point.toString()).isEqualTo(expected);
        }
    }
}
