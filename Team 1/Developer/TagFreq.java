import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TagFreq {
    // category id 15 is Pets & Animals
    private static final int PET = 15;
    private static final int TAGPOS = 6;
    private static final int CATAID = 4;
    static Map<String, Integer> freqTag = new HashMap<>();

    // get top 10 frequent tag from csv from pet category
    public static void getFreq() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Path/"));
        scanner.nextLine();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            // assume it can split the value properly by each column
            // It does not work properly now, there is no delimiter I can choose
            String[] values = line.split(",");

            int cata = Integer.parseInt(values[CATAID]);
            String tagLine = values[TAGPOS];
            if (cata == PET) {
                String[] tags = tagLine.split("|");
                for (String tag : tags) {
                    freqTag.put(tag, freqTag.getOrDefault(tag, 0) + 1);
                }
            }
        }
        scanner.close();
        // print out top 10 freq tag
        freqTag.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(System.out::println);
    }



    public static void main(String[] args) throws FileNotFoundException {
        getFreq();
    }
}
