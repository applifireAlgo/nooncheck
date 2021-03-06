Ext.define('Lastgitcheck.lastgitcheck.shared.lastgitcheck.model.appbasicsetup.usermanagement.UserAccessLevelModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "userAccessLevelId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "userAccessLevel",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "levelName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "levelDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "levelHelp",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "levelIcon",
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