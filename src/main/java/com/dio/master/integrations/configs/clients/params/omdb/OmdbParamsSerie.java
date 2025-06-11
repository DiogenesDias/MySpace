package com.dio.master.integrations.configs.clients.params.omdb;


import com.dio.master.infra.configs.beans.RscsPropertiesIntegrations;
import com.dio.master.infra.configs.beans.RscsSecurityIntegrations;
import com.dio.master.integrations.configs.IntegrationsParams;

public class OmdbParamsSerie extends IntegrationsParams {

    protected String queryParams_i;
    protected String queryParams_Apikey;

    public OmdbParamsSerie(String imdbId) {
        super();
        this.queryParams_i = imdbId;
        this.queryParams_Apikey = RscsSecurityIntegrations.Omdb().keyIntegration();
        this.baseURL = RscsPropertiesIntegrations.Omdb().propertyBaseURL();
    }
}