<%-- 
    Document   : add_product
    Created on : Oct 26, 2013, 4:23:02 PM
    Author     : marc2
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Product">
  <s:layout-component name="body">
      <s:form beanclass="com.franklin.licensing.action.ProductActionBean">
          <table class="form">
              <tr>
                  <td>Product Name:</td>
                  <td><s:text name="product.name" style="width: 220px"/></td>    
              </tr>
               <tr>
                  <td style="vertical-align: text-top">Product Desc:</td>
                  <td><s:textarea name="product.description" rows="8" cols="25"/></td>    
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
