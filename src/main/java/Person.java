import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Person {
    private final Calendar dateOfBirth;
    private final String name;
    private final String firstSurname;
    private final String secondSurname;
    private String antecedents;
    private String allergies;
    private String vaccination;
    private long fatherPhoneNumber;
    private long motherPhoneNumber;
    private final List<Record> recordList;

    public Person(String name,
                  String firstSurname,
                  String secondSurname,
                  int year,
                  int month,
                  int date,
                  List<Record> recordList,
                  long fatherPhoneNumber,
                  long motherPhoneNumber,
                  String antecedents,
                  String allergies,
                  String vaccination) {
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.dateOfBirth = new GregorianCalendar();
        this.dateOfBirth.set(year, month, date);
        this.recordList = recordList;
        this.fatherPhoneNumber = fatherPhoneNumber;
        this.motherPhoneNumber = motherPhoneNumber;
        this.antecedents = antecedents;
        this.allergies = allergies;
        this.vaccination = vaccination;
    }

    public void setFatherPhoneNumber(long fatherPhoneNumber) {
        this.fatherPhoneNumber = fatherPhoneNumber;
    }

    public void setMotherPhoneNumber(long motherPhoneNumber) {
        this.motherPhoneNumber = motherPhoneNumber;
    }

    public void addAntecedents(String antecedent) {
        this.antecedents += antecedent + "\n";
    }

    public void addVaccination(String vaccination) {
        this.vaccination += vaccination + "\n";
    }

    public void setAllergies(String allergy) {
        this.allergies += allergy + "\n";
    }

    public void addRecord(Record o) {
        int index = Collections.binarySearch(this.recordList, o);
        if (index < 0) index = ~index;
        this.recordList.add(index, o);
    }

    public void deleteRecord(Record o) {
        int index = Collections.binarySearch(this.recordList, o);
        if (index < 0) return;
        this.recordList.remove(index);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String regex = "(\\d{3})(\\d{2})(\\d{2})(\\d+)";
        String replacement = "$1 $2 $3 $4";
        return "Apellido 1º: " + firstSurname + "\t" +
                "Apellido 2º: " + secondSurname + "\n" +
                "Nombre: " + name + "\t" +
                "Fecha nacimiento: " + sdf.format(dateOfBirth.getTime()) + "\n" +
                "Teléfono madre: " + Long.toString(motherPhoneNumber).replaceFirst(regex, replacement) + "\t" +
                "Teléfono padre: " + Long.toString(fatherPhoneNumber).replaceFirst(regex, replacement) + "\n" +
                "Antecedentes personales\n" + antecedents +
                "Alergias\n" + allergies +
                "Vacunación\n" + vaccination +
                "Incidencia en el colegio\n" +
                recordList.stream().map(Object::toString).collect(Collectors.joining("\n")) + "\n";
    }
}
