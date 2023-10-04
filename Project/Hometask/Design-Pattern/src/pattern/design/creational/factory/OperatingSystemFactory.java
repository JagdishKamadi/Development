package pattern.design.creational.factory;

public class OperatingSystemFactory {
    public OS getInstance(String operatingSystemType)
    {
        if(operatingSystemType == null)
            return null;

        if(operatingSystemType.equalsIgnoreCase("Powerful"))
            return new Android();
        else if(operatingSystemType.equalsIgnoreCase("Secure"))
            return new IOS();
        else if (operatingSystemType.equalsIgnoreCase("Easy to use"))
            return new Windows();

        // anything not matches
        return null;
    }
}
