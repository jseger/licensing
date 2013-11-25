<%-- 
    Document   : search_customers
    Created on : Nov 8, 2013, 6:59:58 PM
    Author     : Marc Lytle
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Search Customers">
  <s:layout-component name="body">
      <table id="search">
              <tr>
                  <th>Name</th>
                  <th>Email</th>
              </tr>
              
                  <c:forEach items="${actionBean.customers}" var="cust">
                      <tr>
                          <td>${cust.name}</td>
                          <td>${cust.email}</td>
                      </tr>
                  </c:forEach>
              
          </table>
  </s:layout-component>
</s:layout-render>
