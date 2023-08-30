package config;

import org.aeonbits.owner.Accessible;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.ConfigCache;


@LoadPolicy(LoadType.MERGE)
@Sources("file:src/test/resources/config.properties")
public interface Properties extends Accessible{

    @Key("browser")
    String browser();
    @Key("URL")
    String URL();
    @Key("APIURL")
    String APIURL();
    @Key("CPMURL")
    String CPMURL();
    @Key("client_id")
    String client_id();
    @Key("client_secret")
    String client_secret();
    @Key("org62AccountId")
    String org62AccountId();
    static Properties getConfig(){return ConfigCache.getOrCreate(Properties.class);}
}
