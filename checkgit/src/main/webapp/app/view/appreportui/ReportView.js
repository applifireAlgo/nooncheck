Ext.define('Checkgit.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Checkgit.view.appreportui.ReportViewController',
	            'Checkgit.view.appreportui.datagrid.DataGridPanel',
	            'Checkgit.view.appreportui.datagrid.DataGridView',
	            'Checkgit.view.appreportui.querycriteria.QueryCriteriaView',
	            'Checkgit.view.appreportui.chart.ChartView',
	            'Checkgit.view.appreportui.datapoint.DataPointView',
	            'Checkgit.view.googlemaps.map.MapPanel',
	            'Checkgit.view.appreportui.chartpoint.ChartPointView'
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
		boxready : 'fetchReportData'
	}
});
