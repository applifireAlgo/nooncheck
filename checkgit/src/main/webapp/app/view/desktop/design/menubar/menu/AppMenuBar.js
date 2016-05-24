Ext.define('Checkgit.view.desktop.design.menubar.menu.AppMenuBar', {
    extend : 'Ext.panel.Panel',
    xtype : 'appMenuBar',
    requires : ['Checkgit.view.desktop.design.menubar.menu.AppMenuBarController'],
    userinfo:{},
    id:'appMenuBar',
    controller:'appMenuBar',
   
    layout: {
        type: 'hbox'
    },
    bodyStyle:{
           background:"none"
        },
    defaults:{
        arrowVisible :false,
        scale:'medium',
        xtype:'button',
        margin:'0 10 0 0',
        border:false,
        style:{
            background:"transparent"

        },
        listeners : {mouseover : function() { this.menu.showBy(this); } }

    },
    
    listeners:{
        afterrender:'onMenuBarAfterRender'
    }
    

});
