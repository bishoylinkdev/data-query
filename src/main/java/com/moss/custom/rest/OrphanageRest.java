package com.moss.custom.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.moss.custom.exception.OrphanageNotFoundException;
import com.moss.custom.rest.processor.OrphanageErrorResponseProcessor;
import com.moss.custom.service.OrphanageService;

@Component
public class OrphanageRest extends RouteBuilder {

	@Autowired
	private OrphanageService orphanageService;

	@Autowired
	private OrphanageErrorResponseProcessor orphanageErrorResponseProcessor;

	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").host("localhost").port(8080);

		rest("/api/v1/orphanages").consumes(MediaType.APPLICATION_JSON_VALUE).produces(MediaType.APPLICATION_JSON_VALUE)
				.get("/{orphanageId}").route().onException(OrphanageNotFoundException.class).handled(true)
				.process(orphanageErrorResponseProcessor).marshal().json(JsonLibrary.Jackson).end().process(exchange -> {
					long orphanageID = exchange.getIn().getHeader("orphanageId", Long.class);
					exchange.getMessage().setBody(orphanageService.getOrphanage(orphanageID));
				}).marshal().json(JsonLibrary.Jackson).endRest()

				.get("/{orphanageId}/orphans").route().onException(OrphanageNotFoundException.class).handled(true)
				.process(orphanageErrorResponseProcessor).marshal().json(JsonLibrary.Jackson).end().process(exchange -> {
					long orphanageID = exchange.getIn().getHeader("orphanageId", Long.class);
					exchange.getMessage().setBody(orphanageService.getOrphanageOrphans(orphanageID));
				}).marshal().json(JsonLibrary.Jackson).endRest();
	}
}
