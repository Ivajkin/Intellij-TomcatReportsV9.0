package pro.tmedia.service;

import pro.tmedia.model.Discipline;

import java.util.List;

/**
 * User: Ivaykin Timofey
 * Date: 2/16/14
 */
public interface DictionaryItemService<T> {
    public void create(T dictionaryItem);
    public T find(int id);
    public void delete(int id);
    public List<T> findItems();
}
