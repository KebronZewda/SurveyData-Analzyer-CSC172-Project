import java.util.*;

public class SurveyDataAnalyzer {
    private CustomHashTable table;
    private List<Integer> keys;

    public SurveyDataAnalyzer(CustomHashTable table) {
        this.table = table;
        this.keys = table.getAllKeys();
    }
    public int[] genderDistribution() { // gathers gender data
        int[] distribution = new int[4];
        for (int key : keys) {
            Response response = table.search(key);
            if (response != null) { // For "F" , "M", "O", "-"
                switch (response.getGender()) {
                    case "F":
                        distribution[0]++;
                        break;
                    case "M":
                        distribution[1]++;
                        break;
                    case "O":
                        distribution[2]++;
                        break;
                    default:
                        distribution[3]++;
                        break;
                }
            }
        }
        return distribution;
    }

    public int[] ageGroupDistribution() { // gathers ages
        int[] distribution = new int[4];
        for (int key : keys) {
            Response response = table.search(key);
            int age = response.getAge();
            if (age == 1) distribution[0]++;
            else if (age == 2) distribution[1]++;
            else if (age == 3) distribution[2]++;
            else if (age == 4) distribution[3]++;
        }
        return distribution;
    }

    public int[] residenceDistribution() { // gathers residence
        int[] distribution = new int[4];
        for (int key : keys) {
            Response response = table.search(key);
            int residence = response.getResidence();
            if (residence == 1) distribution[0]++;
            else if (residence == 2) distribution[1]++;
            else if (residence == 3) distribution[2]++;
            else if (residence == 4) distribution[3]++;
        }
        return distribution;
    }

    public int[] educationDistribution() { // gathers education
        int[] distribution = new int[4];
        for (int key : keys) {
            Response response = table.search(key);
            int education = response.getEducation();
            if (education == 1) distribution[0]++;
            else if (education == 2) distribution[1]++;
            else if (education == 3) distribution[2]++;
            else if (education == 4) distribution[3]++;
        }
        return distribution;
    }

    public int[] incomeDistribution() { // gathers income
        int[] distribution = new int[4];
        for (int key : keys) {
            Response response = table.search(key);
            int income = response.getIncomeSource();
            if (income == 1) distribution[0]++;
            else if (income == 2) distribution[1]++;
            else if (income == 3) distribution[2]++;
            else if (income == 4) distribution[3]++;
        }
        return distribution;
    }

    public int[] maritalDistribution() { // gathers marital status
        int[] distribution = new int[4];
        for (int key : keys) {
            Response response = table.search(key);
            int marital = response.getMaritalStatus();
            if (marital == 1) distribution[0]++;
            else if (marital == 2) distribution[1]++;
            else if (marital == 3) distribution[2]++;
            else if (marital == 4) distribution[3]++;
        }
        return distribution;
    }

    public int[] smokerDistribution() { // gathers smoker status
        int[] distribution = new int[2];
        for (int key : keys) {
            Response response = table.search(key);
            int smoker = response.getSmoker();
            if (smoker < distribution.length) distribution[smoker]++;
        }
        return distribution;
    }

    public double lifeQualityGeneral() { // gathers quality of life
        double totalQuality = 0;
        int count = 0;
        for (int key : keys) {
            Response response = table.search(key);
            totalQuality += response.getQuality();
            count++;
        }
        if (count > 0) {
            totalQuality = totalQuality/count;
        }
        else {
            totalQuality = 0;
        }
        return totalQuality;
    }

    public double[] lifeQualityGenderBased() { // gathers quality of life based on gender
        double[] totalQuality = new double[4];
        int[] count = new int[4];
        for (int key : keys) {
            Response response = table.search(key);
            int index = "FMO-".indexOf(response.getGender()); // checks the index of the response
            if (index != -1) {
                totalQuality[index] += response.getQuality();
                count[index]++;
            }
        }
        for (int i = 0; i < totalQuality.length; i++) {
            if (count[i] > 0) {
                totalQuality[i] = totalQuality[i] / count[i];
            } else {
                totalQuality[i] = 0;
            }
        }
        return totalQuality;
    }

