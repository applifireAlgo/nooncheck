Ext.define('Checkgit.checkgit.shared.checkgit.model.organization.contactmanagement.CommunicationMapModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "commMapId",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "contactid",
          "reference": "CoreContacts",
          "defaultValue": ""
     }, {
          "name": "commdataid",
          "reference": "CommunicationData",
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