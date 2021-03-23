import Domain.Student;
import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.MemoryRepository.StudentRepo;
import Repository.MemoryRepository.TemaLabRepo;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.internal.Assignments;

public class addAssigmentTest {

    TemaLabRepo repository;

    @Before
    public void createRepository() {
        repository = new TemaLabRepo(new TemaLabValidator());
    }

    @Test
    public void addAssigmentDescriptionNullTest() {
        TemaLab temaLab = new TemaLab(2, null, 3, 2);

        try {
            repository.save(temaLab);
            Assert.fail();
        } catch (IllegalArgumentException | ValidatorException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void addAssigmentDescriptionNotNullAndNonEmptyTest() {
        TemaLab temaLab = new TemaLab(2, "hawaioi", 3, 2);

        try {
            repository.save(temaLab);
            TemaLab check = repository.findOne(2);
            Assert.assertEquals("hawaioi", check.getDescriere());
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }
}
