package nicejump.curator

import com.vividsolutions.jump.workbench.plugin.Extension;
import com.vividsolutions.jump.workbench.plugin.PlugInContext;
import com.vividsolutions.jump.workbench.ui.plugin.FeatureInstaller;

class NicejumpCuratorExtension extends Extension {
    
    void configure(PlugInContext pluginContext) {
        def featureInstaller = pluginContext.getFeatureInstaller()
        
        def plugin = new MenuManagerPlugIn()
        featureInstaller.addMainMenuItem(plugin, "NiceJUMP", "MenuManager",
            null, null)
    }
    
}
