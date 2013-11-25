<%-- 
    Document   : search_products
    Created on : Nov 8, 2013, 5:46:27 PM
    Author     : Marc Lytle
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Search Products">
  <s:layout-component name="body"> 
      <table id="search">
              <tr>
                  <th>Name</th>
                  <th>Description</th>
                  <th>ID</th>
              </tr>
              
                  <c:forEach items="${actionBean.products}" var="prod" varStatus="loop">
                      <tr>
                          <td>${prod.name}</td>
                          <td>${prod.description}</td>
                          <td>${prod.uniqueId}</td>
                      </tr>
                  </c:forEach>
              
          </table>
  </s:layout-component>
</s:layout-render>
