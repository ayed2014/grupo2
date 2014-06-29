
import java.io.*;
import java.util.Scanner;

/**
 * @author Juan Ignacio Longo
 * @date 28/06/14.
 */
public class Ejercicio5 {
    public void countryManager(String file,double population){
        boolean pbi = false;
        boolean population1 = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter PBI to save the field country and PBI");
        System.out.println("Enter POB to save the field country and population");
        System.out.println("Enter anything else to save every field");
        String user = scanner.nextLine();
        if(user.equals("PBI") || user.equals("pbi")){
            pbi = true;
        }
        else if(user.equals("POB") || user.equals("pob")){
            population1 = true;
        }
        else{
            pbi = true;
            population1 = true;
        }
        BufferedReader br = null;
        BufferedWriter bw = null;
        BufferedWriter bw2 = null;
        try {
            br = new BufferedReader(new FileReader(file));
            bw = new BufferedWriter(new FileWriter("CountriesBelow"));
            bw2 = new BufferedWriter(new FileWriter("CountriesAbove"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String lineCountry= "";
        double linePopulation ;
        double linePBI ;
        try {
            lineCountry = br.readLine();
            linePopulation = Double.valueOf(br.readLine());
            linePBI = Double.valueOf(br.readLine());
            boolean firstTime = true;
            while(lineCountry != null){
                if(!firstTime){
                    linePopulation = Double.valueOf(br.readLine());
                    linePBI = Double.valueOf(br.readLine());
                }
                if(pbi && population1){
                    if(linePopulation < population){
                        bw.write(lineCountry + "\n");
                        bw.write(String.valueOf(linePopulation) + "\n");
                        bw.write(String.valueOf(linePBI) + "\n");
                    } else {
                        bw2.write(lineCountry + "\n");
                        bw2.write(String.valueOf(linePopulation) + "\n");
                        bw2.write(String.valueOf(linePBI) + "\n");
                    }
                }
                else if(pbi){
                    if(linePopulation < population){
                        bw.write(lineCountry + "\n");
                        bw.write(String.valueOf(linePBI) + "\n");
                    } else {
                        bw2.write(lineCountry + "\n");
                        bw2.write(String.valueOf(linePBI) + "\n");
                    }
                }
                else{
                    if(linePopulation < population){
                        bw.write(lineCountry + "\n");
                        bw.write(String.valueOf(linePopulation) + "\n");
                    } else {
                        bw2.write(lineCountry + "\n");
                        bw2.write(String.valueOf(linePopulation) + "\n");
                    }
                }
                lineCountry = br.readLine();
                firstTime = false;
            }
            br.close();
            bw.close();
            bw2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}