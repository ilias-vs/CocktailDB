package project.factory;

public class OSFactory {
    public OS getOs(String OsType) {
        if (OsType.equalsIgnoreCase("Linux")) {
            return new Linux();
        } else if (OsType.equalsIgnoreCase("Mac")) {
            return new IOS();
        } else if (OsType.equalsIgnoreCase("Windows")) {
            return new Windows();
        }

        return null;
    }
}
