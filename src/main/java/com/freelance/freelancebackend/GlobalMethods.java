package com.freelance.freelancebackend;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import com.google.gson.GsonBuilder;
import javax.servlet.http.HttpServletResponse;
import com.freelance.freelancebackend.exception.ErrorResponse;
import com.freelance.freelancebackend.security.SecurityConstants;

public class GlobalMethods {

    public static String dateTimeFormatter(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMATTER);
        return formatter.format(localDateTime);
    }

    public static DateTimeFormatter dateTimeFormatterPattern(){
        return DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMATTER);
    }

    public static void responseHandler(HttpServletResponse response, String errorMessage, int statusCode) throws IOException{

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializerAndDeserializer());
        response.setContentType(SecurityConstants.CONTENT_TYPE);
        response.setCharacterEncoding(SecurityConstants.CHAR_ENCOCDE);
        response.setStatus(statusCode);
        response.getWriter().print(gsonBuilder.setPrettyPrinting().create().toJson(new ErrorResponse(Arrays.asList(errorMessage))));
        response.getWriter().flush();
    } 
    
}
