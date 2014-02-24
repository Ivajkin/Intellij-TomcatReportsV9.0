package pro.tmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.tmedia.dao.ReportEntryDAO;
import pro.tmedia.model.ReportEntry;

import java.util.List;

/**
 * User: Ivaykin Timofey
 * Date: 2/12/14
 */
@Service
@Transactional
public class ReportEntryServiceImpl implements ReportEntryService {

    @Autowired
    private ReportEntryDAO reportEntryDAO;

    @Override
    public void create(ReportEntry reportEntry) {
        reportEntryDAO.create(reportEntry);
    }

    @Override
    public List<ReportEntry> findItems() {
        return reportEntryDAO.findItems();
    }

    @Override
    public ReportEntry find(Integer id) {
        return reportEntryDAO.find(id);
    }

    @Override
    public void update(ReportEntry reportEntry) {
        reportEntryDAO.update(reportEntry);
    }

    @Override
    public void delete(int id) {
        reportEntryDAO.delete(id);
    }
}