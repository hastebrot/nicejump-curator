package nicejump.curator

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.yaml.snakeyaml.Yaml;

import com.vividsolutions.jump.workbench.plugin.AbstractPlugIn;
import com.vividsolutions.jump.workbench.plugin.PlugIn;
import com.vividsolutions.jump.workbench.ui.plugin.FeatureInstaller;

class MenuManagerControl {
    
    private String menubarResourcePath = "resources/menubar-default.yml"
    private String menubarToolsResourcePath = "resources/menubar-tools.yml"
    
    private MenuManager menuManager
    
    
    public MenuManagerControl(FeatureInstaller featureInstaller) {
        def classLoader = this.class.getClassLoader()

        def menuBar = featureInstaller.menuBar()
        menuBar.removeAll()
        menuBar.invalidate()
        menuBar.repaint()
        
        this.menuManager = new MenuManager(menuBar) 
        
        def menubarDefault = this.loadResource(this.menubarResourcePath)
        menubarDefault.each { String menuName, List<Object> itemsList ->
            println menuName
            menuBar.add(new JMenu(menuName))
            itemsList.each { Object element ->
                def menu = menuBar.find { it.text == menuName }
                if (element instanceof Map) {
                    if (element.name) {
                        def item = menu.add(new JMenuItem(element.name))
                        if (element.icon != null) {
                            item.setIcon(IconLoader.loadIcon(element.icon))
                        }
                        if (element.plugin != null) {
                            //def cls = classLoader.loadClass(element.plugin)
                            //AbstractPlugIn plugin = cls.newInstance()
                        }
                    }
                    else if (element.size() == 1) {
                        def name = element.keySet().toList().first()
                        def item = menu.add(new JMenu(name))
                    }
 
                }
                if (element == "-----") {
                    menu.addSeparator()
                }
            }
        }
        
        def menubarToolsDefault = this.loadResource(this.menubarToolsResourcePath)
        menubarToolsDefault.each { String menuName, Map<Object> subMenuItems ->
            println menuName
            menuBar.add(new JMenu(menuName), 4)
            
            subMenuItems.each { String menuName2, List<Object> itemsList ->
                def menu = menuBar.find { it.text == menuName }
                menu.add(new JMenu(menuName2))
                
                itemsList.each { Object element ->
                    def menu2 = menu.find { it.text == menuName2 }
                    
                    if (element instanceof Map) {
                        println "  ${element.name}"
                        
                        menu2.add(new JMenuItem(element.name))
                        
                        if (element.plugin != null) {
                            //def cls = classLoader.loadClass(element.plugin)
                            //AbstractPlugIn plugin = cls.newInstance()
                        }
                    }
                    if (element == "-----") {
                        menu2.addSeparator()
                    }
                }
            }
            
            
            

        }
    }
    
    protected Object loadResource(String resourcePath) {
        def resource = this.class.getResourceAsStream(resourcePath)
        def yaml = new Yaml()
        return yaml.load(resource)
    }
    
    static void main(String[] args) {
        def menuManager = new MenuManagerControl()
    }
    
}
