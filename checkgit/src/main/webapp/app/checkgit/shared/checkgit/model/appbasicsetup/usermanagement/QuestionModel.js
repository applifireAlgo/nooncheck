Ext.define('Checkgit.checkgit.shared.checkgit.model.appbasicsetup.usermanagement.QuestionModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "questionId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "levelid",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "question",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "questionDetails",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "questionIcon",
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