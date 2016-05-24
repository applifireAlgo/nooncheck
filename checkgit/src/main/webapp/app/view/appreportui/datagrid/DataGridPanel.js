Ext.define('Checkgit.view.appreportui.datagrid.DataGridPanel', {
	extend : 'Ext.panel.Panel',
	requires : ['Checkgit.view.appreportui.datagrid.DataGridPanelController'],
	controller:'dataGridPanelController',
	xtype:'dataGridPanel',
	itemId:'datagridpanelId',
	layout:'fit',
	reportView:null,
	reportDataJson:null,
	bodyStyle:{
        background:"#f6f6f6"
	},
	listeners:{
		scope:'controller',
		added:'afterDataGridPanelAdded'
	}
});