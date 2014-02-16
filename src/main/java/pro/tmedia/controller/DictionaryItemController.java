package pro.tmedia.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: Ivaykin Timofey
 * Date: 2/16/14
 */
public interface DictionaryItemController<T> {
    public ModelAndView createPage();
    public ModelAndView creating(@ModelAttribute T discipline);
    public ModelAndView listOfItems();
    public ModelAndView delete(@PathVariable Integer id);
}
