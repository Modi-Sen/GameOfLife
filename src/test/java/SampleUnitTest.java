import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SampleUnitTest {

    private long maxValue = 1000;

    @Before
    public void clear() {

    }

    @Test
    public void exampleTestCase() {
        // given
        long maxValue = 4L;
        int[][] expectedOutput = {
                {2, 1},
                {2, 2},
                {2, 3}
        };

        int[][] input = {
                {1, 2},
                {2, 2},
                {3, 2}
        };

        // when
        GameOfLife gol = new GameOfLife();
        int[][] actualNextGenGrid = gol.process(input, maxValue);

        // then
        Assert.assertEquals(expectedOutput, actualNextGenGrid);

    }

    @Test
    public void exampleTestCase1M() {
        // given
        int[][] expectedOutput = {
                {2, 1},
                {2, 2},
                {2, 3},
                {102,101},
                {102,102},
                {102,103}
        };

        int[][] input = {
                {1, 2},
                {2, 2},
                {3, 2},
                {101,102},
                {102,102},
                {103,102},
        };

        // when
        GameOfLife gol = new GameOfLife();
        int[][] actualNextGenGrid = gol.process(input, maxValue);

        // then
        Assert.assertEquals(expectedOutput, actualNextGenGrid);
    }


}
