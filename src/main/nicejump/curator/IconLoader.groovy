package nicejump.curator

import javax.swing.ImageIcon

class IconLoader {

    static ImageIcon icon(String filename) {
        def resourceUrl = IconLoader.class.getResource(filename)
        if (resourceUrl == null) {
            throw new IconLoaderException(filename)
        }
        return new ImageIcon(resourceUrl)
    }

    static ImageIcon loadIcon(String filename) {
        this.icon("resources/" + filename)
    }

}
