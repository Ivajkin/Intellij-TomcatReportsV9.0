package pro.tmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pro.tmedia.dao.DictionaryItemDAO;
import pro.tmedia.dao.DisciplineDAO;
import pro.tmedia.dao.DisciplineDAOImpl;
import pro.tmedia.model.DictionaryItem;
import pro.tmedia.model.Discipline;

import java.util.List;

/**
 * User: Ivaykin Timofey
 * Date: 2/12/14
 */
@Controller
@RequestMapping("/discipline")
public class DisciplineController extends DictionaryItemController<Discipline> {
    @Autowired
    private DisciplineDAO disciplineService;

    @Override
    protected Discipline getNewDictionaryItem() {
        return new Discipline();
    }

    @Override
    protected String createDictionaryItemDB(Discipline discipline) {
        disciplineService.create(discipline);
        String message = "Дисциплина успешно добавлена: " + discipline.getName() + ".";
        return message;
    }

    @Override
    protected List<Discipline> getItems() {
        return disciplineService.findItems();
    }

    @Override
    protected String deleteItem(Integer id) {
        disciplineService.delete(id);
        String message = "Дисциплина успешно удалена.";
        return message;
    }

    @Override
    protected String getDictionaryTypePath() {
        return "/discipline";
    }

    @Override
    protected String getPanelHeaderInfo() {
        return "Список дисциплин";
    }

    @Override
    protected String getPanelDescriptionInfo() {
        return "Здесь вы можете видеть список дисциплин, удалять и добавлять.";
    }
}
