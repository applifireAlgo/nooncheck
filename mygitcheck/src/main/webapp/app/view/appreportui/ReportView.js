Ext.define('Mygitcheck.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Mygitcheck.view.appreportui.ReportViewController',
	            'Mygitcheck.view.appreportui.datagrid.DataGridPanel',
	            'Mygitcheck.view.appreportui.datagrid.DataGridView',
	            'Mygitcheck.view.appreportui.querycriteria.QueryCriteriaView',
	            'Mygitcheck.view.appreportui.chart.ChartView',
	            'Mygitcheck.view.appreportui.datapoint.DataPointView',
	            'Mygitcheck.view.googlemaps.map.MapPanel',
	            'Mygitcheck.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	bodyStyle:{
        background:'#f6f6f6'
    },
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData',
		added:'onReportAdded'
	}
});
