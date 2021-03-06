Ext.define('Checkgit.checkgit.shared.checkgit.model.organization.locationmanagement.CityModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "cityId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "countryid",
          "reference": "Country",
          "defaultValue": ""
     }, {
          "name": "stateid",
          "reference": "State",
          "defaultValue": ""
     }, {
          "name": "cityName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "cityCodeChar2",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "cityCode",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "cityDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "cityFlag",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "cityLatitude",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "cityLongitude",
          "type": "number",
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