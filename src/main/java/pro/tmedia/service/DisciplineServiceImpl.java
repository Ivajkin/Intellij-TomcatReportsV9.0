package pro.tmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.tmedia.dao.DisciplineDAO;
import pro.tmedia.model.Discipline;
/**
 * User: Ivaykin Timofey
 * Date: 2/12/14
 */
@Service
@Transactional
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineDAO disciplineDAO;

    @Override
    public void createDiscipline(Discipline discipline) {
        disciplineDAO.createDiscipline(discipline);
    }

    @Override
    public Discipline getDiscipline(int id) {
        return disciplineDAO.getDiscipline(id);
    }

    @Override
    public void deleteDiscipline(int id) {
        disciplineDAO.deleteDiscipline(id);
    }

    @Override
    public List<Discipline> getDisciplines() {
        return disciplineDAO.getDisciplines();
    }
}