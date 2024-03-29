<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp"%>

    <script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery.openid.js'/>"></script>

  <c:if test="${param.status == 'error'}">
    <table class="errorMessages">
      <tr>
        <td>
          <ul>
                <li><spring:message code="jsp.login.error.errorMessage"/></li>
          </ul>
        </td>
      </tr>
    </table>
  </c:if>


    <div id="tabs">
        <ul>
            <li><a href="#username-password-registration">Username/Password Login</a></li>
        </ul>
        <div id="username-password-registration">
              <form  name="j_spring_security_check" id="j_acegi_security_check" method="POST" action="j_spring_security_check">
                  <fieldset id="loginSection" style="margin-left: 1em; margin-right: 1em;">
                      <legend>Login</legend>
                      <div class="required" style="margin-top: 2em;">
                        <label for="j_username"><spring:message code="class.user.email" /></label>
                        <s:textfield id="j_username" name="j_username" required="true" maxlength="50" tabindex="1"
                                         onblur="javascript:this.className='';"
                                         onfocus="javascript:this.className='selected';"/>
                      </div>
                      <div class="required">
                        <label for="j_password"><spring:message code="class.user.password" /></label>
                        <s:password id="j_password" name="j_password" required="true" maxlength="120" tabindex="2"
                                         onblur="javascript:this.className='';"
                                         onfocus="javascript:this.className='selected';"/>
                      </div>
                      <div class="submit">
                              <input type="submit" value="<spring:message code="jsp.login.button.login"/>"/>
                              <input type="submit" onClick="location.href='<c:url value='/'/>'; return false;" value="<spring:message code="jsp.login.button.cancel"/>"/>
                      </div>

                        <ul id="loginOptions" style="clear: left;">
                            <li class="registration">
                                <img src="${ctx}/images/icons/crystal/add_user.png"/>
                                <s:url action="signup" namespace="registration" id="signupUrl" includeParams="none"/>
                              <a href="${signupUrl}"><spring:message code="jsp.login.addUser"/></a>
                            </li>
                            <li class="getPassword">
                              <img src="${ctx}/images/icons/crystal/mail_get.png"/>
                              <s:url action="get-password" namespace="/" id="getPasswordUrl" includeParams="none"/>
                              <a href="${getPasswordUrl}"><spring:message code="jsp.login.forgotYourPassword"/></a>
                            </li>
                        </ul>
                  </fieldset>
              </form>
        </div>
    </div>

<script type="text/JavaScript" language="JavaScript">
<!--
$(function() {
    $("#tabs").tabs();
    $('#j_username').focus();
    $('table.errorMessages').width($('.content').width());

    $("form.openid:eq(0)").openid();

    $(".providers").fadeIn();

});
//-->
</script>
