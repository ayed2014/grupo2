
import java.io.*;

/**
 * Created by Francisco on 6/26/2014.
 */
public class Ejercicio4 {

    private FileReader fr;
    private BufferedReader br;
    private FileWriter fwGreater;
    private FileWriter fwFewer;

    public Ejercicio4(String file) throws IOException {
        fr = new FileReader(file);
        br = new BufferedReader(fr);
    }

    public void writeFiles() throws IOException {
        String country;
        double population;
        double pbi;
        fwFewer = new FileWriter("Countries with less than 30 million");
        fwGreater = new FileWriter("Countries with more than or equal to 30 million");
        country = br.readLine();
        while (country != null){
            population = Double.parseDouble(br.readLine());
            pbi = Double.parseDouble(br.readLine());
            if (population < 30000000){
                fwFewer.write(country + "\n" + population + "\n" + pbi + "\n");
            } else {
                fwGreater.write(country + "\n" + population + "\n" + pbi + "\n");
            }
            country = br.readLine();
        }
        br.close();
        fwFewer.close();
        fwGreater.close();
    }
}