    public double[] lifeQualityAgeBased() { // quality of life based on age
        double[] totalQuality = new double[4];
        int[] count = new int[4];
        for (int key : keys) {
            Response response = table.search(key);
            int age = response.getAge();
            if (age == 1) { totalQuality[0]+= response.getQuality(); count[0]++;}
            else if (age == 2) { totalQuality[1]+= response.getQuality(); count[1]++;}
            else if (age == 3) { totalQuality[2]+= response.getQuality(); count[2]++;}
            else if (age == 4) { totalQuality[3]+= response.getQuality(); count[3]++;}
        }
        for (int i = 0; i < totalQuality.length; i++) {
            if (count[i] > 0) {
                totalQuality[i] = totalQuality[i] / count[i];
            } else {
                totalQuality[i] = 0;
            }
        }
        return totalQuality;
    }

    public double[] lifeQualityResidenceBased() { // quality of life based on residence
        double[] totalQuality = new double[4];
        int[] count = new int[4];
        for (int key : keys) {
            Response response = table.search(key);
            int residence = response.getResidence();
            if (residence == 1) { totalQuality[0]+= response.getQuality(); count[0]++;}
            else if (residence == 2) { totalQuality[1]+= response.getQuality(); count[1]++;}
            else if (residence == 3) { totalQuality[2]+= response.getQuality(); count[2]++;}
            else if (residence == 4) { totalQuality[3]+= response.getQuality(); count[3]++;}
        }
        for (int i = 0; i < totalQuality.length; i++) {
            if (count[i] > 0) {
                totalQuality[i] = totalQuality[i] / count[i];
            } else {
                totalQuality[i] = 0;
            }

        }
        return totalQuality;
    }

    public double[] lifeQualityEducationBased() { // quality of life based on education
        double[] totalQuality = new double[4];
        int[] count = new int[4];
        for (int key : keys) {
            Response response = table.search(key);
            int education = response.getEducation();
            if (education == 1) { totalQuality[0]+= response.getQuality(); count[0]++;}
            else if (education == 2) { totalQuality[1]+= response.getQuality(); count[1]++;}
            else if (education == 3) { totalQuality[2]+= response.getQuality(); count[2]++;}
            else if (education == 4) { totalQuality[3]+= response.getQuality(); count[3]++;}
        }
        for (int i = 0; i < totalQuality.length; i++) {
            if (count[i] > 0) {
                totalQuality[i] = totalQuality[i] / count[i];
            } else {
                totalQuality[i] = 0;
            }

        }
        return totalQuality;
    }

    public double[] lifeQualityIncomeBased() { // quality of life based on income
        double[] totalQuality = new double[4];
        int[] count = new int[4];
        for (int key : keys) {
            Response response = table.search(key);
            int income = response.getIncomeSource();
            if (income == 1) { totalQuality[0]+= response.getQuality(); count[0]++;}
            else if (income == 2) { totalQuality[1]+= response.getQuality(); count[1]++;}
            else if (income == 3) { totalQuality[2]+= response.getQuality(); count[2]++;}
            else if (income == 4) { totalQuality[3]+= response.getQuality(); count[3]++;}
        }
        for (int i = 0; i < totalQuality.length; i++) {
            if (count[i] > 0) {
                totalQuality[i] = totalQuality[i] / count[i];
            } else {
                totalQuality[i] = 0;
            }

        }
        return totalQuality;
    }

    public double[] lifeQualityMaritalBased() { // quality of life based on marital status
        double[] totalQuality = new double[4];
        int[] count = new int[4];
        for (int key : keys) {
            Response response = table.search(key);
            int marital = response.getMaritalStatus();
            if (marital == 1) { totalQuality[0]+= response.getQuality(); count[0]++;}
            else if (marital == 2) { totalQuality[1]+= response.getQuality(); count[1]++;}
            else if (marital == 3) { totalQuality[2]+= response.getQuality(); count[2]++;}
            else if (marital == 4) { totalQuality[3]+= response.getQuality(); count[3]++;}
        }
        for (int i = 0; i < totalQuality.length; i++) {
            if (count[i] > 0) {
                totalQuality[i] = totalQuality[i] / count[i];
            } else {
                totalQuality[i] = 0;
            }

        }
        return totalQuality;
    }

