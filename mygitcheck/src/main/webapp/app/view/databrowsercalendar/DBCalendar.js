Ext.define('Mygitcheck.view.databrowsercalendar.DBCalendar', {
	extend : 'Mygitcheck.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Mygitcheck.view.databrowsercalendar.DBCalendarController',
	             'Mygitcheck.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	/*listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}*/
});
