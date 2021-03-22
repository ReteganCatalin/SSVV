import Domain.Student;
import Exceptions.ValidatorException;
import Repository.MemoryRepository.StudentRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Service.XMLFileService.StudentXMLService;
import Validator.StudentValidator;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class addStudentTest {

    StudentRepo repository;

    @Before
    public void createRepository() {
        repository = new StudentRepo(new StudentValidator());
    }

    @Test
    public void addStudentTest() {
        Student student = new Student("2", "Cata", 936, "1", "1");

        try {
            repository.save(student);
            Student check = repository.findOne("2");
            Assert.assertEquals("Cata", check.getNume());
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }

    @Test
    public void addStudentFailTest() {
        Student student = new Student("2", "Cata", 936, "1", "1");

        try {
            repository.save(student);
            Student check = repository.findOne("2");
            Assert.assertEquals("Cata", check.getNume());
        } catch (ValidatorException e) {
            Assert.fail();
        }
        try {
            repository.save(null);
            Assert.fail();
        } catch (IllegalArgumentException | ValidatorException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void addStudentGroup0Test(){
        Student student = new Student("2", "Cata", 0, "1", "1");

        try {
            repository.save(student);
            Assert.fail();
        } catch (IllegalArgumentException | ValidatorException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void addStudentGroup1Test(){
        Student student = new Student("2", "Cata", 1, "1", "1");

        try {
            repository.save(student);
            Student check = repository.findOne("2");
            Assert.assertEquals("Cata", check.getNume());
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }



    @Test
    public void addStudentGroup2Test() {
        Student student = new Student("2", "Cata", 2, "1", "1");

        try {
            repository.save(student);
            Student check = repository.findOne("2");
            Assert.assertEquals("Cata", check.getNume());
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }

    @Test
    public void addStudentGroupMaxIntMinus1Test(){
        Student student = new Student("2", "Cata", Integer.MAX_VALUE-1, "1", "1");

        try {
            repository.save(student);
            Student check = repository.findOne("2");
            Assert.assertEquals("Cata", check.getNume());
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }

    @Test
    public void addStudentGroupMaxIntTest(){
        Student student = new Student("2", "Cata", Integer.MAX_VALUE, "1", "1");

        try {
            repository.save(student);
            Student check = repository.findOne("2");
            Assert.assertEquals("Cata", check.getNume());
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }



    @Test
    public void addStudentGroupMaxIntPlus1Test() {
        Student student = new Student("2", "Cata", Integer.MAX_VALUE+1, "1", "1");

        try {
            repository.save(student);
            Assert.fail();
        } catch (IllegalArgumentException | ValidatorException e) {
            Assert.assertTrue(true);
        }
    }

}
