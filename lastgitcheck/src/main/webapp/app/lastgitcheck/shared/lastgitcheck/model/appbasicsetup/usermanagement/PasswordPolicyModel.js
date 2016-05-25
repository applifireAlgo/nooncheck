Ext.define('Lastgitcheck.lastgitcheck.shared.lastgitcheck.model.appbasicsetup.usermanagement.PasswordPolicyModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "policyId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "policyName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "policyDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "maxPwdLength",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "minPwdLength",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "minCapitalLetters",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "minSmallLetters",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "minNumericValues",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "minSpecialLetters",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "allowedSpecialLetters",
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