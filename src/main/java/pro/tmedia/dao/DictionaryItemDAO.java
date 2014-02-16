package pro.tmedia.dao;

import org.springframework.transaction.annotation.Transactional;
import pro.tmedia.model.DictionaryItem;

import java.util.List;

/**
 * User: Ivaykin Timofey
 * Date: 2/12/14
 */
@Transactional
public interface DictionaryItemDAO<T> {
    public void create(DictionaryItem dictionaryItem);
    public T find(int id);
    public void delete(int id);
    public List<T> findItems();
}
