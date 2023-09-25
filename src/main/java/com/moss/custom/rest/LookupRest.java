package com.moss.custom.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.CollectionFormat;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.moss.custom.dto.GeneralLookupDTO;
import com.moss.custom.exception.MissingQueryParamException;
import com.moss.custom.lookup.service.AidTypeService;
import com.moss.custom.rest.processor.LookupErrorResponseProcessor;
import com.moss.custom.rest.processor.LookupProcessor;

@Component
public class LookupRest extends RouteBuilder {

	@Autowired
	private AidTypeService aidTypeService;

	@Autowired
	private LookupProcessor lookupProcessor;

	@Autowired
	private LookupErrorResponseProcessor lookupErrorResponseProcessor;

	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").host("localhost").port(8080);

		rest("/api/v1/lookups").consumes(MediaType.APPLICATION_JSON_VALUE).produces(MediaType.APPLICATION_JSON_VALUE)
				.post().route().unmarshal().json(JsonLibrary.Jackson, GeneralLookupDTO.class).process(exchange -> {
					GeneralLookupDTO aidDto = exchange.getIn().getBody(GeneralLookupDTO.class);
					aidTypeService.addAid(aidDto);
				}).marshal().json(JsonLibrary.Jackson).endRest()

				.get().param().name("lookupKeys").type(RestParamType.query).required(false).dataType("array")
				.collectionFormat(CollectionFormat.multi).endParam().route()
				.onException(MissingQueryParamException.class).handled(true).process(lookupErrorResponseProcessor)
				.marshal().json(JsonLibrary.Jackson).end().process(lookupProcessor).marshal().json(JsonLibrary.Jackson)
				.endRest();

	}
}
