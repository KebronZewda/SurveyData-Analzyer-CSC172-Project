import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ReadFile {
    public static CustomHashTable readResponsesFromFile(String filePath) {
        CustomHashTable table = new CustomHashTable();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Response response = parseLineToResponse(line);
                if (response != null) {
                    table.insert(response.getId(), response);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found: " + e.getMessage());
            return null; // or handle the error as needed
        } finally {
            if (scanner != null) {
                scanner.close(); // Ensure the scanner is closed in the finally block
            }
        }
        return table;
    }

    private static Response parseLineToResponse(String line) { //parses lines to an array
        String[] parts = line.split("\t"); // splits at every tab
        int id = Integer.parseInt(parts[0]);
        String gender = assignGender(parts[1]);
        int age = Integer.parseInt(parts[2]);
        int residence = Integer.parseInt(parts[3]);
        int education = Integer.parseInt(parts[4]);
        int incomeSource = Integer.parseInt(parts[5]);
        int maritalStatus = Integer.parseInt(parts[6]);
        int smoker = Integer.parseInt(parts[7]);
        int year = Integer.parseInt(parts[8]);
        String q9 = parts[9];
        int q10 = Integer.parseInt(parts[10]);
        int q11 = Integer.parseInt(parts[11]);
        int q12 = Integer.parseInt(parts[12]);
        int q13 = Integer.parseInt(parts[13]);
        int q14 = Integer.parseInt(parts[14]);
        int q15 = Integer.parseInt(parts[15]);
        String q16 = parts[16];
        int q17 = Integer.parseInt(parts[17]);
        int q18 = Integer.parseInt(parts[18]);
        int q19 = Integer.parseInt(parts[19]);
        int q20 = Integer.parseInt(parts[20]);
        int q21 = Integer.parseInt(parts[21]);
        int q22 = Integer.parseInt(parts[22]);
        String q23 = parts[23];
        int q24 = Integer.parseInt(parts[24]);
        int q25 = Integer.parseInt(parts[25]);
        int q26 = Integer.parseInt(parts[26]);
        int q27 = Integer.parseInt(parts[27]);
        int q28 = Integer.parseInt(parts[28]);
        int q29 = Integer.parseInt(parts[29]);
        int q30 = Integer.parseInt(parts[30]);

        return new Response(id, gender, age, residence, education, incomeSource, maritalStatus, smoker, year, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20, q21, q22, q23, q24, q25, q26, q27, q28, q29, q30);
    }

    private static String assignGender(String number) { // assign the integer value to its string value
        switch (number) {
            case "1": return "F";
            case "2": return "M";
            case "3": return "O";
            default: return "-";
        }
    }
}
