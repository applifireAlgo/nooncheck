Ext.define('Checkgit.checkgit.shared.checkgit.model.appbasicsetup.usermanagement.PassRecoveryModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "passRecoveryId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "questionid",
          "reference": "Question",
          "defaultValue": ""
     }, {
          "name": "answer",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "User",
          "reference": "UserModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});