<%-- 
    Document   : jesse
    Created on : Sep 24, 2013, 10:18:50 AM
    Author     : jesse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator</title>
    </head>
    <body>
        
        <h1>Hello Team!</h1>
        
        <h2>This is a simple calculator utilizing Stripes.</h2>
        
        <stripes:form beanclass="com.franklin.licensing.action.CalculatorActionBean" focus="">
            <table>
                <tr>
                    <td>Number 1:</td>
                    <td><stripes:text name="number1"/></td>
                </tr>
                <tr>
                    <td>Number 2:</td>
                    <td><stripes:text name="number2"/></td>
                </tr>
                <tr>
                    <td colspan='2'>
                        <stripes:submit name="addition" value="Add"/>
                    </td>
                </tr>
                <tr>
                    <td colspan='2'>
                        <stripes:submit name="subtraction" value="Subtract"/>
                    </td>
                </tr>
                <tr>
                    <td colspan='2'>
                        <stripes:submit name="multiply" value="Multiply"/>
                    </td>
                </tr>
                <tr>
                    <td>Result:</td>
                    <td>${actionBean.result}</td>
                </tr>
            </table>
        </stripes:form>       
    </body>
</html>
