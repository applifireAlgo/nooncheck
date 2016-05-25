Ext.define('Lastgitcheck.lastgitcheck.shared.lastgitcheck.model.organization.locationmanagement.NewEntityModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "entityId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "entityname",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});