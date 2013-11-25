<%-- 
    Document   : search_activations
    Created on : Nov 8, 2013, 7:08:39 PM
    Author     : Marc Lytle
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Search Activations">
  <s:layout-component name="body">
      <table id="search">
              <tr>
                  <th>Customer Name</th>
                  <th>Product Name</th>
                  <th>Activation Date</th>
                  <th>Machine Id</th>
              </tr>
              
                  <c:forEach items="${actionBean.activations}" var="act">
                      <tr>
                          <td>${act.license.customer.name}</td>
                          <td>${act.license.product.name}</td>
                          <td>${act.activationDate}</td>
                          <td>${act.fingerprint}</td>
                      </tr>
                  </c:forEach>
              
          </table>
  </s:layout-component>
</s:layout-render>