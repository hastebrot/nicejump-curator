package nicejump.curator

import com.vividsolutions.jump.workbench.plugin.AbstractPlugIn;
import com.vividsolutions.jump.workbench.plugin.PlugInContext;

class MenuManagerPlugIn extends AbstractPlugIn {
    
    void initialize(PlugInContext pluginContext) {}
    
    boolean execute(PlugInContext pluginContext) {
        def featureInstaller = pluginContext.getFeatureInstaller()
        new MenuManagerControl(featureInstaller)
    }
    
}
