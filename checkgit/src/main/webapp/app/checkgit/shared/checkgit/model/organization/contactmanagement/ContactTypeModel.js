Ext.define('Checkgit.checkgit.shared.checkgit.model.organization.contactmanagement.ContactTypeModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "contactTypeId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "contactType",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "contactTypeDesc",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "contactTypeIcon",
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