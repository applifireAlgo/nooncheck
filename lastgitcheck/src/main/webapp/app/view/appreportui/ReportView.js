Ext.define('Lastgitcheck.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Lastgitcheck.view.appreportui.ReportViewController',
	            'Lastgitcheck.view.appreportui.datagrid.DataGridPanel',
	            'Lastgitcheck.view.appreportui.datagrid.DataGridView',
	            'Lastgitcheck.view.appreportui.querycriteria.QueryCriteriaView',
	            'Lastgitcheck.view.appreportui.chart.ChartView',
	            'Lastgitcheck.view.appreportui.datapoint.DataPointView',
	            'Lastgitcheck.view.googlemaps.map.MapPanel',
	            'Lastgitcheck.view.appreportui.chartpoint.ChartPointView'
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
