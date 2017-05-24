import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PipelineTest {
    @Test
    public void itPipesTheValueIntoFunction() {
        int sum = Pipeline.with(1)
                .into(i -> i + 1)
                .get();

        assertEquals(sum, 2);
    }

    @Test
    public void itPipesTheValueIntoMultipleFunctions() {
        int sum = Pipeline.with(1)
                .into(i -> i + 1)
                .into(i -> i + 2)
                .into(i -> i + 3)
                .get();

        assertEquals(sum, 7);
    }

    @Test
    public void itCanConvertTheValueToDifferentTypes() {
        String message = Pipeline.with(1)
                .into(i -> i + 1)
                .into(i -> i.equals(2) ? "The value is 2" : "The value is not 2")
                .get();

        assertEquals(message, "The value is 2");
    }
}
