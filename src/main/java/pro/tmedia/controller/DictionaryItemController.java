package pro.tmedia.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pro.tmedia.model.Discipline;

import java.util.List;

/**
 * User: Ivaykin Timofey
 * Date: 2/16/14
 */
public abstract class DictionaryItemController<T> {

    @RequestMapping(value = "/create")
    public final ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView("create-dictionary-item-form");
        modelAndView.addObject("dictionaryItem", getNewDictionaryItem());
        modelAndView.addObject("dictionaryTypePath", getDictionaryTypePath());

        return modelAndView;
    }

    @RequestMapping(value = "/create/process")
    public final ModelAndView creating(@ModelAttribute T dictionaryItem) {
        ModelAndView modelAndView = createPage();

        String message = createDictionaryItemDB(dictionaryItem);
        modelAndView.addObject("message", message );
        return modelAndView;
    }

    @RequestMapping(value = "/list")
    public final ModelAndView listOfItems() {
        ModelAndView modelAndView = new ModelAndView("list-of-dictionary-items");

        List<T> dictionaryItems = getItems();

        modelAndView.addObject("dictionaryItems", dictionaryItems);
        modelAndView.addObject("dictionaryTypePath", getDictionaryTypePath());

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public final ModelAndView delete(@PathVariable Integer id) {
        String message = deleteItem(id);
        ModelAndView modelAndView = listOfItems();
        modelAndView.addObject("message", message);
        return modelAndView;
    }
    /*
    FOR UPDATE:
    @RequestMapping(value="/team/edit/{id}", method=RequestMethod.GET)
    39
    public ModelAndView editTeamPage(@PathVariable Integer id) {
        40
        ModelAndView modelAndView = new ModelAndView("edit-team-form");
        41
        Team team = teamService.getTeam(id);
        42
        modelAndView.addObject("team",team);
        43
        return modelAndView;
        44
    }
    @RequestMapping(value="/team/edit/{id}", method=RequestMethod.POST)
47
    public ModelAndView edditingTeam(@ModelAttribute Team team, @PathVariable Integer id) {
48

49
        ModelAndView modelAndView = new ModelAndView("home");
50

51
        teamService.updateTeam(team);
52

53
        String message = "Team was successfully edited.";
54
        modelAndView.addObject("message", message);
55

56
        return modelAndView;
57
    }

           */

    protected abstract T getNewDictionaryItem();
    protected abstract String createDictionaryItemDB(T item);
    protected abstract List<T> getItems();
    protected abstract String deleteItem(Integer id);
    protected abstract String getDictionaryTypePath();
}
