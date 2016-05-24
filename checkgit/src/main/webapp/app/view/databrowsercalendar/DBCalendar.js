Ext.define('Checkgit.view.databrowsercalendar.DBCalendar', {
	extend : 'Checkgit.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Checkgit.view.databrowsercalendar.DBCalendarController',
	             'Checkgit.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
