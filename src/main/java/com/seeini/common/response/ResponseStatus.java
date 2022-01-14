package com.seeini.common.response;


import org.springframework.lang.Nullable;

public enum ResponseStatus {
    CONTINUE(100, "Continue"),
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),
    PROCESSING(102, "Processing"),
    CHECKPOINT(103, "Checkpoint"),
//    OK(200, "OK"),
    SUCCESS(200, "SUCCESS"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information"),
    NO_CONTENT(204, "No Content"),
    RESET_CONTENT(205, "Reset Content"),
    PARTIAL_CONTENT(206, "Partial Content"),
    MULTI_STATUS(207, "Multi-Status"),
    ALREADY_REPORTED(208, "Already Reported"),
    IM_USED(226, "IM Used"),
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    FOUND(302, "Found"),
    /** @deprecated */
    @Deprecated
    MOVED_TEMPORARILY(302, "Moved Temporarily"),
    SEE_OTHER(303, "See Other"),
    NOT_MODIFIED(304, "Not Modified"),
    /** @deprecated */
    @Deprecated
    USE_PROXY(305, "Use Proxy"),
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),
    PERMANENT_REDIRECT(308, "Permanent Redirect"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    PAYMENT_REQUIRED(402, "Payment Required"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    NOT_ACCEPTABLE(406, "Not Acceptable"),
    PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"),
    REQUEST_TIMEOUT(408, "Request Timeout"),
    CONFLICT(409, "Conflict"),
    GONE(410, "Gone"),
    LENGTH_REQUIRED(411, "Length Required"),
    PRECONDITION_FAILED(412, "Precondition Failed"),
    PAYLOAD_TOO_LARGE(413, "Payload Too Large"),
    /** @deprecated */
    @Deprecated
    REQUEST_ENTITY_TOO_LARGE(413, "Request Entity Too Large"),
    URI_TOO_LONG(414, "URI Too Long"),
    /** @deprecated */
    @Deprecated
    REQUEST_URI_TOO_LONG(414, "Request-URI Too Long"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    REQUESTED_RANGE_NOT_SATISFIABLE(416, "Requested range not satisfiable"),
    EXPECTATION_FAILED(417, "Expectation Failed"),
    I_AM_A_TEAPOT(418, "I'm a teapot"),
    /** @deprecated */
    @Deprecated
    INSUFFICIENT_SPACE_ON_RESOURCE(419, "Insufficient Space On Resource"),
    /** @deprecated */
    @Deprecated
    METHOD_FAILURE(420, "Method Failure"),
    /** @deprecated */
    @Deprecated
    DESTINATION_LOCKED(421, "Destination Locked"),
    UNPROCESSABLE_ENTITY(422, "Unprocessable Entity"),
    LOCKED(423, "Locked"),
    FAILED_DEPENDENCY(424, "Failed Dependency"),
    TOO_EARLY(425, "Too Early"),
    UPGRADE_REQUIRED(426, "Upgrade Required"),
    PRECONDITION_REQUIRED(428, "Precondition Required"),
    TOO_MANY_REQUESTS(429, "Too Many Requests"),
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"),
    UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable For Legal Reasons"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTED(501, "Not Implemented"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version not supported"),
    VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates"),
    INSUFFICIENT_STORAGE(507, "Insufficient Storage"),
    LOOP_DETECTED(508, "Loop Detected"),
    BANDWIDTH_LIMIT_EXCEEDED(509, "Bandwidth Limit Exceeded"),
    NOT_EXTENDED(510, "Not Extended"),
    NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required"),
    NO_STATUS(999, "No Status");

    private int code;

    private String msg;

    ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String toString() {
        return this.code + "," + this.msg;
    }

//    public int getCode() {
//        return code;
//    }
//
//    public String getMsg() {
//        return msg;
//    }



    //    private final int value;
//    private final String reasonPhrase;
//
//    private ResponseStatus(int value, String reasonPhrase) {
//        this.value = value;
//        this.reasonPhrase = reasonPhrase;
//    }
//
//    public int value() {
//        return this.value;
//    }
//
//    public String getReasonPhrase() {
//        return this.reasonPhrase;
//    }
//
//    public ResponseStatus.Series series() {
//        return ResponseStatus.Series.valueOf(this);
//    }
//
//    public boolean is1xxInformational() {
//        return this.series() == ResponseStatus.Series.INFORMATIONAL;
//    }
//
//    public boolean is2xxSuccessful() {
//        return this.series() == ResponseStatus.Series.SUCCESSFUL;
//    }
//
//    public boolean is3xxRedirection() {
//        return this.series() == ResponseStatus.Series.REDIRECTION;
//    }
//
//    public boolean is4xxClientError() {
//        return this.series() == ResponseStatus.Series.CLIENT_ERROR;
//    }
//
//    public boolean is5xxServerError() {
//        return this.series() == ResponseStatus.Series.SERVER_ERROR;
//    }
//
//    public boolean isError() {
//        return this.is4xxClientError() || this.is5xxServerError();
//    }

    public static String getMsg(int code) {
        ResponseStatus status = resolve(code);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        } else {
            return status.msg;
        }
    }

    public static int getCode(String msg) {
        ResponseStatus status = resolve(msg);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + msg + "]");
        } else {
            return status.code;
        }
    }


    public static ResponseStatus getResponseStatus(int code) {
        ResponseStatus status = resolve(code);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        } else {
            return status;
        }
    }

    public static ResponseStatus getResponseStatus(String msg) {
        ResponseStatus status = resolve(msg);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + msg + "]");
        } else {
            return status;
        }
    }


    @Nullable
    public static ResponseStatus resolve(int statusCode) {

        for (ResponseStatus rs:ResponseStatus.values()) {
            if (statusCode == rs.code){
                return rs;
            }
        }
        return null;
//        ResponseStatus[] var1 = values();
//        int var2 = var1.length;
//
//        for(int var3 = 0; var3 < var2; ++var3) {
//            ResponseStatus status = var1[var3];
//            if (status.code == statusCode) {
//                return status;
//            }
//        }
//        return null;
    }

