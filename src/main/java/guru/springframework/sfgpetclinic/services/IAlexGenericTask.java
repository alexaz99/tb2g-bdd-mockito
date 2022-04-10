package guru.springframework.sfgpetclinic.services;

public interface IAlexGenericTask {
    String retrieve(long id);
    boolean validate();
    void doAction(String data);

    void delete();
}
