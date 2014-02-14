package pro.tmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pro.tmedia.dao.DisciplineDAO;
import pro.tmedia.model.Discipline;

import java.util.List;

/**
 * User: Ivaykin Timofey
 * Date: 2/12/14
 */
@Controller
public class DisciplineController {
    @Autowired
    private DisciplineDAO disciplineService;

    @RequestMapping(value = "/discipline/create")
    public ModelAndView createDisciplinePage() {
        ModelAndView modelAndView = new ModelAndView("create-discipline-form");
        modelAndView.addObject("discipline", new Discipline());
        return modelAndView;
    }

    @RequestMapping(value = "/discipline/create/process")
    public ModelAndView creatingDiscipline(@ModelAttribute Discipline discipline) {
        ModelAndView modelAndView = new ModelAndView("home");
        // String test = "Дисциплина 1 漢字";
        disciplineService.createDiscipline(discipline);
        String message = "Дисциплина успешно добавлена: " + discipline.getName() + ".";
        modelAndView.addObject("message", message );
        return modelAndView;
    }

    @RequestMapping(value = "/discipline/list")
    public ModelAndView listOfTeams() {
        ModelAndView modelAndView = new ModelAndView("list-of-disciplines");

        List<Discipline> disciplines = disciplineService.getDisciplines();
        modelAndView.addObject("disciplines", disciplines);

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

    @RequestMapping(value = "/discipline/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteDiscipline(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        disciplineService.deleteDiscipline(id);
        String message = "Дисциплина успешно удалена.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}
