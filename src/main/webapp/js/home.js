/**
 * User: Ivaykin Timofey
 * Date: 2/18/14
 */
 $(document).ready(function() {

     var dictionaries = {
         'disciplines': {
             label: 'Список дисциплин',
             listPath: '/discipline/list.html',
             createPath: '/discipline/create.html',
             icon: 'disciplineIcon.png'
         },
         'teachers': {
             label: 'Список преподавателей',
             listPath: '/teacher/list.html',
             createPath: '/teacher/create.html',
             icon: 'teacherIcon.png'
         },
         'flows': {
             label: 'Список потоков',
             listPath: '/flow/list.html',
             createPath: '/flow/create.html',
             icon: 'flowIcon.png'
         },
         'semesters': {
             label: 'Список семестров',
             listPath: '/semester/list.html',
             createPath: '/semester/create.html',
             icon: 'semesterIcon.png'
         },
         'departments': {
             label: 'Список кафедр',
             listPath: '/department/list.html',
             createPath: '/department/create.html',
             icon: 'departmentIcon.png'
         },
         'reports': {
             label: 'Вывести отчет',
             listPath: '/report/list.html',
             createPath: '/report/actions.html',
             icon: 'reportIcon.png'
         }
     };

     function openDictionary(dictionaryID) {
         $('#listPanelFrame').attr('src', dictionaries[dictionaryID]['listPath']);
         $('#actionPanelFrame').attr('src', dictionaries[dictionaryID]['createPath']);
     }

     for(var dic in dictionaries) {
         $('<a class="tableButton" id="'+ dic + '" href="#">'
             + '<img class="tableIcon" src="/img/' + dictionaries[dic]['icon'] + '" />'
             + dictionaries[dic]['label'] + '</a><br/>').appendTo("nav main");
         $('#' + dic).click(function () {
             openDictionary(this.id);
         });
     }

 });