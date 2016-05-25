Ext.define('Lastgitcheck.view.databrowsercalendar.DBCalendar', {
	extend : 'Lastgitcheck.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Lastgitcheck.view.databrowsercalendar.DBCalendarController',
	             'Lastgitcheck.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
