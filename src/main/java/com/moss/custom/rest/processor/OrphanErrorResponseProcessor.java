package com.moss.custom.rest.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.moss.common.model.exception.ErrorResponse;
import com.moss.custom.exception.OrphanNotFoundException;
import com.moss.custom.lookup.constants.MessageConstants;

@Component
public class OrphanErrorResponseProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
    	
        OrphanNotFoundException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, OrphanNotFoundException.class);
        String orphanId = exception.getFieldName();
        ErrorResponse errorResponse = new ErrorResponse(MessageConstants.MISSING_QUERY_PARAMETER_EXCEPTION+ " " + orphanId);
        errorResponse.setMessage(MessageConstants.ORPHANAGE_NOT_FOUND_EXCEPTION+ " " + orphanId);

        exchange.getMessage().setHeader(Exchange.HTTP_RESPONSE_CODE, 400);
        exchange.getMessage().setBody(errorResponse);
    }
}