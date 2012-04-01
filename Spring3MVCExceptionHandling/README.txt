In web application, it’s always recommended to display a custom friendly error pages instead of stack traces.  

This is a simple application that shows how to handle exceptions through:

1) defining error codes in web.xml
2) implementing HandlerExceptionResolver and creating custom handlers to do some special logic.
3) defining exception types with SimpleMappingExceptionResolver
4) using @ExceptionHandler annotation in the controller

By using these techniques, you can catch exceptions thrown by multiple controllers in one place.
 
