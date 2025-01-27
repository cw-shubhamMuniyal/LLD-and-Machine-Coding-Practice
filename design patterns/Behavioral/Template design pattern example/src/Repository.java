public abstract class Repository {

    final void save() {
        validateInput();
        System.out.println("record saved to DB!");
        postSave();
    }

    abstract void validateInput();

    void postSave() {
//        optional implementation, depends on the use case.
    }

}