//    @Nullable
//    public static ResponseStatus resolve(int statusCode) {
//        ResponseStatus[] var1 = values();
//        int var2 = var1.length;
//
//        for(int var3 = 0; var3 < var2; ++var3) {
//            ResponseStatus status = var1[var3];
//            if (status.code == statusCode) {
//                return status;
//            }
//        }
//
//        return null;
//    }

    @Nullable
    public static ResponseStatus resolve(String msg) {
        ResponseStatus[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ResponseStatus status = var1[var3];
            if (status.msg == msg) {
                return status;
            }
        }

        return null;
    }

//    public static enum Series {
//        INFORMATIONAL(1),
//        SUCCESSFUL(2),
//        REDIRECTION(3),
//        CLIENT_ERROR(4),
//        SERVER_ERROR(5);
//
//        private final int value;
//
//        private Series(int value) {
//            this.value = value;
//        }
//
//        public int value() {
//            return this.value;
//        }
//
//        public static ResponseStatus.Series valueOf(ResponseStatus status) {
//            return valueOf(status.msg);
//        }
//
//        public static ResponseStatus.Series valueOf(int statusCode) {
//            ResponseStatus.Series series = resolve(statusCode);
//            if (series == null) {
//                throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
//            } else {
//                return series;
//            }
//        }
//
//        @Nullable
//        public static ResponseStatus.Series resolve(int statusCode) {
//            int seriesCode = statusCode / 100;
//            ResponseStatus.Series[] var2 = values();
//            int var3 = var2.length;
//
//            for(int var4 = 0; var4 < var3; ++var4) {
//                ResponseStatus.Series series = var2[var4];
//                if (series.value == seriesCode) {
//                    return series;
//                }
//            }
//
//            return null;
//        }
//    }
}
