<%-- 
    Document   : layout_main
    Created on : Oct 12, 2013, 6:40:20 PM
    Author     : Marc Lytle
--%>

<%@page contentType="text/html;charset=ISO-8859-1" language="java"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<s:layout-definition>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <title>${title}</title>
        <link rel="stylesheet" href="${contextPath}/css/ui-lightness/jquery-ui-1.10.3.custom.css"/>
        <script src="${contextPath}/js/jquery-1.9.1.js"></script>
        <script src="${contextPath}/js/jquery-ui-1.10.3.custom.js"></script>
        <script src="${contextPath}/js/date_picker.js"></script>
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/styles.css">
 
    </head>
    <body>
       
        <div id="container">
                        <div id="middle">
            <div id="header">
                <div  class="page_width">
                    <img src="${contextPath}/images/logo5.png" />
                    <div id="nav1">
                      <ul id="nav">
                        <li><a href="/licensing/home">Home</a></li>
                        <li>
                            <a href="#">Products</a>
                                <ul>
                                    <li><a href="/licensing/product">Add Product</a></li>
                                    <li><a href="/licensing/product/list">List Products</a></li>
                                </ul>
                        </li>
                            <li><a href="#">Customers</a>
                                <ul>
                                    <li><a href="/licensing/customer">Add Customer</a></li>
                                    <li><a href="/licensing/customer/list">List Customers</a></li>
                                </ul>
                            </li>
                            <li><a href="#">License</a>
                                <ul>
                                    <li><a href="/licensing/license">Add License</a></li>
                                    <li><a href="/licensing/license/list">List License</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Activations</a>
                                <ul>
                                    <li><a href="/licensing/license/list_activations">List Activations</a></li>
                                </ul>
                            </li>
                     
                      </ul>
                    </div>
                </div>
            </div>
            <!--<div class="banner">
                <img src="${contextPath}/images/decoration.svg"/>
            </div>-->
            
                <div class="page_width">
                    
                    <div id="main_body">
                        <s:messages/>
                       <s:layout-component name="body"/>
                    </div>

                    <br>
                </div>
            </div>
        
            <div id="footer">
                Copyright 2013
            </div>
        </div>
    </body>
</html>
</s:layout-definition>
