public class Adult extends Person{
    private String job;

    public Adult(String firstName, String lastName, String phoneNumber, String job) {
        super(firstName, lastName, phoneNumber);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " – #" + getPhoneNumber() + " Job: " + job;
    }
}
