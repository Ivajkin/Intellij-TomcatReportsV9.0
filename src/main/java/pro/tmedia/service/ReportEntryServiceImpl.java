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
    public List<ReportEntry> findItems() {
        return reportEntryDAO.findItems();
    }
}