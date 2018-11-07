import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVTest {

    public static void readCSV() {
        // Path może być niedostępny dla danej wersji Javy: File -> Project Structure -> Project Settings -> Modules -> "Your Module Name" -> Sources -> Language Level
        // tutaj wygenerować CSV http://www.csvgenerator.com/
        // Charset - zestaw znaków z jakich można korzystać
        Path csvPath = getFilePath();
        System.out.println(csvPath);

        try {
            CSVParser csvParser = CSVParser.parse(
                    csvPath,
                    Charset.defaultCharset(),
                    CSVFormat.DEFAULT.withHeader("ID", "NAME")
            );

            List<Worker> workerList = createWorkerList(csvParser);
            System.out.println(workerList.get(2).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCSV() {
        try {
            //We have to create the CSVPrinter class object
            Writer writer = Files.newBufferedWriter(getFilePath());
            CSVPrinter csvPrinter = new CSVPrinter(
                    writer,
                    CSVFormat.DEFAULT
            );

            csvPrinter.printRecord(1, "Harry");
            csvPrinter.printRecord(2, "Hermiona");
            csvPrinter.printRecord(55, "Ron");
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Worker> createWorkerList(CSVParser csvParser) {
        List<Worker> workerList = new ArrayList<>();
        for (CSVRecord record : csvParser) {
            Worker worker = new Worker(
                    Long.parseLong(record.get("ID")),
                    record.get("NAME")
            );
            workerList.add(worker);
        }
        return workerList;
    }

    private static Path getFilePath() {
        String fileDirectory = "C:/AndroidWorkspace";
        Path filePath = Paths.get(fileDirectory);
        String fileName = "data.csv";
        return filePath.resolve(fileName);
    }
}
