import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by kanghonggu on 2016-12-16.
 */

public class ParseTextTest {


    @Test
    public void testRead () {
        List data = ParseText.readFile("./news_sport");

        assertEquals(3, data.size());
    }

    @Test
    public void testMap () {
        List data = ParseText.readFile("./news_sport");
        Map map = ParseText.listToMap(data);

        assertEquals(3, map.size());
        //assertEquals(300, map.get("id"));
//        assertEquals(300, map.get("pv"));
        assertEquals(300, map.get("mpv"));
    }

    @Test
    public void testWrite () {

    }
}
