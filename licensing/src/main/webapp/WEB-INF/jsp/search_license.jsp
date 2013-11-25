<%-- 
    Document   : search_license
    Created on : Nov 12, 2013, 7:54:39 PM
    Author     : Marc Lytle
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Search Licenses">
  <s:layout-component name="body"> 
      <table id="search">
              <tr>
                  <th>Customer </th>
                  <th>Product </th>
                  <th>License Key</th>
                  <th>Exp. Date</th>
                  <th>Max. Act.</th>
              </tr>
              
                  <c:forEach items="${actionBean.licenses}" var="lic" varStatus="loop">
                      <tr>
                          <td style="vertical-align: top;">${lic.customer.name}</td>
                          <td style="vertical-align: top;">${lic.product.name}</td>
                          <td style="vertical-align: top;">${lic.licenseKey}</td>
                          <td style="vertical-align: top;"><fmt:formatDate value="${lic.expirationDate}" dateStyle="short" pattern="MM-dd-yy"/></td>
                          <td style="vertical-align: top;">${lic.maxActivations}</td>
                      </tr>
                  </c:forEach>
              
          </table>
  </s:layout-component>
</s:layout-render>
