package cn.sh.lz.ej.r1.ServiceProviderFramework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Link at 16:41 on 2021/01/21.
 */
// Noninstantiable class for service registration and access
public class Services {
    //    Prevents instantiation
    private Services() {
    }

    //    Map Service Names to Services
    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();

    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    //    Provider registration API
    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    //    Service access API
    public static Service newInstance(String name) {
        Provider p = providers.get(name);


        if (null == p) {
            throw new IllegalArgumentException("No provider registered with name: " + name);
        }
        return p.newService();
    }

    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }
}
