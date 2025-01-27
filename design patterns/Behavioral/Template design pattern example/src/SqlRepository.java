public class SqlRepository extends Repository {

    @Override
    void validateInput() {
        System.out.println("validating input before saving into SQL DB.");
    }

    @Override
    void postSave() {
        System.out.println("Adding post save hook to do further things after save.");
    }

}
