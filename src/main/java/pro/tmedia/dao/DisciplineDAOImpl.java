package pro.tmedia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pro.tmedia.model.Discipline;

import java.util.List;

/**
 * User: Ivaykin Timofey
 * Date: 2/12/14
 */
@Repository
@Transactional
public class DisciplineDAOImpl implements DisciplineDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        //Session session = sessionFactory.openSession();
        return /*session*/sessionFactory.getCurrentSession();
    }

    @Override
    public void createDiscipline(Discipline discipline) {
        getCurrentSession().save(discipline);
    }

    @Override
    public Discipline getDiscipline(int id) {
        Discipline discipline = (Discipline) getCurrentSession().get(Discipline.class, id);
        return discipline;
    }

    @Override
    public void deleteDiscipline(int id) {
        Discipline discipline = getDiscipline(id);
        if(discipline != null)
            getCurrentSession().delete(discipline);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Discipline> getDisciplines() {
        return getCurrentSession().createQuery("from Discipline").list();
    }

    /*
     *  FOR UPDATE:
     *  public void updateTeam(Team team) {
     *      Team teamToUpdate = getTeam(team.getId());
     *      teamToUpdate.setName(team.getName());
     *      teamToUpdate.setRating(team.getRating());
     *      getCurrentSession().update(teamToUpdate);
     *  }
     */
}
