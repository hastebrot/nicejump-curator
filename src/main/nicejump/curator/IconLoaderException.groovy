package nicejump.curator

class IconLoaderException extends Exception {

    public IconLoaderException(String filename) {
        super("Failed to load icon '${filename}'.".toString())
    }

}
