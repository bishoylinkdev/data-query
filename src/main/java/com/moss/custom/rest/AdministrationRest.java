package com.moss.custom.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.moss.custom.exception.AdministrationNotFoundException;
import com.moss.custom.rest.processor.AdministrationErrorResponseProcessor;
import com.moss.custom.service.AdmininstrationService;

@Component
public class AdministrationRest extends RouteBuilder {

	@Autowired
	private AdmininstrationService admininstrationService;

	@Autowired
	private AdministrationErrorResponseProcessor adminErrorResponseProcessor;

	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").host("localhost").port(8080);

		rest("/api/v1/administrations").consumes(MediaType.APPLICATION_JSON_VALUE).produces(MediaType.APPLICATION_JSON_VALUE)
				.get("/{administrationId}/orphanages").route().onException(AdministrationNotFoundException.class).handled(true)
				.process(adminErrorResponseProcessor).marshal().json(JsonLibrary.Jackson).end().process(exchange -> {
					long administrationId = exchange.getIn().getHeader("administrationId", Long.class);
					exchange.getMessage().setBody(admininstrationService.getAdminOrphanages(administrationId));
				}).marshal().json(JsonLibrary.Jackson).endRest();
	}
}
