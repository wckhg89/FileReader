import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kanghonggu on 2016-12-16.
 */
public class ParseText {

    public static List readFile (String filePath) {
        List<String> dataList = new ArrayList<>();
        String[] datas;
        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String line;

            while((line = in.readLine()) != null) {
                datas = line.split(" ");
                for (String data : datas) {
                    dataList.add(data.trim());
                }
            }

            in.close();
        } catch (Exception e) {
            System.out.println("Err Occr");
        }


        return dataList;
    }

    public static Map<String, List> listToMap (List<String> dataList) {
        Map<String, List> map = new HashMap<>();
        List<String> ids = new ArrayList<>();
        List<String> pv = new ArrayList<>();
        List<String> mpv = new ArrayList<>();
        List<String> total = new ArrayList<>();

        for (int i = 0 ; i < dataList.size() ; i+=4) {
            ids.add(dataList.get(i));
            pv.add(dataList.get(i+1));
            mpv.add(dataList.get(i+2));
            total.add(dataList.get(i+3));
        }

        map.put("id", ids);
        map.put("pv", pv);
        map.put("mpv", mpv);
        map.put("total", mpv);

        return map;
    }

    public static void writeFile(Map<String, List> map, String fileName ,String key) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

            List<String> ids = map.get(key);

            for (String text : ids) {
                out.write(text);
                out.newLine();
            }

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        List<String> list = ParseText.readFile("./news_sport");
        Map<String, List> map = ParseText.listToMap(list);
        ParseText.writeFile(map, "id_sport.txt", "id");
        ParseText.writeFile(map, "pv_sport.txt", "pv");
        ParseText.writeFile(map, "mpv_sport.txt", "mpv");
        ParseText.writeFile(map, "totalpv_sport.txt", "total");
    }

}
