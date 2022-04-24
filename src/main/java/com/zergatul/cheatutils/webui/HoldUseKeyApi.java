package com.zergatul.cheatutils.webui;

import com.zergatul.cheatutils.configs.ConfigStore;
import org.apache.http.MethodNotSupportedException;

public class HoldUseKeyApi extends ApiBase {

    @Override
    public String getRoute() {
        return "hold-use-key";
    }

    @Override
    public String get() throws MethodNotSupportedException {
        return Boolean.toString(ConfigStore.instance.holdUseKey);
    }

    @Override
    public String post(String body) throws MethodNotSupportedException {
        ConfigStore.instance.holdUseKey = Boolean.parseBoolean(body);
        ConfigStore.instance.write();
        return get();
    }

}
