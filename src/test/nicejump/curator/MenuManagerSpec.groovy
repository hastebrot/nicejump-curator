package nicejump.curator

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import spock.lang.Specification;

class MenuManagerSpec extends Specification {
    
    MenuManager menuManager
    
    def setup() {
        def item1 = new JMenu("hurr")
        def item2 = new JMenu("durr")
        def item3 = new JMenuItem("derp")
        def menuBar = new JMenuBar()
        menuBar << (item1 << (item2 << item3))
        menuManager = new MenuManager(menuBar)
    }
    
    def "find existing menu"() {
        expect:
        menuManager.findMenu(["hurr"]).getText() == "hurr"
        menuManager.findMenu(["hurr", "durr"]).getText() == "durr"
    }
    
    def "find existing menuitem throws exception"() {
        expect:
        menuManager.findMenu(["hurr", "durr", "derp"]).getText() == null
    }
    
    def "find existing menu, create not existing"() {
        expect:
        menuManager.findMenu(["missing"]).getText() == null
        menuManager.findMenu(["hurr", "missing"]).getText() == null
        menuManager.findMenu(["hurr", "durr", "missing"]).getText() == null
        
        and:
        menuManager.findMenu(["missing", "hurr"]).getText() == null
    }
    
}
