package com.dio.master.integrations.configs.clients.params.omdb;

import com.dio.master.infra.configs.beans.RscsPropertiesIntegrations;
import com.dio.master.infra.configs.beans.RscsSecurityIntegrations;
import com.dio.master.integrations.configs.IntegrationsParams;

public class OmdbParamsEpisode extends IntegrationsParams {

    protected String queryParams_i;
    protected Integer queryParams_season;
    protected String queryParams_Apikey;

    public OmdbParamsEpisode(String imdbId, Integer season) {
        super();
        this.queryParams_i = imdbId;
        this.queryParams_season = season;
        this.queryParams_Apikey = RscsSecurityIntegrations.Omdb().keyIntegration();
        this.baseURL = RscsPropertiesIntegrations.Omdb().propertyBaseURL();
    }
}