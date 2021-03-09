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
    public void createRepository(){
        repository=new StudentRepo(new StudentValidator());
    }

    @Test
    public void addStudentTest(){
        Student student=new Student("2","Cata",936,"1","1");

        try {
            repository.save(student);
            Student check=repository.findOne("2");
            Assert.assertEquals("Cata",check.getNume());
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }
    @Test
    public void addStudentFailTest(){
        Student student=new Student("2","Cata",936,"1","1");

        try {
            repository.save(student);
            Student check=repository.findOne("2");
            Assert.assertEquals("Cata",check.getNume());
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


}
