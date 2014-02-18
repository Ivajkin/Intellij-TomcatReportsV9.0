/**
 * User: Ivaykin Timofey
 * Date: 2/18/14
 */
 $(document).ready(function() {

     var dictionaries = {
         'disciplines': {
             label: 'Список дисциплин',
             listPath: '/discipline/list.html',
             createPath: '/discipline/create.html'
         },
         'teachers': {
             label: 'Список преподавателей',
             listPath: '/teacher/list.html',
             createPath: '/teacher/create.html'
         },
         'flow': {
             label: 'Список потоков',
             listPath: '/flow/list.html',
             createPath: '/flow/create.html'
         }
     };

     function openDictionary(dictionaryID) {
         $('#listPanelFrame').attr('src', dictionaries[dictionaryID]['listPath']);
         $('#actionPanelFrame').attr('src', dictionaries[dictionaryID]['createPath']);
     }

     for(var dic in dictionaries) {
         $('<a id="'+ dic + '" href="#">' + dictionaries[dic]['label'] + '</a><br/>').appendTo("nav main");
         $('#' + dic).click(function () {
             openDictionary(this.id);
         });
     }

 });