class Response {
    private int Id;
    private String Gender;
    private int Age;
    private int Residence;
    private int Education;
    private int IncomeSource;
    private int MaritalStatus;
    private int Smoker;
    private int Year;
    private String Q9;
    private int Q10, Q11, Q12, Q13, Q14, Q15, Q17, Q18, Q19, Q20, Q21, Q22, Q24, Q25, Q26, Q27, Q28, Q29, Q30;
    private String Q16, Q23;
    private double Quality;

    public Response(int id, String gender, int age, int residence, int education, int incomeSource, int maritalStatus, int smoker, int year, String q9, int q10, int q11, int q12, int q13, int q14, int q15, String q16, int q17, int q18, int q19, int q20, int q21, int q22, String q23, int q24, int q25, int q26, int q27, int q28, int q29, int q30) {
        Id = id;
        Gender = gender;
        Age = age;
        Residence = residence;
        Education = education;
        IncomeSource = incomeSource;
        MaritalStatus = maritalStatus;
        Smoker = smoker;
        Year = year;
        Q9 = q9;
        Q10 = q10;
        Q11 = q11;
        Q12 = q12;
        Q13 = q13;
        Q14 = q14;
        Q15 = q15;
        Q16 = q16;
        Q17 = q17;
        Q18 = q18;
        Q19 = q19;
        Q20 = q20;
        Q21 = q21;
        Q22 = q22;
        Q23 = q23;
        Q24 = q24;
        Q25 = q25;
        Q26 = q26;
        Q27 = q27;
        Q28 = q28;
        Q29 = q29;
        Q30 = q30;
        computeQuality();
    }

    private void computeQuality() {
        Quality = Q13 + Q14 + Q15 + Q17 + Q18 + Q19 + Q21 + Q22 + Q24 + Q25 + Q26 + Q27 + Q28 + Q29 + Q30;
    }

    public int getId() { return Id; }
    public String getGender() { return Gender; }
    public int getAge() { return Age; }
    public int getResidence() { return Residence; }
    public int getEducation() { return Education; }
    public int getIncomeSource() { return IncomeSource; }
    public int getMaritalStatus() { return MaritalStatus; }
    public int getSmoker() { return Smoker; }
    public double getQuality() { return Quality; }
    public String getQ9() { return Q9; }
    public int getQ10() { return Q10; }
    public int getQ11() { return Q11; }
    public int getQ12() { return Q12; }
    public int getQ13() { return Q13; }
    public int getQ14() { return Q14; }
    public int getQ15() { return Q15; }
    public String getQ16() { return Q16; }
    public int getQ17() { return Q17; }
    public int getQ18() { return Q18; }
    public int getQ19() { return Q19; }
    public int getQ20() { return Q20; }
    public int getQ21() { return Q21; }
    public int getQ22() { return Q22; }
    public String getQ23() { return Q23; }
    public int getQ24() { return Q24; }
    public int getQ25() { return Q25; }
    public int getQ26() { return Q26; }
    public int getQ27() { return Q27; }
    public int getQ28() { return Q28; }
    public int getQ29() { return Q29; }
    public int getQ30() { return Q30; }


    public void printResponse() {
        System.out.printf("Response ID: %d\n", Id);
        System.out.printf("Gender: %s\n", Gender);
        System.out.printf("Age group: %d\n", Age);
        System.out.printf("Place of residence: %d\n", Residence);
        System.out.printf("Education level: %d\n", Education);
        System.out.printf("Source of income: %d\n", IncomeSource);
        System.out.printf("Marital status: %d\n", MaritalStatus);
        System.out.printf("Smoker: %s\n", Smoker == 1 ? "Yes" : "No");
    }
}