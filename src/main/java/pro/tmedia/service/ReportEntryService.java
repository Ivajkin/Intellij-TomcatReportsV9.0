package pro.tmedia.service;

import pro.tmedia.model.ReportEntry;

import java.util.List;

/**
 * User: Ivaykin Timofey
 * Date: 2/16/14
 */
public interface ReportEntryService {
    public List<ReportEntry> findItems();
    public void create(ReportEntry reportEntry);
}
