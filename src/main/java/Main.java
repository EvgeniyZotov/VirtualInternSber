import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        // открываем файл
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Projects\\internSber\\src\\main\\java\\city_ru.csv"));

        // считываем построчно
        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<City> cityList = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            City city = new City();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if(index == 0)
                    city.setID(Integer.parseInt(data));
                 else if (index == 1)
                    city.setName(data);
                 else if (index == 2)
                    city.setRegion(data);
                 else if (index == 3)
                    city.setDistrict(data);
                 else if (index == 4)
                    city.setPopulation(Integer.parseInt(data));
                 else if (index == 5)
                     city.setFoundation(data);
                 else
                    System.err.println("Введены некорректные данные " + data);
                index++;

            }
            index = 0;
            cityList.add(city);
        }
        reader.close();
        String formatterString = cityList.toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .trim();
        System.out.println(formatterString);
    }
}
