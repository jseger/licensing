<%-- 
    Document   : product_added
    Created on : Oct 29, 2013, 9:17:18 PM
    Author     : marc2
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Product Added">
  <s:layout-component name="body">
      <table>
          <tr>
              <td>Product: </td>
              <td>${actionBean.product.name}</td>
          </tr>
          <tr>
              <td>Unique Id: </td>
              <td>${actionBean.product.uniqueId}</td>
          </tr>
          <tr>
              <td>Description: </td>
              <td>${actionBean.product.description}</td>
          </tr>
      </table>
  </s:layout-component>
</s:layout-render>
