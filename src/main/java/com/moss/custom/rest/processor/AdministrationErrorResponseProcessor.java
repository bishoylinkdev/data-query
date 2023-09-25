package com.moss.custom.rest.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.moss.common.model.exception.ErrorResponse;
import com.moss.custom.exception.OrphanageNotFoundException;
import com.moss.custom.lookup.constants.MessageConstants;

@Component
public class AdministrationErrorResponseProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
    	
        OrphanageNotFoundException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, OrphanageNotFoundException.class);
        String adminId = exception.getFieldName();
        ErrorResponse errorResponse = new ErrorResponse(MessageConstants.MISSING_QUERY_PARAMETER_EXCEPTION+ " " + adminId);
        errorResponse.setMessage(MessageConstants.ORPHANAGE_NOT_FOUND_EXCEPTION+ " " + adminId);

        exchange.getMessage().setHeader(Exchange.HTTP_RESPONSE_CODE, 400);
        exchange.getMessage().setBody(errorResponse);
    }
}