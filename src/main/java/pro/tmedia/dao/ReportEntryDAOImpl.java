package pro.tmedia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pro.tmedia.model.ReportEntry;

import java.util.List;

/**
 * User: Ivaykin Timofey
 * Date: 2/19/14
 */
@Repository
@Transactional
public class ReportEntryDAOImpl implements ReportEntryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void create(ReportEntry reportEntry) {
        getCurrentSession().save(reportEntry);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ReportEntry> findItems() {
        return getCurrentSession().createQuery("from ReportEntry").list();
    }

    @Override
    public void update(ReportEntry reportEntry) {
        getCurrentSession().update(reportEntry);
    }

    @Override
    public ReportEntry find(final Integer id) {
        return (ReportEntry)getCurrentSession().get(ReportEntry.class, id);
    }

    @Override
    public void delete(final int id) {
        ReportEntry reportEntry = find(id);
        if(reportEntry != null)
            getCurrentSession().delete(reportEntry);
    }
}
