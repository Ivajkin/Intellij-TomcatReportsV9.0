package pro.tmedia.dao;

import org.springframework.transaction.annotation.Transactional;
import pro.tmedia.model.ReportEntry;

import java.util.List;

/**
 * User: Ivaykin Timofey
 * Date: 2/19/14
 */
@Transactional
public interface ReportEntryDAO {
    public List<ReportEntry> findItems();
    public void create(ReportEntry reportEntry);
}