    public double[] lifeQualitySmokerBased() { // quality of life based on smoker status
        double[] totalQuality = new double[2];
        int[] count = new int[2];
        for (int key : keys) {
            Response response = table.search(key);
            int smoker = response.getSmoker();
            if (smoker == 0) {
                totalQuality[1] += response.getQuality();
                count[1]++;
            }
            else if (smoker == 1) {
                totalQuality[0] += response.getQuality();
                count[0]++;
            }
        }
        for (int i = 0; i < totalQuality.length; i++) {
            if (count[i] > 0) {
                totalQuality[i] = totalQuality[i] / count[i];
            } else {
                totalQuality[i] = 0;
            }

        }
        return totalQuality;
    }
    public String[] mostCommonTreatment() { // most common treatments
        Map<String, Integer> treatmentCounts = new HashMap<>();
        for (int key : keys) {
            Response response = table.search(key);
            String treatments = response.getQ9();
            String[] individualTreatments = treatments.split(";"); // splits at every semi-colon

            // Increment count for each individual treatment
            for (String treatment : individualTreatments) {
                String trimmedTreatment = treatment.trim();
                Integer count = treatmentCounts.get(trimmedTreatment);
                if (count == null) {
                    treatmentCounts.put(trimmedTreatment, 1);
                } else {
                    treatmentCounts.put(trimmedTreatment, count + 1);
                }            }
        }
        return sortAndReturnTopEntries(treatmentCounts, 5);
    }


    // Method to find the most common symptoms
    public String[] mostCommonSymptoms() { // mot common symptoms
        Map<String, Integer> symptomCounts = new HashMap<>();
        for (int key : keys) {
            Response response = table.search(key);
            String symptoms = response.getQ16();
            String[] individualSymptoms = symptoms.split(";"); // splits at every semi-colon
            for (String symptom : individualSymptoms) {
                String trimmedSymptom = symptom.trim();
                Integer count = symptomCounts.get(trimmedSymptom);
                if (count == null) {
                    symptomCounts.put(trimmedSymptom, 1);
                } else {
                    symptomCounts.put(trimmedSymptom, count + 1);
                }            }
        }
        return sortAndReturnTopEntries(symptomCounts, 7);
    }

    // Method to find the most affected life aspects
    public String[] mostCommonLifeAspects() { // most common life aspects
        Map<String, Integer> aspectCounts = new HashMap<>();
        for (int key : keys) {
            Response response = table.search(key);
            String aspects = response.getQ23();
            String[] individualAspects = aspects.split(";"); // splits at every semi-colon
            for (String aspect : individualAspects) {
                String trimmedAspect = aspect.trim();
                Integer count = aspectCounts.get(trimmedAspect);
                if (count == null) {
                    aspectCounts.put(trimmedAspect, 1);
                } else {
                    aspectCounts.put(trimmedAspect, count + 1);
                }            }
        }
        return sortAndReturnTopEntries(aspectCounts, 6);
    }

    // Method to assess life quality under mixed conditions
    public double[] lifeQualityMixConditionsBased() { // quality of life based on mixed conditions
        double totalQuality1 = 0, totalQuality2 = 0;
        int count1 = 0, count2 = 0;
        for (int key : keys) {
            Response response = table.search(key);
            if (response.getResidence() == 4 && response.getMaritalStatus() == 1) {
                totalQuality1 += response.getQuality();
                count1++;
            } else if ((response.getResidence() == 1 || (response.getResidence() == 2)) && (response.getMaritalStatus() == 2)) {
                totalQuality2 += response.getQuality();
                count2++;
            }
        }
        double avg1 = 0;
        double avg2 = 0;
        if (count1 > 0) {
            avg1 = totalQuality1 / count1;
        } else {
           avg1 = 0;
        }
        if (count2 > 0) {
            avg2 = totalQuality2 / count2;
        } else {
            avg2 = 0;
        }
        return new double[]{avg1, avg2};
    }

    // Method to assess life quality based on responses to a specific question
    public double[] lifeQualityResponseBased() { // quality of life based on responses
        double[] totalQualities = new double[4]; // Assuming 4 possible responses
        int[] counts = new int[4];
        for (int key : keys) {
            Response response = table.search(key);
            int responseIndex = response.getQ15(); // Assuming Q15 response is directly usable as an index
            if (responseIndex == 1) {
                totalQualities[0] += response.getQuality();
                counts[0]++;
            }
            else if (responseIndex == 2) {
                totalQualities[1] += response.getQuality();
                counts[1]++;
            }
            else if (responseIndex == 3) {
                totalQualities[2] += response.getQuality();
                counts[2]++;
            }
            else if (responseIndex == 4) {
                totalQualities[3] += response.getQuality();
                counts[3]++;
            }
        }
        double[] averages = new double[4];
        for (int i = 0; i < 4; i++) {
            averages[i] = totalQualities[i] / counts[i];
        }
        return averages;
    }

