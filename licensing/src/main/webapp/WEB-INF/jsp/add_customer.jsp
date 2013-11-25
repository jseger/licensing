<%-- 
    Document   : add_customer.jsp
    Created on : Oct 19, 2013, 6:52:19 PM
    Author     : marc lytle
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Customer">
  <s:layout-component name="body">
      <s:form beanclass="com.franklin.licensing.action.CustomerActionBean">
          <table class="form">
              <tr>
                  <td>Email:</td>
                  <td><s:text name="customer.email"/></td>
              </tr>
              <tr>
                  <td>Name:</td>
                  <td><s:text name="customer.name"/></td>    
              </tr>
              <tr>
                  <td></td>
                  <td>
                      <s:submit name="save" value="Save"/>
                      <s:submit name="cancel" value="Cancel"/>
                  </td>
              </tr>
          </table>
      </s:form>
  </s:layout-component>
</s:layout-render>