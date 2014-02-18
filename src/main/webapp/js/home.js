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
         }
     };

     for(var dic in dictionaries) {
         $('<a id="'+ dic + '" href="#">' + dictionaries[dic]['label'] + '</a><br/>').appendTo("nav main");
         $(dic).click(function() {
             $('listPanelFrame').attr({src:dictionaries[dic]['listPath']});
             $('actionPanelFrame').attr({src:dictionaries[dic]['createPath']});
         });
     }

 });