    private String[] sortAndReturnTopEntries(Map<String, Integer> map, int size) { // sorts arrays for Questions 16 - 18
        return map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // Sort by value in descending order
                .limit(size) // Limit to the top 'size' entries
                .map(Map.Entry::getKey) // Map to the key
                .toArray(String[]::new); // Collect results into a new String array
    }



    public static void main(String[] args){ // print statements
        CustomHashTable table = ReadFile.readResponsesFromFile("responses.txt");
        SurveyDataAnalyzer analyzer = new SurveyDataAnalyzer(table);

        // Print gender distribution
        int[] genderDist = analyzer.genderDistribution();
        System.out.println("Gender Distribution: " + Arrays.toString(genderDist));

        // Print age group distribution
        int[] ageDist = analyzer.ageGroupDistribution();
        System.out.println("Age Group Distribution: " + Arrays.toString(ageDist));

        // Print residence distribution
        int[] residenceDist = analyzer.residenceDistribution();
        System.out.println("Residence Distribution: " + Arrays.toString(residenceDist));

        // Print education distribution
        int[] educationDist = analyzer.educationDistribution();
        System.out.println("Education Distribution: " + Arrays.toString(educationDist));

        // Print income distribution
        int[] incomeDist = analyzer.incomeDistribution();
        System.out.println("Income Distribution: " + Arrays.toString(incomeDist));

        // Print marital status distribution
        int[] maritalDist = analyzer.maritalDistribution();
        System.out.println("Marital Status Distribution: " + Arrays.toString(maritalDist));

        // Print smoker status distribution
        int[] smokerDist = analyzer.smokerDistribution();
        System.out.println("Smoker Status Distribution: " + Arrays.toString(smokerDist));

        // Print general life quality
        double lifeQuality = analyzer.lifeQualityGeneral();
        System.out.println("General Life Quality: " + lifeQuality);

        // Print life quality by gender
        double[] qualityByGender = analyzer.lifeQualityGenderBased();
        System.out.println("Quality by Gender: " + Arrays.toString(qualityByGender));

        // Print life quality by age
        double[] qualityByAge = analyzer.lifeQualityAgeBased();
        System.out.println("Quality by Age: " + Arrays.toString(qualityByAge));

        // Print life quality by residence
        double[] qualityByResidence = analyzer.lifeQualityResidenceBased();
        System.out.println("Quality by Residence: " + Arrays.toString(qualityByResidence));

        // Print life quality by education
        double[] qualityByEducation = analyzer.lifeQualityEducationBased();
        System.out.println("Quality by Education: " + Arrays.toString(qualityByEducation));

        // Print life quality by income
        double[] qualityByIncome = analyzer.lifeQualityIncomeBased();
        System.out.println("Quality by Income: " + Arrays.toString(qualityByIncome));

        // Print life quality by marital status
        double[] qualityByMarital = analyzer.lifeQualityMaritalBased();
        System.out.println("Quality by Marital Status: " + Arrays.toString(qualityByMarital));

        // Print life quality by smoker status
        double[] qualityBySmoker = analyzer.lifeQualitySmokerBased();
        System.out.println("Quality by Smoker Status: " + Arrays.toString(qualityBySmoker));

        // Print most common treatments
        String[] commonTreatments = analyzer.mostCommonTreatment();
        System.out.println("Most Common Treatments: " + Arrays.toString(commonTreatments));

        // Print most common symptoms
        String[] commonSymptoms = analyzer.mostCommonSymptoms();
        System.out.println("Most Common Symptoms: " + Arrays.toString(commonSymptoms));

        // Print most affected life aspects
        String[] commonLifeAspects = analyzer.mostCommonLifeAspects();
        System.out.println("Most Affected Life Aspects: " + Arrays.toString(commonLifeAspects));

        // Print life quality under mixed conditions
        double[] mixedConditionsQuality = analyzer.lifeQualityMixConditionsBased();
        System.out.println("Life Quality under Mixed Conditions: " + Arrays.toString(mixedConditionsQuality));

        // Print life quality based on specific responses
        double[] responseBasedQuality = analyzer.lifeQualityResponseBased();
        System.out.println("Life Quality Based on Specific Responses: " + Arrays.toString(responseBasedQuality));

    }
}
