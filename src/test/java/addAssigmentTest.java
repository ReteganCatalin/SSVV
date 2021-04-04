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

    @Test
    public void addAssigmentIdFailsTest() {
        TemaLab temaLab = new TemaLab(null, "description", 3, 2);

        try {
            repository.save(temaLab);
            Assert.fail();
        } catch (IllegalArgumentException | ValidatorException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void addAssigmentDescriptionFailsNullTest() {
        TemaLab temaLab = new TemaLab(1, null, 3, 2);

        try {
            repository.save(temaLab);
            Assert.fail();
        } catch (IllegalArgumentException | ValidatorException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void addAssigmentDescriptionFailsEmptyTest() {
        TemaLab temaLab = new TemaLab(1, "", 3, 2);

        try {
            repository.save(temaLab);
            Assert.fail();
        } catch (IllegalArgumentException | ValidatorException e) {
            Assert.assertTrue(true);
        }
    }


    @Test
    public void addAssigmentSaptamanaPredariiFails0Test() {
        TemaLab temaLab = new TemaLab(1, "description", 0, 2);

        try {
            repository.save(temaLab);
            Assert.fail();
        } catch (IllegalArgumentException | ValidatorException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void addAssigmentSaptamanaPredariiFails15Test() {
        TemaLab temaLab = new TemaLab(1, "description", 15, 2);

        try {
            repository.save(temaLab);
            Assert.fail();
        } catch (IllegalArgumentException | ValidatorException e) {
            Assert.assertTrue(true);
        }
    }


    @Test
    public void addAssigmentTermenLimitaFails0Test() {
        TemaLab temaLab = new TemaLab(1, "description", 1, 0);

        try {
            repository.save(temaLab);
            Assert.fail();
        } catch (IllegalArgumentException | ValidatorException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void addAssigmentTermenLimitaFails15Test() {
        TemaLab temaLab = new TemaLab(1, "description", 1, 15);

        try {
            repository.save(temaLab);
            Assert.fail();
        } catch (IllegalArgumentException | ValidatorException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void addAssigmentDescriptionValidTest() {
        TemaLab temaLab = new TemaLab(1, "description", 12, 10);

        try {
            repository.save(temaLab);
            TemaLab check = repository.findOne(1);
            Assert.assertEquals("description", check.getDescriere());
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }


}
