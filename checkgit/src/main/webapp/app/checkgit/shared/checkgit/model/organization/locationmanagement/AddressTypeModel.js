Ext.define('Checkgit.checkgit.shared.checkgit.model.organization.locationmanagement.AddressTypeModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "addressTypeId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "addressType",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "addressTypeDesc",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "addressTypeIcon",
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