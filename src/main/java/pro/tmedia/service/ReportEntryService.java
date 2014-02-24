package pro.tmedia.service;

import pro.tmedia.model.ReportEntry;

import java.util.List;

/**
 * User: Ivaykin Timofey
 * Date: 2/16/14
 */
public interface ReportEntryService {
    public List<ReportEntry> findItems();
    public ReportEntry find(final Integer id);
    public void update(ReportEntry reportEntry);
    public void create(ReportEntry reportEntry);


    public void delete(final int id);
}
