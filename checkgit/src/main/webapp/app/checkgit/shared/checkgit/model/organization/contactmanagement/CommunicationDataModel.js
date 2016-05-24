Ext.define('Checkgit.checkgit.shared.checkgit.model.organization.contactmanagement.CommunicationDataModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "commDataId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "commgroupid",
          "reference": "CommunicationGroup",
          "defaultValue": ""
     }, {
          "name": "commtype",
          "reference": "CommunicationType",
          "defaultValue": ""
     }, {
          "name": "commData",
          "type": "auto",
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