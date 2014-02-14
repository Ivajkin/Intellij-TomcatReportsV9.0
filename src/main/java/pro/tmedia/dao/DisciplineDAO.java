package pro.tmedia.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import pro.tmedia.model.Discipline;

/**
 * User: Ivaykin Timofey
 * Date: 2/12/14
 */
@Transactional
public interface DisciplineDAO {
    public void createDiscipline(Discipline discipline);
    public Discipline getDiscipline(int id);
    public void deleteDiscipline(int id);
    public List<Discipline> getDisciplines();
}
