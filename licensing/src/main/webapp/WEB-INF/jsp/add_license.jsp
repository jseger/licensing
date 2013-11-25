<%@page import="java.util.*" %>
<%-- 
    Document   : add_license
    Created on : Oct 29, 2013, 7:44:06 PM
    Author     : marc2
--%>



<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="License">
  <s:layout-component name="body">
      <s:form beanclass="com.franklin.licensing.action.LicenseActionBean">
          <table class="form">
               <tr>
                   <td style="text-align: right;">Products: </td>
                   <td>
                   <s:select name="selectedProductId">
                       <s:option value="">Select Product:</s:option>
                       <s:options-collection collection="${actionBean.products}" value="id" label="name"/>
                   </s:select>
                   </td>
               </tr>
               <tr>     
                   <td style="text-align: right;">User: </td>
                    <td>
                    <s:select name="selectedCustomerId">
                       <s:option value="">Select Customer</s:option>
                       <s:options-collection collection="${actionBean.customers}" value="id" label="name" />
                   </s:select>
                   </td>
              </tr>
              <tr>
                  <td style="text-align: right;">
                      Expiration Date:
                  </td>
                  <td>
                      <s:text name="license.expirationDate" formatPattern="MM/dd/yy" id="datepicker"/>
                  </td>
              </tr>
              <tr>
                  <td style="text-align: right;">Max. Activations: </td>
                  <td>
                      <s:text name="license.maxActivations" />
                  </td>
              </tr>
              <tr>
                  <td colspan="2" style="text-align: right;">
                      <s:submit name="save" value="Save"/>
                      <s:submit name="cancel" value="Cancel"/>
                  </td>
              </tr>
          </table>
      </s:form>
  </s:layout-component>
</s:layout-render>
