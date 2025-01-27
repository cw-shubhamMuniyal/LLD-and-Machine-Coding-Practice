public class NoSqlRepository extends Repository {

    @Override
    void validateInput() {
        System.out.println("validating input before saving into No Sql DB.");
    }

}
