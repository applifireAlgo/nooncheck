Ext.define('Lastgitcheck.lastgitcheck.web.lastgitcheck.view.organization.locationmanagement.NewEntityMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "NewEntityMainController",
     "restURL": "/NewEntity",
     "defaults": {
          "split": true
     },
     "requires": ["Lastgitcheck.lastgitcheck.shared.lastgitcheck.model.organization.locationmanagement.NewEntityModel", "Lastgitcheck.lastgitcheck.web.lastgitcheck.controller.organization.locationmanagement.NewEntityMainController", "Lastgitcheck.lastgitcheck.shared.lastgitcheck.viewmodel.organization.locationmanagement.NewEntityViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "NewEntity",
               "name": "NewEntityTreeContainer",
               "itemId": "NewEntityTreeContainer",
               "restURL": "/NewEntity",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "name": "entityTreePanel",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "NewEntityTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "NewEntity",
                    "title": "NewEntity",
                    "name": "NewEntity",
                    "itemId": "NewEntityForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "entityId",
                         "itemId": "entityId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "entityId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "entityId<font color='red'> *<\/font>",
                         "fieldId": "1666ED62-AF76-4211-8399-9F37783D9F06",
                         "hidden": true,
                         "value": "",
                         "bindable": "entityId"
                    }, {
                         "name": "entityname",
                         "itemId": "entityname",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "entityname",
                         "margin": "5 5 5 5",
                         "fieldLabel": "entityname<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "03CE3D69-F0A5-4985-88AC-F5D051F30EAF",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "entityname",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "49A3FD0F-552B-4895-A917-9119130EA82F",
                         "bindable": "versionId",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isToolBar": true,
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 657,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 657,
                              "customId": 131
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": 5,
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 657,
                              "customId": 132,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "resetFormButton",
                              "margin": 5,
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 657,
                              "customId": 133,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }]
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "NewEntity",
                    "title": "Details Grid",
                    "name": "NewEntityGrid",
                    "itemId": "NewEntityGrid",
                    "restURL": "/NewEntity",
                    "store": [],
                    "columns": [{
                         "header": "entityId",
                         "dataIndex": "entityId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "entityname",
                         "dataIndex": "entityname",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "xtype": "form",
               "displayName": "NewEntity",
               "title": "NewEntity",
               "name": "NewEntity",
               "itemId": "NewEntityForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "entityId",
                    "itemId": "entityId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "entityId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "entityId<font color='red'> *<\/font>",
                    "fieldId": "1666ED62-AF76-4211-8399-9F37783D9F06",
                    "hidden": true,
                    "value": "",
                    "bindable": "entityId"
               }, {
                    "name": "entityname",
                    "itemId": "entityname",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "entityname",
                    "margin": "5 5 5 5",
                    "fieldLabel": "entityname<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "03CE3D69-F0A5-4985-88AC-F5D051F30EAF",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "entityname",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "49A3FD0F-552B-4895-A917-9119130EA82F",
                    "bindable": "versionId",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isToolBar": true,
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 657,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 657,
                         "customId": 131
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": 5,
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 657,
                         "customId": 132,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "resetFormButton",
                         "margin": 5,
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 657,
                         "customId": 133,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }]
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});