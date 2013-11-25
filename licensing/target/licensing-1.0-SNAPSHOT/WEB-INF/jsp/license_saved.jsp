<%-- 
    Document   : license_saved
    Created on : Nov 1, 2013, 5:23:08 PM
    Author     : marc2
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Product Added">
  <s:layout-component name="body">
      <table>
          <tr>
              <td>Expiration Date: </td>
              <td>${actionBean.license.expirationDate}</td>
          </tr>
          <tr>
              <td>License Key: </td>
              <td>${actionBean.license.licenseKey}</td>
          </tr>
      </table>
  </s:layout-component>
</s:layout-render>