import Domain.Nota;
import Domain.Student;
import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.MemoryRepository.NotaRepo;
import Repository.MemoryRepository.StudentRepo;
import Repository.MemoryRepository.TemaLabRepo;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class addGradeTest {

    StudentRepo studentRepository;
    TemaLabRepo temaLabRepository;
    NotaRepo notaRepository;

    @Before
    public void createRepository() throws ValidatorException {
        studentRepository = new StudentRepo(new StudentValidator());
        temaLabRepository = new TemaLabRepo(new TemaLabValidator());
        notaRepository = new NotaRepo(new NotaValidator());

        Student student = new Student("1", "Cata", 936, "1", "1");
        studentRepository.save(student);
        TemaLab temaLab = new TemaLab(1, "Eo", 3, 2);
        temaLabRepository.save(temaLab);
    }

    @Test
    public void addStudentTest() {
        Student student = new Student("2", "Cata", 936, "1", "1");

        try {
            studentRepository.save(student);
            Student check = studentRepository.findOne("2");
            Assert.assertEquals("Cata", check.getNume());
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }

    @Test
    public void addAssigmentTest() {
        TemaLab temaLab = new TemaLab(2, "hawaioi", 3, 2);

        try {
            temaLabRepository.save(temaLab);
            TemaLab check = temaLabRepository.findOne(2);
            Assert.assertEquals("hawaioi", check.getDescriere());
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }


    @Test
    public void addGradeTest() {
        Nota nota = new Nota(1, "1", 1, 1, LocalDateTime.now());

        try {
            notaRepository.save(nota);
            Nota check = notaRepository.findOne(1);
            Assert.assertEquals(1.0, check.getValoare());
        } catch (ValidatorException e) {
            Assert.fail();
        }
    }

    @Test
    public void integrateBigBangTest(){
        addAssigmentTest();
        addStudentTest();
        addGradeTest();
    }

    @Test
    public void addIncrementalStudentTest() {
        addStudentTest();
    }

    @Test
    public void addIncrementalAssigmentTest() {
        addStudentTest();
        addAssigmentTest();
    }

    @Test
    public void addIncrementalGradeTest() {
        addStudentTest();
        addAssigmentTest();
        addGradeTest();
    }
}
