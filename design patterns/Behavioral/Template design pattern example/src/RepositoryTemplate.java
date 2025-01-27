public class RepositoryTemplate {
    public static void main(String[] args) {

        System.out.println("Learning Template design pattern using example!");
        System.out.println("_______________________________________________");

        Repository sqlRepository = new SqlRepository();
        sqlRepository.save();

        System.out.println();

        Repository noSqlRepository = new NoSqlRepository();
        noSqlRepository.save();

    }
}