package com.tsekhanovich.functional.practice14;

import java.security.MessageDigest;
import java.util.Base64;

/**
 * @author Pavel Tsekhanovcih 11.11.2018
 * <p>
 * There is a class Request(data: String) for representing some XML requests in a payment system.
 * The class has a getter method getData() and a constructor with one argument (data). See below.
 * <p>
 * Typically, the value of data looks like shown below (in a human-readable format,
 * in processing it's a single line string).
 */

public class Task1 {

    /**
     * Accepts a request and returns new request with data wrapped in the tag <transaction>...</transaction>
     */
    final static RequestHandler wrapInTransactionTag =
            (req) -> new Request(String.format("<transaction>%s</transaction>", req.getData()));

    /**
     * Accepts a request and returns a new request with calculated digest inside the tag <digest>...</digest>
     */
    final static RequestHandler createDigest =
            (req) -> {
                String digest = "";
                try {
                    final MessageDigest md5 = MessageDigest.getInstance("MD5");
                    final byte[] digestBytes = md5.digest(req.getData().getBytes("UTF-8"));
                    digest = new String(Base64.getEncoder().encode(digestBytes));
                } catch (Exception ignored) {
                }
                return new Request(req.getData() + String.format("<digest>%s</digest>", digest));
            };

    /**
     * Accepts a request and returns a new request with data wrapped in the tag <request>...</request>
     */
    final static RequestHandler wrapInRequestTag =
            (req) -> new Request(String.format("<request>%s</request>", req.getData()));

    /**
     * It should represents a chain of responsibility combined from another handlers.
     * The format: commonRequestHandler = handler1.setSuccessor(handler2.setSuccessor(...))
     * The combining method setSuccessor may has another name
     */
    final static RequestHandler commonRequestHandler = wrapInTransactionTag.andThen(createDigest).andThen(wrapInRequestTag);


    public static void main(String[] args) {
        Request request = new Request("test");
        request = commonRequestHandler.handle(request);
        System.out.println(request.getData());
    }

}

/**
 * It represents a handler and has two methods: one for handling requests and other for combining handlers
 */
@FunctionalInterface
interface RequestHandler {

    Request handle(Request request);

    default RequestHandler andThen(RequestHandler var1) {
        return (var2) -> {
            return var1.handle(this.handle(var2));
        };
    }
}

/**
 * Immutable class for representing requests.
 * If you need to change the request data then create new request.
 */
class Request {
    private final String data;

    public Request(String requestData) {
        this.data = requestData;
    }

    public String getData() {
        return data;
    }
}
