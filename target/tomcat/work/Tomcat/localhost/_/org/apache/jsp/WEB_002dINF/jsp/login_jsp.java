/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-26 13:34:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/common.jsp", out, false);
      out.write("\r\n");
      out.write("    <title>用户登陆</title>\r\n");
      out.write("    <link rel=\"stylesheet\"\r\n");
      out.write("          href=\"/css/login.css\"/>\r\n");
      out.write("    <style>\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"form_login\">\r\n");
      out.write("    <div class=\"form_logo\">\r\n");
      out.write("        <h1>权限管理系统</h1>\r\n");
      out.write("    </div>\r\n");
      out.write("    <form method=\"post\" id=\"formlogin\" >\r\n");
      out.write("        <input type=\"hidden\" name=\"id\" value=\"0\">\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <i class=\"fa fa-user\"></i> <input type=\"text\" class=\"form-control\"\r\n");
      out.write("                                              name=\"username\" id=\"username\" placeholder=\"输入工号\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <i class=\"fa fa-key\"></i> <input type=\"password\"\r\n");
      out.write("                                             class=\"form-control\" name=\"password\" id=\"password\"\r\n");
      out.write("                                             placeholder=\"输入密码\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <input type=\"hidden\" name=\"salt\" value=\"0\">\r\n");
      out.write("        <!--  <div class=\"form-group\" style=\"height:25px; line-height:25px; text-align:left;\">\r\n");
      out.write("        <input type=\"checkbox\" name=\"checkbox\" id=\"checkbox\">\r\n");
      out.write("        <span class=\"checkfont\">记住我的帐号</span>\r\n");
      out.write("    </div> -->\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <div> </div>\r\n");
      out.write("            <div> </div>\r\n");
      out.write("            <div> </div>\r\n");
      out.write("            <button type=\"button\" id=\"loginsubmit\"\r\n");
      out.write("                    class=\"btn-sm btn-primary btn-login\" onclick=\"mylogin()\">登录\r\n");
      out.write("            </button>\r\n");
      out.write("            <button type=\"button\" id=\"registerSubmit\"\r\n");
      out.write("                    class=\"btn-sm btn-primary btn-login\" onclick=\"myRegister()\">注册\r\n");
      out.write("            </button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("    <div class=\"form_footer\">\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  /* function mylogin() {\r\n");
      out.write("        var employeeId = $(\"#employeeId\").val();\r\n");
      out.write("        var password = $(\"#password\").val();\r\n");
      out.write("        if (\"\" == employeeId || undefined == employeeId) {\r\n");
      out.write("            alert(\"工号不能为空\");\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("        if (\"\" == password || undefined == password) {\r\n");
      out.write("            alert(\"密码不能为空\");\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        var data = {};\r\n");
      out.write("        data.employeeId = employeeId;\r\n");
      out.write("        data.password = password;\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            type: 'post',\r\n");
      out.write("            url: 'LoginServlet?method=loginCheck',\r\n");
      out.write("            data: data,\r\n");
      out.write("            cache: false,\r\n");
      out.write("            sync: true,\r\n");
      out.write("            success: function (msg) {\r\n");
      out.write("                var json = JSON.parse(msg);\r\n");
      out.write("                if (0 == json.status) {\r\n");
      out.write("                    alert(\"工号或密码错误\");\r\n");
      out.write("                } else {\r\n");
      out.write("                    //alert(\"1\");\r\n");
      out.write("                    $(\"#formlogin\").submit();\r\n");
      out.write("                }\r\n");
      out.write("            },\r\n");
      out.write("            error: function () {\r\n");
      out.write("                alert(\"请求失败!\");\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }*/\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   function myRegister() {\r\n");
      out.write("\r\n");
      out.write("       $(\"#formlogin\").attr(\"action\", \"/login/addUser\").submit();\r\n");
      out.write("\r\n");
      out.write("   }\r\n");
      out.write("\r\n");
      out.write("  function mylogin() {\r\n");
      out.write("\r\n");
      out.write("      $(\"#formlogin\").attr(\"action\", \"/login/login\").submit();\r\n");
      out.write("\r\n");
      out.write("  }\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
