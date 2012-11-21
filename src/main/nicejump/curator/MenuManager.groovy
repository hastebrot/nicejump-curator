package nicejump.curator

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.MenuElement;

class MenuManager {
    
    private JMenuBar menuBar
    
    public MenuManager(JMenuBar menuBar) {
        this.menuBar = menuBar
    }
    
    JMenu findMenu(List<String> menuPath) {
        MenuElement currentMenu = this.menuBar
        for (String menuPathElement in menuPath) {
            List<MenuElement> subElements = currentMenu.getSubElements()
            println subElements.size()
            def subMenu = subElements.find { MenuElement item ->
                println item
                if (item instanceof JMenu) {
                    item.getName() == menuPathElement
                } 
            }
            currentMenu = subMenu ?: new JMenu(menuPathElement)
        }
        return currentMenu
    }
    
    void addMenu(JMenu menu, List<String> menuPath) {
        
        
    }
    
    void addMenuItem(JMenuItem menuItem, List<String> menuPath) {
        
    }
    
    void removeAll(List<String> menuPath) {
        this.menuBar.removeAll()
        this.menuBar.invalidate()
        this.menuBar.repaint()
    }
    
}
